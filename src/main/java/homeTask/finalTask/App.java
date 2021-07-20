package homeTask.finalTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Укажите входные параметры! (пример: 3 output_folder info.txt)");
            System.exit(10);
        }

        int threadCount = Integer.parseInt(args[0]);
        String outPathRoot =  args[1];
        String info = args[2];

        createDirectory(outPathRoot);
        master(threadCount, outPathRoot, info);
    }

    private static void master(int threadCount, String outPathRoot, String info) {
        Map<String, List<String>> stringListMap = readInfo(info);
        List<String> loadInfo = new ArrayList<>();

        ExecutorService executors = Executors.newFixedThreadPool(threadCount);
        stringListMap.forEach((k,v) -> {
            executors.submit(() -> {
                try {
                    loadInfo.add(worker(outPathRoot, k, v));
                } catch (Exception e) {
                    System.out.println("Что-то пошло не так");
                    System.out.println(e.getMessage());
                }
            });
        });

        executors.shutdown();
        try {
            if (!executors.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                executors.shutdown();
            }
        } catch (InterruptedException e) {
            executors.shutdownNow();
        }

        System.out.println("____________________________________________");
        loadInfo.forEach(System.out::println);
    }

    private static String worker(String outPathRoot, String link, List<String> saveName) throws IOException {
        if(saveName.get(0) == null) throw new LoaderException("File name not specified to save!");

        URL url = new URL(link);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());

        String name = link.substring(link.lastIndexOf("/")+1);
        System.out.println("Загружается файл: " + name);

        long start = System.currentTimeMillis();

        String firstName = outPathRoot + "/" + saveName.get(0);

        FileOutputStream fileOutputStream = new FileOutputStream(firstName);
        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

        float end = (System.currentTimeMillis() - start) / 1000f;
        float size = (fileOutputStream.getChannel().size() / 1024f) / 1024f;
        double result = Math.ceil(size * 100) / 100;
        String res = "Файл " + name + " загружен: " + result + " Mb за " + end +" секунд";

        for (int i = 1; i < saveName.size(); i++) {
            copyFile(firstName, outPathRoot + "/" + saveName.get(i));
        }
        return res;
    }

    private static void createDirectory(String directory) {
        boolean res = false;
        File theDir = new File(directory);
        if (!theDir.exists()){
           res = theDir.mkdirs();
        }
        if(res) System.out.println("create directory: \"" + directory + "\".");
    }

    private static void copyFile(String inFile, String outFile) {
        Path in = Paths.get(inFile);
        Path out = Paths.get(outFile);

        try {
            Files.copy(in, out, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<String>> readInfo(String file) {
        Map<String, List<String>> info = new HashMap<>();

        try {
            Path path = Paths.get(file);
            Stream<String> lines = Files.lines(path);

            lines.forEach(el -> {
                if(!el.trim().equals("")) {
                    String[] s = el.split(" ");
                    if (info.containsKey(s[0])) {
                        List<String> strings = info.get(s[0]);
                        strings.add(s[1]);
                    } else {
                        List<String> list = new ArrayList<>(Arrays.asList(s[1]));
                        info.put(s[0], list);
                    }
                }
            });

            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    private static void loader(String urlPath, String savePath) throws IOException {
        URL url = new URL(urlPath);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());

        FileOutputStream fileOutputStream = new FileOutputStream(savePath);

        fileOutputStream.getChannel()
                .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    }
}
