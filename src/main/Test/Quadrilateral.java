import java.util.Objects;

public class Quadrilateral implements Comparable<Quadrilateral> {

    // Создаем класс под точку
    static class Point {
        private double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static double pointsDistance(Point p, Point q) { // Подсчет расстояния между точками
        return Math.sqrt(Math.pow((p.getX() - q.getX()), 2) + Math.pow(p.getY() - q.getY(), 2));
    }

    public static double distSq(Point p, Point q)
    {
        return (p.getX() - q.getX()) * (p.getX() - q.getX()) + (p.getY() - q.getY()) * (p.getY() - q.getY());
    }

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) { // Конструктор класса
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    // Поля класса и гетеры
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Point getFirst() {
        return p1;
    }
    public Point getSecond() {
        return p2;
    }
    public Point getThird() {
        return p3;
    }
    public Point getFourth() {
        return p4;
    }

    public void setFirst(Point p1) {
        this.p1 = p1;
    }
    public void setSecond(Point p2) {
        this.p2 = p2;
    }
    public void setThird(Point p3) {
        this.p3 = p3;
    }
    public void setFourth(Point p4) {
        this.p4 = p4;
    }

    public static boolean isSquare(Point p1, Point p2, Point p3, Point p4) {
        // Находим квадраты расстояний между точками
        double d2 = distSq(p1, p2);
        double d3 = distSq(p1, p3);
        double d4 = distSq(p1, p4);

        if (d2 == 0 || d3 == 0 || d4 == 0)
            return false;
        // Попарно сверяем их
        if (d2 == d3 && 2 * d2 == d4 && 2 * distSq(p2, p4) == distSq(p2, p3))
            return true;
        if (d3 == d4 && 2 * d3 == d2 && 2 * distSq(p3, p2) == distSq(p3, p4))
            return true;
        if (d2 == d4 && 2 * d2 == d3 && 2 * distSq(p2, p3) == distSq(p2, p4))
            return true;
        // Если не совпало, возвращаем false
        return false;
    }

    public void printSidesLengths() { // Вывод длин сторон
        System.out.println("Длина первой стороны: " + pointsDistance(p1, p2));
        System.out.println("Длина второй стороны: " + pointsDistance(p2, p3));
        System.out.println("Длина третьей стороны: " + pointsDistance(p3, p4));
        System.out.println("Длина четвертой стороны: " + pointsDistance(p1, p4));
    }

    public void printDiagonalsLengths() { // Вывод длин диагоналей
        System.out.println("Длины диагоналей: " + pointsDistance(p1, p3) + ", " + pointsDistance(p2, p4));
    }

    public double calculatePerimeter() {
        return pointsDistance(p1, p2) + pointsDistance(p2, p3) +
                pointsDistance(p3, p4) + pointsDistance(p1, p4);
    }

    public void printPerimeter() { // Вывод периметра
        System.out.println("Периметр: " + calculatePerimeter());
    }

    public double calculateArea() {
        // Формула шнурков для подсчета площади произвольного четырехугольника
        return 0.5 * Math.abs(p1.getX()*p2.getY() + p2.getX()*p3.getY() + p3.getX()*p4.getY() -
                (p1.getY()*p2.getX() + p2.getY()*p3.getX() + p3.getY()*p3.getX()));
    }

    public void printArea() {
        System.out.println("Площадь: " + calculateArea());
    }

    // Согласно заданию переназначаем toString
    @Override
    public String toString() {
        return "Quadrilateral{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null) {
            return false;
        }
        Quadrilateral obj = (Quadrilateral) o;
        return Objects.equals(obj.getFirst(), p1);
    }
    // Используем compareTo + наследование Comparable для возможности сортировки
    @Override
    public int compareTo(Quadrilateral o) {
        return Double.compare(this.calculateArea(), o.calculateArea());
    }

}
