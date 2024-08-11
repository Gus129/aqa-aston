package org.goose.Lesson_10.Task_2;

public interface Shape {
    double calculateArea();
    double calculatePerimeter();

    String getFillColor();
    String getBorderColor();
    String getShapeType();

    default void printDetails() {
        System.out.println("Фигура: " + getShapeType());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("*************************************");
    }
}
