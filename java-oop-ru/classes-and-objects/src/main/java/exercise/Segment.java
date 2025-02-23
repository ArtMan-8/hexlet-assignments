package exercise;

// BEGIN
public class Segment {
    private Point a;
    private Point b;

    public Segment(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getBuginPoint() {
        return a;
    }

    public Point getEndPoint() {
        return b;
    }

    public Point getMidPoint() {
        return new Point((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
    }
}
// END
