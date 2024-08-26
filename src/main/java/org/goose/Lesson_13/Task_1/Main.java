package org.goose.Lesson_13.Task_1;

public class Main {
    public static void main(String[] args) {
        String[] wordsArray = {
                "материнская плата", "процессор", "оперативная память", "видеокарта",
                "HDD", "блок питания", "корпус", "система охлаждения",
                "процессор", "материнская плата", "SSD", "видеокарта",
                "оперативная память", "блок питания", "корпус", "HDD"
        };
        WordsArrayProcessor computerParts = new WordsArrayProcessor(wordsArray);
        computerParts.printUniqueWords();
        computerParts.printWordCount();
    }
}