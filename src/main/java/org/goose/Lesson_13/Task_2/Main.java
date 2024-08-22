package org.goose.Lesson_13.Task_2;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add("Иванов", "8-123-45-67");
        phonebook.add("Максимов", "112");
        phonebook.add("Гусев", "8-800-555-35-35");
        phonebook.add("Иванов", "8-123-45-67");
        phonebook.add("Иванов", "8-987-65-43");

        System.out.println("Список телефонов Иванова: " + phonebook.get("Иванов"));
        System.out.println("Список телефонов Максимова: " + phonebook.get("Максимов"));
        System.out.println("Список телефонов Гусева: " + phonebook.get("Гусев"));
        System.out.println("Список телефонов Кузнецова: " + phonebook.get("Кузнецов"));
    }
}
