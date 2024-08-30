package org.goose.Lesson_12;

public class MyArrayCalculation {

    private String[][] array;

    public MyArrayCalculation(String[][] array) {
        this.array = array;
    }

    public void sumOfArrayElements() throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Размер массива должен быть ограничен 4 строками, но найдено: " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Размер массива должен быть ограничен 4 столбцами в строке " + (i + 1) + ", но найдено: " + array[i].length);
            }
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
    }
}