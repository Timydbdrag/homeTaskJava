package homeTask.seven;

public class App {
    public static void main(String[] args) {
 //       Truck truck = new Truck(12000, "Test", 'f', 100, 10, 20000);

        Box box = new Box(100);
        System.out.println("box volume: " +box.volume);

        Cylinder cylinder = new Cylinder();
        cylinder.volume = 40;
        boolean add = box.add(cylinder);
        System.out.println(add);
        System.out.println("box volume: " +box.volume);

        Pyramid pyramid = new Pyramid();
        pyramid.volume = 70;
        boolean add1 = box.add(pyramid);
        System.out.println(add1);
        System.out.println("box volume: " +box.volume);
    }
}
