package homeTask.eight;

public class Pyramid extends Shape{
    private double height;
    private double area;

    public Pyramid(double height, double area) {
        this.height = height;
        this.area = area;
    }

    @Override
    public double getVolume() {
        return height * area * 4 / 3;
    }
}
