package homeTask.seven;

public class Truck extends Car{
    private int wheelsCount;
    private int weightLimit;

    public Truck(int w, String m, char c, float s, int wheelCount, int weightLimit) {
        super(w, m, c, s);
        this.wheelsCount = wheelCount;
        this.weightLimit = weightLimit;
    }

    public int getWheelCount() {
        return wheelsCount;
    }

    public void newWheels(int wheelCount) {
        this.wheelsCount = wheelCount;
        System.out.println("new number of wheels: " + wheelCount);
    }
}
