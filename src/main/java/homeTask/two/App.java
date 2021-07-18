package homeTask.two;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        System.out.println(sixth(new int[]{4,5,6,7}));
    }

    private static void first() {
        for (int i = 1; i < 100; i++) {
            System.out.println(i);
        }
    }

    private static void second() {
        for (int i = 1; i < 101; i++) {
            if(i % 3 == 0) System.out.println("divided by 3: " + i);
            if(i % 5 == 0) System.out.println("divided by 5: " + i);
            if(i % 3 == 0 && i % 5 == 0) System.out.println("divided by 3 and 5: " + i);
        }
    }

    private static void third() {
        Scanner sc = new Scanner(System.in);

        int count = 1;
        int[] ints = new int[3];
        while (count < 4) {
            System.out.println("Введите "+ count +" число (целое).");
            if(sc.hasNextInt()){
                ints[count-1] = sc.nextInt();
                count++;
            } else {
                System.out.println("Ну и что ты наделал....");
                break;
            }
        }

        System.out.println(ints[0] + ints[1] == ints[2]);
    }

    private static void fourth() {
        Scanner sc = new Scanner(System.in);

        int count = 1;
        int[] ints = new int[3];
        while (count < 4) {
            System.out.println("Введите "+ count +" число (целое).");
            if(sc.hasNextInt()){
                ints[count-1] = sc.nextInt();
                count++;
            } else {
                System.out.println("Ну и что ты наделал....");
                break;
            }
        }

        System.out.println(ints[0] < ints[1] && ints[1] < ints[2]);
    }

    private static boolean fifth(int[] nums) {
        //является ли число 3 как первый ИЛИ последний элемент массива
        if(nums.length < 2) return false;

        boolean res = true;
        if(nums[0] != 3 & nums[nums.length-1] != 3)res = false;
        return res;
    }

    private static boolean sixth(int[] nums) {
        if(nums.length == 0) return false;

        boolean res = false;
        for(int el: nums) {
            if(el == 1 | el == 3) {
                res = true;
                break;
            }
        }

        return res;
    }
}
