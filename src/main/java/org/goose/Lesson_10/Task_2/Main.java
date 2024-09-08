package org.goose.Lesson_10.Task_2;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(7, "Фиолетовый", "Красный");
        Shape rectangle = new Rectangle(2, 9, "Синий", "Зеленый");
        Shape triangle = new Triangle(3, 4, 5, "Черный", "Оранжевый");

        circle.printDetails();
        rectangle.printDetails();
        triangle.printDetails();
    }
}
