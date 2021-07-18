package homeTask.eight;

public abstract class Shape implements Comparable<Shape>{
    abstract double getVolume();

    @Override
    public int compareTo(Shape shape) {
        return Double.compare(getVolume(), shape.getVolume());
    }
}
