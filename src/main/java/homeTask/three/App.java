package homeTask.three;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int[] nums = {1,2,4,3,5,5};
        //System.out.println(ifUpSort(nums));

        //newArr();

        // replacer(nums);
        //System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(createArray(20)));

    }

    private static String ifUpSort(int[] arr) {
        String res = "OK";
        if(arr.length == 1) return res;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] > arr[i]) {
                res = "Please, try again";
                break;
            }
        }
        return res;
    }

    private static void newArr(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Укажите длинну массива. Введите целое положительное число!");

        if (sc.hasNextInt()) {
            int length = sc.nextInt();
            if(length < 1) {
                System.out.println("Тяжело с тобой! Попробуй еще разок");
            } else {
                Scanner arr = new Scanner(System.in);
                System.out.println("Ввкдите подряд " + length + " целых чисел");

                String s = arr.nextLine();

                if(s.length() > length || s.length() < length) System.out.println("Учимся считать!");
                else {
                    int[] nums = new int[length];
                    int i = 0;

                    for(char el : s.toCharArray()) {
                        if(!Character.isDigit(el)){
                            System.out.println(el + " <- что это? Ты дурачёк?");
                        } else {
                            nums[i++] = Character.getNumericValue(el);
                        }
                    }

                    System.out.println(Arrays.toString(nums));
                }
            }

        } else {
            System.out.println("Я же сказал, целое число! Попробуйте снова!");
        }
    }

    private static void replacer(int[] arr) {
        if(arr.length > 1) {
            int t = arr[0];
            arr[0] = arr[arr.length-1];
            arr[arr.length-1] = t;
        }
    }

    private static int firstUnique(int[] nums) {
        //исходя из условий задачи, гарантируется, что в массиве есть уникальное число
        //не самый лучший способ поиска, в худшем случае квадратичная сложность

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = 1;
            for (int j = 0; j < nums.length; j++) {
                if(i != j && nums[i] == nums[j]) t++;
            }
            if(t == 1) {
                res = nums[i];
                break;
            }
        }
        return res;
    }

    private static long fibonacci(int n) {
        long s1 = 0;
        long s2 = 1;

        if(n == 1) return s1;
        if(n == 2) return s2;

        for (int i = 2; i < n; i++) {
            long t = s2;
            s2 += s1;
            s1 = t;
        }
        return s2;
    }

    private static int[] createArray(int count){
        int[] array = new int[12];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * count));
        }
        mergeSort(array, array.length);
        return array;
    }

    public static void mergeSort(int[] a, int n) {
        if (n<2) return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}
