package org.goose;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        printThreeWords();

        checkSumSign();

        printColor();

        compareNumbers();

        System.out.println(isSumBetween10and20(10, 10));

        printIsPositiveOrNegative(-29);

        System.out.println(isNegative(0));

        printStringNtimes("ха", 100);

        System.out.println(isLeapYear(2024));

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArray(arr);
        System.out.println(Arrays.toString(arr));

        int[] gigaArray = new int[100];
        fillArray1PlusPlus(gigaArray);
        System.out.println(Arrays.toString(gigaArray));

        int[] weirdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        modifyArrayLessThan6MultiplyOn2(weirdArray);
        System.out.println(Arrays.toString(weirdArray));

        int[][] diagArray = new int[7][7];
        fillArrayDiagonalsWith1(diagArray);
        System.out.println(Arrays.deepToString(diagArray).replace("], ", "]\n "));

        int[] clonedArray = generateArraySameValue(20, -69);
        System.out.println(Arrays.toString(clonedArray));

    }

    /*
       1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
    */

    public static void printThreeWords() {

        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    /*
       2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите.
          Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
          в противном случае - “Сумма отрицательная”;
    */

    public static void checkSumSign() {

        int a = 7, b = -8;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }

    /*
       3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
          Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
          если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
          если больше 100 (100 исключительно) - “Зеленый”;
    */

    public static void printColor() {

        int value = -1;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }

    }

    /*
       4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите.
          Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    */

    public static void compareNumbers() {

        int a = -100, b = -29;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }

    }

    /*
       5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
          если да – вернуть true, в противном случае – false.
    */

    public static boolean isSumBetween10and20(int num1, int num2) {

        return (num1 + num2) >= 10 && (num1 + num2) <= 20;

    }

    /*
       6. Напишите метод, которому в качестве параметра передается целое число,
          метод должен напечатать в консоль, положительное ли число передали или отрицательное.
          Замечание: ноль считаем положительным числом.
    */

    public static void printIsPositiveOrNegative(int num) {

        if (num >= 0) {
            System.out.println("Положительное число");
        } else System.out.println("Отрицательное число");

    }

    /*
       7. Напишите метод, которому в качестве параметра передается целое число.
          Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
          Замечание: ноль считаем положительным числом.
    */

    public static boolean isNegative(int num) {

        return num < 0;

    }

    /*
       8. Напишите метод, которому в качестве аргументов передается строка и число,
          метод должен отпечатать в консоль указанную строку, указанное количество раз;
    */

    public static void printStringNtimes(String stringToRepeat, int repsNumber) {

        if (repsNumber >= 0) {
            System.out.println(stringToRepeat.repeat(repsNumber));
        } else System.out.println("Число повторений строки не может быть меньше 0");

    }

    /*
       9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
          Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    */

    public static boolean isLeapYear(int numYear) {

        return (numYear % 4) == 0 && (numYear % 100) != 0 || (numYear % 400) == 0;

    }

    /*
       10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
           С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */

    private static void invertArray(int[] arrToInvert) {

        for (int i = 0; i < arrToInvert.length; i++) {
            if (arrToInvert[i] == 1) {
                arrToInvert[i] = 0;
            } else arrToInvert[i] = 1;
        }

    }

    /*
       11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
    */

    public static void fillArray1PlusPlus(int[] arrToFill) {

        for (int i = 0; i < arrToFill.length; i++) {
            arrToFill[i] = i + 1;
        }
    }

    /*
       12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    */

    public static void modifyArrayLessThan6MultiplyOn2(int[] arrToModify) {

        for (int i = 0; i < arrToModify.length; i++) {
            if (arrToModify[i] < 6) {
                arrToModify[i] = arrToModify[i] * 2;
            }
        }

    }

    /*
       13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
           и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
           Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
    */

    public static void fillArrayDiagonalsWith1(int[][] arrToFill) {

        for (int i = 0; i < arrToFill.length; i++) {
            for (int j = 0, x = arrToFill[i].length - 1; j < arrToFill[i].length; j++, x--) {
                if (i == j || i == x) {
                    arrToFill[i][j] = 1;
                }
                else arrToFill[i][j] = 0;
            }
        }

    }

    /*
       14. Написать метод, принимающий на вход два аргумента: len и initialValue,
           и возвращающий одномерный массив типа int длиной len,
           каждая ячейка которого равна initialValue.
    */

    public static int[] generateArraySameValue(int len, int initialValue) {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = initialValue;
        }
        return a;
    }

}


