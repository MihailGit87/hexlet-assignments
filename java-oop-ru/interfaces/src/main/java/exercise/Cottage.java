package exercise;

// BEGIN
public class Cottage implements Home{
    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " +
                area +" метров";
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home anotherHome) {
        if (getArea() > anotherHome.getArea()) {
            return 1;
        } else if (getArea() < anotherHome.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
// END
