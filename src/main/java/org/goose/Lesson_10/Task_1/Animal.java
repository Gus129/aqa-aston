package org.goose.Lesson_10.Task_1;

public abstract class Animal {
    public String name;
    public static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
