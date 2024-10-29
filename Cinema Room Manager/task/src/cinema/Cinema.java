package cinema;

import cinema.utils.Keyboard;

public class Cinema {
    private static ScreenRoom room;
    private static SeatManager manager;

    public static void main(String[] args) {
        int rows = Keyboard.getNumber("Enter the number of rows:");
        int seatsPerRow = Keyboard.getNumber("Enter the number of seats in each row:");

        room = new ScreenRoom(rows, seatsPerRow);
        manager = new SeatManager(room);

        boolean keepGoing = true;

        while(keepGoing) {
            keepGoing = run();
        }
    }

    public static boolean run() {
        int menuChoice = mainMenu();

        switch (menuChoice) {
            case 1 -> printRoom();
            case 2 -> selectSeatMenu();
            case 3 -> statisticsMenu();
        }

        return menuChoice != 0;
    }

    private static int mainMenu() {
        return Keyboard.getNumber("""
                
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit""");
    }

    private static void printRoom() {
        System.out.println();
        System.out.println(room);
    }

    public static void selectSeatMenu() {
        boolean kg = true;

        while(kg) {
            try {
                System.out.println();
                int row = Keyboard.getNumber("Enter a row number:");
                int seat = Keyboard.getNumber("Enter a seat number in that row:");

                System.out.printf(
                        "\nTicket price: $%d%n",
                        manager.bookSeat(row, seat)
                );
                kg = false;
            } catch (RuntimeException re) {
                System.out.println(re.getMessage());
            }
        }
    }

    public static void statisticsMenu() {
        RoomStatistics stats = room.getStatistics();
        System.out.printf(
                """
                                
                Number of purchased tickets: %d
                Percentage: %3.2f%%
                Current income: $%d
                Total income: $%d
                """,
                stats.purchasedTickets(),
                stats.purchasedTicketsPercentage(),
                stats.income(),
                stats.prospectedIncome()
        );
    }
}