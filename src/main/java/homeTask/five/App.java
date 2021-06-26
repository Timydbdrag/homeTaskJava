package main.java.homeTask.five;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateVectors(5)));
    }

    private static Vector[] generateVectors(int length) {
        Vector[] arr = new Vector[length];

        for (int i = 1; i <= length; i++) {
            arr[i-1] = new Vector(Math.round(Math.random() * i * length),
                    Math.round(Math.random() * i * length),
                    Math.round(Math.random() * i* length));
        }
        return arr;
    }
}
