package org.goose.Lesson_13.Task_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> wordsList = Arrays.asList(
                "материнская плата", "процессор", "оперативная память", "видеокарта",
                "HDD", "блок питания", "корпус", "система охлаждения",
                "процессор", "материнская плата", "SSD", "видеокарта",
                "оперативная память", "блок питания", "корпус", "HDD"
        );
        Set<String> uniqueWords = new HashSet<>(wordsList);
        System.out.println("Список уникальных слов: " + uniqueWords);
        System.out.println("Сколько раз встречается каждое слово: ");
        for (String key : uniqueWords) {
            System.out.println(key + " - " + Collections.frequency(wordsList, key));
        }
    }
}