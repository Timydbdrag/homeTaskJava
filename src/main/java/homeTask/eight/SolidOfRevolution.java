package homeTask.eight;

public abstract class SolidOfRevolution extends Shape{
    protected double radius;

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }

    @Override
    double getVolume() {
        return radius;
    }
}
