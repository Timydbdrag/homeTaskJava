package homeTask.nine;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 2}, {5, 6},{9,9}};

        // System.out.println(first(nums));
       // System.out.println(second(nums));
       // System.out.println(third(nums));

        char[][] arr = new char[3][4];
        fourth(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    private static int first(int[][] nums) {
        int max = nums[0][0];

        for (int[] num : nums) {
            for (int i : num) {
                if (i > max) max = i;
            }
        }
        return max;
    }

    private static boolean second(int[][] nums) {
        //истина, если матрица является квадратом
        for (int[] num: nums) {
            if(num.length!=nums.length) return false;
        }
        return true;
    }

    private static int third(int[][] nums) {
        //возвращает индекс строки сумма элементов которой является максимальной
        int ind = 0;
        int max = nums[0][0];
        for (int i = 0; i < nums.length; i++) {
            if(Arrays.stream(nums[i]).sum() > max) {
                max = Arrays.stream(nums[i]).sum();
                ind = i;
            }
        }
        return ind;
    }

    private static void fourth(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rndChar();
            }
        }
    }

    private static char rndChar () {
        //a-z, A-Z
        int rnd = (int) (Math.random() * 52);
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);
    }


}
