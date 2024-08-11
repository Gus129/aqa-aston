package org.goose.Lesson_10.Task_1;

public class Main {
    public static void main(String[] args) {

        Dog dogBobik = new Dog("Бобик");
        Dog dogSharik = new Dog("Шарик");
        Cat catMurzik = new Cat("Мурзик", 5);
        Cat catBarsik = new Cat("Барсик", 10);
        Cat catMatroskin = new Cat("Матроскин", 15);

        catMurzik.run(120);
        catMurzik.swim(2);
        catBarsik.run(500);
        catBarsik.swim(5);
        dogBobik.run(300);
        dogBobik.swim(8);
        dogSharik.run(800);
        dogSharik.swim(20);

        Bowl catBowl = new Bowl(20);
        Cat[] cats = {catMurzik, catBarsik, catMatroskin};

        feedHungryCats(cats, catBowl);
        catBowl.printFoodAmount();
        catBowl.addFood(10);
        catBowl.printFoodAmount();
        feedHungryCats(cats, catBowl);
        catBowl.printFoodAmount();

        System.out.println("*************************************");
        System.out.println("Количество животных: " + Animal.animalCount);
        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println("*************************************");
    }

    private static void feedHungryCats(Cat[] cats, Bowl catBowl) {
        for (Cat cat : cats) {
            if (!cat.isFull()) {
            cat.eat(catBowl);
            System.out.println(cat.name + " сыт: " + cat.isFull());}
        }
    }
}

