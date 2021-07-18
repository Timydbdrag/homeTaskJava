package homeTask.eleven;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        //System.out.println(first("src/eleven.txt"));
        //second("src/eleven2.txt", "test write");
        // third("src/eleven.txt", "src/eleven2.txt", "src/eleven3.txt");
        // fourth("src/eleven3.txt", "src/eleven3Copy.txt");

       // System.out.println(fifth("src", "eleven"));

        System.out.println(sixth("src", "hello, teacher 1!\n" +
                "hello, teacher 2!\n" +
                "hello, teacher 3!"));
    }

    private static List<String> first(String file) {
        List<String> res = new ArrayList<>();
        try {
            Path path = Paths.get(file);
            Stream<String> lines = Files.lines(path);

            lines.forEach(res::add);
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static void second(String fileName, String str) {
        try {
            RandomAccessFile stream = null;
            stream = new RandomAccessFile(fileName, "rw");
            long length = stream.length();
            stream.seek(length);
            if (length > 0) stream.write("\n".getBytes());
            stream.write(str.getBytes(StandardCharsets.UTF_8));
            stream.close();
            System.out.println("file write completed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void third(String fileName1, String fileName2, String fileForSave) {
        List<String> file = first(fileName1);
        file.addAll(first(fileName2));
        // можно использовать метод second, но он будет открывать и закрывать файл для каждой строки
        try {
            RandomAccessFile stream = null;
            stream = new RandomAccessFile(fileForSave, "rw");
            long length = stream.length();
            stream.seek(length);
            if (length > 0) stream.write("\n".getBytes());
            for (String str : file) {
                stream.write(str.getBytes(StandardCharsets.UTF_8));
                stream.write("\n".getBytes());
            }
            stream.close();
            System.out.println("file write completed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fourth(String inFile, String outFile) {
        Path in = Paths.get(inFile);
        Path out = Paths.get(outFile);

        try {
            Files.copy(in, out, StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fourthOld(String inFile, String outFile) {
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(inFile));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Set<String> fifth(String dir, String search) {
        //ищет только в указанной директории, не погружается в дерево подкаталогов
        Set<String> res = new HashSet<>();
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            res =  stream
                    .filter(file -> !Files.isDirectory(file))
                    .flatMap(el -> Stream.of(el.getFileName().toString()))
                    .filter(s -> s.contains(search))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static Set<String> sixth(String dir, String search) {
        //ищет только в указанной директории, не погружается в дерево подкаталогов
        Set<String> res = new HashSet<>();
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            res =  stream
                    .filter(file -> !Files.isDirectory(file))
                    .filter(file -> searchText(file.getParent().toString() + "/" + file.getFileName(), search))
                    .flatMap(el -> Stream.of(el.getFileName().toString()))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static boolean searchText(String filePath, String search) {
        //не самый лучший способ поиска строки, особенно в больших файлах
        boolean res = false;

        try (RandomAccessFile reader = new RandomAccessFile(filePath, "r");
             FileChannel channel = reader.getChannel();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            int bufferSize = 1024;
            if (bufferSize > channel.size()) {
                bufferSize = (int) channel.size();
            }
            ByteBuffer buff = ByteBuffer.allocate(bufferSize);

            while (channel.read(buff) > 0) {
                out.write(buff.array(), 0, buff.position());
                buff.clear();
            }

            res = out.toString(StandardCharsets.UTF_8).contains(search);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }


}
