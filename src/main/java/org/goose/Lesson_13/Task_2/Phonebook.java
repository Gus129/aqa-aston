package org.goose.Lesson_13.Task_2;

import java.util.*;

public class Phonebook {
    private HashMap<String, List<String>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        if (!phonebook.containsKey(surname)) {
            phonebook.put(surname, new ArrayList<>());
        }
        List<String> numbers = phonebook.get(surname);
        if (!numbers.contains(phoneNumber)) {
            numbers.add(phoneNumber);
        } else {
            System.out.println("Номер телефона " + phoneNumber + " уже существует для фамилии " + surname + " и не был повторно добавлен");
        }
    }

    public List<String> get(String surname) {
        return phonebook.getOrDefault(surname, new ArrayList<>());
    }
}
