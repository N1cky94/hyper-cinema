package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = Integer.parseInt(scanner.nextLine());

        ScreenRoom room = new ScreenRoom(rows, seatsPerRow);

        System.out.println("Total income:");
        System.out.println("$" + room.calculateMaxTurnover());
    }
}