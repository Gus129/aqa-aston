package org.goose.Lesson_10.Task_2;

public abstract class Shape implements CalcPerimeterAndArea {

    String fillColor;
    String borderColor;
    ShapeType shapeType;

    public enum ShapeType {
        CIRCLE("Круг"),
        RECTANGLE("Прямоугольник"),
        TRIANGLE("Треугольник");

        private final String type;

        ShapeType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    public void printDetails() {
        System.out.println("Фигура: " + shapeType.toString());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
        System.out.println("*************************************");
    }
}
