package org.goose.Lesson_13.Task_1;

import java.util.*;

public class WordsArrayProcessor {
    private String[] wordsArray;

    public WordsArrayProcessor(String[] wordsArray) {
        this.wordsArray = wordsArray;
    }

    public Map<String, Integer> countUniqueWords() {
        Map<String, Integer> count = new HashMap<>();
        for (String word : wordsArray) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        return count;
    }

    public List<String> findUniqueWords() {
        Map<String, Integer> uniqueWordCount = countUniqueWords();
        List<String> uniqueWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : uniqueWordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }
        return uniqueWords;
    }

    public void printUniqueWords() {
        List<String> uniqueWords = findUniqueWords();
        System.out.println("********************************************************");
        System.out.println("Список слов, которые встречаются только один раз:");
        for (String word : uniqueWords) {
            System.out.println("- " + word);
        }
    }

    public void printWordCount() {
        Map<String, Integer> wordCount = countUniqueWords();
        System.out.println("********************************************************");
        System.out.println("Сколько раз встречается каждое слово:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}