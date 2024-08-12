package org.goose.Lesson_10.Task_2;

public abstract class Shape implements CalcPerimeterAndArea {

    String fillColor;
    String borderColor;
    String shapeType;

    public void printDetails() {
        System.out.println("Фигура: " + shapeType);
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
        System.out.println("*************************************");
    }
}
