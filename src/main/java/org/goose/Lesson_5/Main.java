package org.goose.Lesson_5;

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

        disneyland.addAttraction(usRollercoaster);
        gorky.addAttraction(rusRollercoaster);
        gorky.addAttraction(usRollercoaster);

        rusRollercoaster.setName("Русские горки");

        printParkInfo(disneyland);
        printParkInfo(gorky);

        gorky.removeAttraction(rusRollercoaster.getId());
        gorky.removeAttraction(usRollercoaster.getId());
        printParkInfo(gorky);
    }

    public static void printParkInfo(Park park) {
        System.out.println("Название парка: " + park.getName());
        System.out.println("ID: " + park.getId());
        System.out.println("Аттракционы в парке: " + "\n");
        for (Park.Attraction attraction : park.getAttractions()) {
            attraction.printFullInfo();
            System.out.println();
        }
    }

}