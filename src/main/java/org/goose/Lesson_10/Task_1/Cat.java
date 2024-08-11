package org.goose.Lesson_10.Task_1;

class Cat extends Animal {
    private static int catCount = 0;
    private int appetite;
    private boolean isFull = false;

    public Cat(String name, int appetite) {
        super(name);
        this.appetite = appetite;
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м");
        } else {
            System.out.println(name + " не может пробежать столько (" + distance + " м)");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        int currentFoodAmount = bowl.getFoodAmount();
        if (currentFoodAmount >= appetite) {
            bowl.decreaseFood(appetite);
            isFull = true;
            System.out.println(name + " скушал " + appetite + " единиц еды и теперь сыт.");
        } else {
            System.out.println(name + "у не хватает еды в миске. Он демонстративно не ест :)");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}

