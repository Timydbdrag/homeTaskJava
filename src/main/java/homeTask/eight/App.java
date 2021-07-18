package homeTask.eight;

import java.util.ArrayList;
import java.util.Collections;

public class App {

    public static void main(String[] args) {
        Pyramid pyramid = new Pyramid(40, 10);
        Ball ball = new Ball(2);
        Cylinder cylinder = new Cylinder(3, 1);

        Box box = new Box(1000);

        System.out.println(box.add(pyramid));
        System.out.println(box.add(ball));
        System.out.println(box.add(cylinder));


        ArrayList<Shape> shapes = box.getShapes();
        Collections.sort(shapes);
    }
}
