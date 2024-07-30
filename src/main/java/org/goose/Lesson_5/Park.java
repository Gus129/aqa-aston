package org.goose.Lesson_5;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.
    public class Park {
    @Getter
    private String id;
    @Getter
    private String name;
    private List<Attraction> attractions;

    public Park(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void removeAttraction(String attractionId) {
        attractions.removeIf(attraction -> attraction.getId().equals(attractionId));
    }

    public List<Attraction> getAttractions() {
        return new ArrayList<>(attractions);
    }

    @Getter
    public class Attraction {
        private String id;
        @Setter
        private String name;
        @Setter
        private String openingHours;
        @Setter
        private int ticketPrice;

        public Attraction(String name, String openingHours, int ticketPrice) {
            this.name = name;
            this.openingHours = openingHours;
            this.ticketPrice = ticketPrice;
            this.id = UUID.randomUUID().toString();
        }

        public void printFullInfo() {
            System.out.println("Название аттракциона: " + name + "\n"
                    + "ID: " + id + "\n"
                    + "Время работы: " + openingHours + "\n"
                    + "Стоимость билета: " + ticketPrice);

        }
    }
}

