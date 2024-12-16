import java.util.Arrays;

public class Polyline {
    //поля
    private Point[] points;

    // Свойства
    public Point[] getPoints() {
        return points;
    }

    //конструкторы
    public Polyline() {
        this.points = new Point[0];;
    }

    public Polyline(Point[] points) {
        this.points = points;
    }

    //методы
    public String toString() {
        return "Линия " + Arrays.toString(points);
    }

}