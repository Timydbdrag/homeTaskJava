package main.java.homeTask;

public class OneTask {

    public static void main(String[] args) {
        double target = 16d;
        double x = sqrt(target);
        System.out.println(x);
        System.out.println(x*x);
    }

    //Heron's iterative formula
    private static double sqrt(double target){
        double x = 1;
        double oldx;
        do {
            oldx = x;
            x = (x + target / x) / 2;
        }
        while (oldx != x);
        return x;
    }
}
