package org.goose;

//3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.
public class Park {

    public class Attraction {
        private String name;
        private String openingHours;
        private int ticketPrice;

        public Attraction(String name, String openingHours, int ticketPrice) {
            this.name = name;
            this.openingHours = openingHours;
            this.ticketPrice = ticketPrice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOpeningHours() {
            return openingHours;
        }

        public void setOpeningHours(String openingHours) {
            this.openingHours = openingHours;
        }

        public double getTicketPrice() {
            return ticketPrice;
        }

        public void setTicketPrice(int ticketPrice) {
            this.ticketPrice = ticketPrice;
        }

        public void printFullInfo() {
            System.out.println("Название аттракциона: " + name + "\n"
                    + "Время работы: " + openingHours + "\n"
                    + "Стоимость билета: " + ticketPrice + "\n");
        }
    }
}

