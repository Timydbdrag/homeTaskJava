package homeTask.seven;

public class Box extends Shape{

    public Box(double v) {
        super.volume = v;
    }

    public boolean add(Shape shape) {
        if(super.volume < shape.volume) return false;

        super.volume -= shape.volume;
        return true;
    }


}
