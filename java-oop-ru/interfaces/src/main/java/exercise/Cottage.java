package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }

    public double getArea() {
        return area * floorCount;
    }

    public int compareTo(Home another) {
        return Double.compare(getArea(), another.getArea());
    }
}
// END
