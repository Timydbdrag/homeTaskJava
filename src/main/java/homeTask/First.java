package homeTask;

import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        //first();
        second();
        third();
        fourth();
        fifth();
        sixth();
    }

    private static void first(){
        String[] arr = new String[]{"Я", "хорошо", "знаю", "Java."};
        for (String el:arr) {
            System.out.println(el);
        }
    }

    private static void second() {
        System.out.println((46 + 10) * (10 / 3));
        System.out.println((29) * (4) * (-15));
    }

    public static void third() {
        int number = 10500;
        int result = (number / 10) / 10;
        System.out.println(result);
    }

    private static void fourth() {
        float a = 3.6f,b = 4.1f,c = 5.9f;
        float result = a * b * c;
        System.out.println(result);
    }

    private static void fifth() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 5 целых чисел");
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            if(sc.hasNextInt()) {
                nums[i] = sc.nextInt();
            } else {
                sc.next();
                System.out.println( "Что это было?");
            }
        }
        for (int it:nums) {
            System.out.println(it);
        }

  /*      while (true) {
            if(sc.hasNextInt()) {
                System.out.println(sc.nextInt());
            } else {
                System.out.println("Я просил целое число!");
                break;
            }
        }*/
    }

    private static void sixth() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число");

        if (sc.hasNextInt()) {
            int i = sc.nextInt();
            if(i%2!=0) {
                System.out.println("Неетное");
            } else if(i > 100){
                System.out.println("Выход за пределы диапазона");
            } else {
                System.out.println("Четное");
            }
        } else {
            System.out.println("это провал!");
        }
    }
}

