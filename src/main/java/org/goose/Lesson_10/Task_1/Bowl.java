package org.goose.Lesson_10.Task_1;

public class Bowl {
    public int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println(amount + " единиц еды добавлено в миску");
    }

    public void decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        } else {
            System.out.println("Недостаточно еды в миске чтобы оттуда покушать.");
        }
    }

    public void printFoodAmount() {
        System.out.println("Еды в миске: " + foodAmount);
    }
}
