package cinema;

import cinema.utils.Keyboard;

import java.util.Scanner;

public class Cinema {
    private static ScreenRoom room;
    private static SeatManager manager;

    public static void main(String[] args) {
        int rows = Keyboard.getNumber("Enter the number of rows:");
        int seatsPerRow = Keyboard.getNumber("Enter the number of seats in each row:");

        room = new ScreenRoom(rows, seatsPerRow);
        manager = new SeatManager(room);

        printRoom();
        selectSeatMenu();
        printRoom();
    }

    private static void printRoom() {
        System.out.println();
        System.out.println(room);
        System.out.println();
    }

    public static void selectSeatMenu() {
        int row = Keyboard.getNumber("Enter a row number:");
        int seat = Keyboard.getNumber("Enter a seat number in that row:");

        System.out.printf(
                "\nTicket price: $%d%n",
                manager.bookSeat(row, seat)
        );
    }
}