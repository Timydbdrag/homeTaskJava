package homeTask.fourth;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        System.out.println(fifth("Этот тексБяка ищем Бяк Бяка"));

    }

    private static String first(String[] arr) {
        int ind = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i].length()){
                max = arr[i].length();
                ind = i;
            }
        }
        return arr[ind];
    }

    private static boolean second(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return sb.toString().equals(s);
    }

    private static String third(String s) {
        String find = "Бяка";

        int last = 0;
        List<Integer> repl = new ArrayList<>();

        while (last != -1) {
            last = s.indexOf(find,last);

            if(last!=-1) {
                repl.add(last);
                last++;
            }
        }

        String censorship = "[вырезано цензурой]";
        StringBuilder sb = new StringBuilder(s);

        for (int i = repl.size()-1; i >= 0; i--) {
            int t = repl.get(i);
            sb.replace(t, t+4 ,  censorship);
        }

        return sb.toString();
    }

    private static int fourth(String s, String find) {
        int last = 0;
        int count = 0;

        while (last != -1) {
            last = s.indexOf(find,last);
            if(last!=-1) {
                count++;
                last++;
            }
        }
        return count;
    }

    private static String fifth(String s) {
        //очень тривиально
        String[] s1 = s.split(" ");

        StringBuilder response = new StringBuilder();

        for (int i = 0; i < s1.length; i++) {
            StringBuilder sb = new StringBuilder(s1[i]);
            response.append(sb.reverse());
            if(i!= s1.length-1) response.append(" ");
        }

        return response.toString();
    }
}
