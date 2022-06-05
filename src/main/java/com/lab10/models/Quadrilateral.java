package com.lab10.models;

import java.util.Objects;

public class Quadrilateral {

    public Quadrilateral(double x1, double y1, double x2, double y2,
                         double x3, double y3, double x4, double y4) { // Конструктор класса
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private double x4;
    private double y4;

    /**
     * Расстояние между точками
     * @return расстояние между точками
     */
    public static double pointsDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    /**
     * Подсчет квадрата расстояния между точками
     * @return квадрат расстояния между точками
     */
    public static double distSq(double x1, double y1, double x2, double y2)
    {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }


    public double getX1() {
        return x1;
    }
    public double getX2() {
        return x2;
    }
    public double getX3() {
        return x3;
    }
    public double getX4() {
        return x4;
    }
    public double getY1() {
        return y1;
    }
    public double getY2() {
        return y2;
    }
    public double getY3() {
        return y3;
    }
    public double getY4() {
        return y4;
    }
    public void setX1(double x1) {
        this.x1 = x1;
    }
    public void setX2(double x2) {
        this.x2  = x2;
    }
    public void setX3(double x3) {
        this.x3  = x3;
    }
    public void setX4(double x4) {
        this.x4  = x4;
    }
    public void setY1(double y1) {
        this.y1 = y1;
    }
    public void setY2(double y2) {
        this.y2 = y2;
    }
    public void setY3(double y3) {
        this.y3 = y3;
    }
    public void setY4(double y4) {
        this.y4 = y4;
    }

    /**
     * Проверка является ли прямоугольник квадратом
     * @return является ли прямоугольник квадратом
     */
    public static boolean isSquare(double x1, double y1, double x2, double y2,
                                   double x3, double y3, double x4, double y4) {
        double d2 = distSq(x1, y1, x2, y2);
        double d3 = distSq(x1, y1, x3, y3);
        double d4 = distSq(x1, y1, x4, y4);

        if (d2 == 0 || d3 == 0 || d4 == 0)
            return false;
        // Попарно сверяем их
        if (d2 == d3 && 2 * d2 == d4 && 2 * distSq(x2, y2, x4, y4) == distSq(x2, y2, x3, y3))
            return true;
        if (d3 == d4 && 2 * d3 == d2 && 2 * distSq(x3, y3, x2, y2) == distSq(x3, y3, x4, y4))
            return true;
        if (d2 == d4 && 2 * d2 == d3 && 2 * distSq(x2, y2, x3, y3) == distSq(x2, y2, x4, y4))
            return true;
        // Если не совпало, возвращаем false
        return false;
    }

    /**
     * Вывод длин сторон
     */
    public void printSidesLengths() {
        System.out.println("Длина первой стороны: " + pointsDistance(x1, y1, x2, y2));
        System.out.println("Длина второй стороны: " + pointsDistance(x2, y2, x3, y3));
        System.out.println("Длина третьей стороны: " + pointsDistance(x3, y3, x4, y4));
        System.out.println("Длина четвертой стороны: " + pointsDistance(x1, y1, x4, y4));
    }

    /**
     * Вывод длин диагоналей
     */
    public void printDiagonalsLengths() {
        System.out.println("Длины диагоналей: " + pointsDistance(x1, y1, x3, y3) + ", " + pointsDistance(x2, y2, x4, y4));
    }

    /**
     * Подсчет периметра прямоугольника
     * @return периметр прямоугольника
     */
    public double calculatePerimeter() {
        return pointsDistance(x1, y1, x2, y2) + pointsDistance(x2, y2, x3, y3) +
                pointsDistance(x3, y3, x4, y4) + pointsDistance(x1, y1, x4, y4);
    }

    /**
     * Вывод периметра прямоугольника
     */
    public void printPerimeter() {
        System.out.println("Периметр: " + calculatePerimeter());
    }

    /**
     * Подсчет площади прямоугольника (по формуле шнурков)
     * @return площадь прямоугольника
     */
    public double calculateArea() {
        return 0.5 * Math.abs(x1*y2 + x2*y3 + x3*y4 -
                (y1*x2 + y2*x3 + y3*x3));
    }

    /**
     * Вывод площади прямоугольника
     */
    public void printArea() {
        System.out.println("Площадь: " + calculateArea());
    }

    // Согласно заданию переназначаем toString
    @Override
    public String toString() {
        return "Quadrilateral{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                ", x4=" + x4 +
                ", y4=" + y4 +
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
        return Objects.equals(obj.getX1(), x1);
    }

}