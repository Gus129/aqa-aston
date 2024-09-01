package org.goose.Lesson_12;

public class Main {

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

        MyArrayCalculation validCalc = new MyArrayCalculation(validArray);
        MyArrayCalculation wrongSizeCalc = new MyArrayCalculation(wrongSizeArray);
        MyArrayCalculation wrongDataCalc = new MyArrayCalculation(wrongDataArray);

        try {
            validCalc.sumOfArrayElements();
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            wrongSizeCalc.sumOfArrayElements();
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            wrongDataCalc.sumOfArrayElements();
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}