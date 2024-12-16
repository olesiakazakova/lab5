import java.util.Objects;

public class Point {
    //поля
    private double x, y;
    //свойства
    public double getX()
    {
        return this.x;
    };
    public double getY()
    {
        return this.y;
    };
    //конструкторы
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    //методы
    public String toString()
    {
        return "{" + this.x + ";" + this.y + "}";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
