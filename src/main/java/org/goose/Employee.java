package org.goose;

/*
   1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
      Конструктор класса должен заполнять эти поля при создании объекта.
      Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
*/
public class Employee {
    private String fullName;
    private String jobPosition;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String jobPosition, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.jobPosition = jobPosition;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printFullInfo() {
        System.out.println("ФИО: " + fullName + "\n"
                + "Должность: " + jobPosition + "\n"
                + "Email: " + email + "\n"
                + "Номер телефона: " + phoneNumber + "\n"
                + "Зарплата: " + salary + "\n"
                + "Возраст: " + age);
    }
}
