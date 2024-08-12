package org.goose.Lesson_10.Task_2;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width, String fillColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.shapeType = "Прямоугольник";
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

