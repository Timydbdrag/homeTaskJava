package main.java.homeTask.five;

public class Vector {
    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt((x*x) + (y*y) + (z*z));
    }

    public double scalar(Vector v) {
        return (x*v.x) + (y*v.y) + (z*v.z);
    }

    public Vector multiplication(Vector v) {
       return new Vector(y * v.z - z * v.y, z * v.x - x * v.z, x*v.y - y*v.x);
    }

    public double cosAngle(Vector v) {
        return scalar(v) / (length() * v.length());
    }

    public Vector sum(Vector v) {
        return new Vector(x+v.x, y+v.y, z+v.z);
    }

    public Vector difference(Vector v) {
        return new Vector(x-v.x, y-v.y, z-v.z);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
