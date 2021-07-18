package homeTask.ten;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

 /*       long start = System.currentTimeMillis();
        List<Integer> arrayList = createArrayList(1000000);
        List<Integer> random = getRandom(arrayList, 100000);
        long end = System.currentTimeMillis();
        System.out.println(end-start + " ms");

        long start1 = System.currentTimeMillis();
        List<Integer> linkedList = createLinkedList(1000000);
        List<Integer> random2 = getRandom(linkedList, 100000);
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1 + " ms");*/

      //  third();


    }

    private static <T> Collection<T> first(Collection<T> l) {
        return new HashSet<>(l);
    }

    private static List<Integer> createArrayList(int count) {
        List<Integer> res = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            res.add(i);
        }
        return res;
    }

    private static List<Integer> createLinkedList(int count) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            res.add(i);
        }
        return res;
    }

    private static List<Integer> getRandom(List<Integer> arr, int getCount){

        int step = arr.size() / 10;
        Random random = new Random();
        List<Integer> res = new ArrayList<>(getCount);

        for (int i = 0; i < arr.size(); i+=step) {
            int x = ((int)(Math.random() * i)) ;
            res.add(arr.get(x));
        }

        return res;
    }

    private static void third() {
        Map<User, Integer> users = new HashMap<>();
        users.put(new User("Ivan"), 5);
        users.put(new User("Anna"), 9);
        users.put(new User("Oleg"), 12);
        users.put(new User("Max"), 7);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя");
            String next = sc.next();
            if(next.equals("-1")) break;

            System.out.println(users.get(new User(next)));
        }
        System.out.println("Exit");
    }

    private static <K> Map<K, Integer> arrayToMap(K[] arr) {
        Map<K,Integer> res = new HashMap<>();

/*        for(K k: arr) {
            if(res.containsKey(k)) {
                res.put(k, res.get(k) +1);
            } else {
                res.put(k,1);
            }
        }*/

/*        Set<K> uniq = new HashSet<K>(Arrays.asList(arr));
        for (K key : uniq) {
            res.put(key, Collections.frequency(Arrays.asList(arr), key));
        }*/

  //      Map<K, Long> res = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(K k : arr) {
            res.compute(k, (k1, count) -> count == null ? 1 : count + 1);
        }

        return res;
    }

}
