package org.goose.Lesson_12;

public class Main {

    public static void sumOfArrayElements(String[][] array) {
        try {
            if (array.length != 4 || array[0].length != 4) {
                throw new MyArraySizeException("Размер массива должен быть строго 4x4");
            }
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        int element = Integer.parseInt(array[i][j]);
                        sum += element;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Неверные данные в массиве по координатам: (" + i + "," + j + "), значение: '" + array[i][j] + "'");
                    }
                }
            }
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"9", "10", "11", "12"},
                {"9", "10", "11", "12"},
                {"9", "10", "11", "12"},
                {"9", "10", "11", "12"}
        };
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"девять", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        sumOfArrayElements(wrongDataArray);
        sumOfArrayElements(wrongSizeArray);
        sumOfArrayElements(validArray);
    }
}