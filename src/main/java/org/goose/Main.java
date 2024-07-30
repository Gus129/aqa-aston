package org.goose;

import org.goose.Lesson_5.Employee;
import org.goose.Lesson_5.Park;

public class Main {

    public static void main(String[] args) {
        //  2. Создать массив из 5 сотрудников.
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        empArray[1] = new Employee("Maximov Max", "Designer", "maxmax@mailbox.com", "892312313", 150000, 38);
        empArray[2] = new Employee("Gusev Gus", "Programmer", "gugus@mailbox.com", "892312314", 29000, 42);
        empArray[3] = new Employee("Krupskaya Nadezhda", "HR", "krunadezhda@mailbox.com", "892312315", 3000, 29);
        empArray[4] = new Employee("Dedov Ded", "Security", "dded@mailbox.com", "892312316", 2000, 64);

        empArray[3].printFullInfo();

        Park disneyland = new Park("Диснейленд");
        Park gorky = new Park("Парк Горького");

        Park.Attraction rusRollercoaster = disneyland.new Attraction("Американские горки", "9:00 - 18:00", 250);
        Park.Attraction usRollercoaster = gorky.new Attraction("Американские горки", "9:00 - 18:00", 250);

        System.out.println("\n" + "Название парка: " + disneyland.getName());
        System.out.println("ID: " + disneyland.getId());
        rusRollercoaster.printFullInfo();

        System.out.println("\n" + "Название парка: " + gorky.getName());
        System.out.println("ID: " + gorky.getId());
        usRollercoaster.printFullInfo();

        rusRollercoaster.setName("Русские горки");
        System.out.println(rusRollercoaster.getName());
        System.out.println(usRollercoaster.getName());
    }
}