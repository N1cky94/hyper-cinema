package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = Integer.parseInt(scanner.nextLine());

        int seats = rows * seatsPerRow;
        int income;
        if (seats <= 60) {
            income = rows * seatsPerRow * 10;
        } else {
            int frontRows;
            int backRows;
            if (rows % 2 == 0) {
                frontRows  = rows / 2;
                backRows = frontRows;
            } else {
                frontRows = (rows - 1) / 2;
                backRows = frontRows + 1;
            }


            int frontHalfIncome = frontRows * seatsPerRow * 10;
            int backHalfIncome = backRows * seatsPerRow * 8;

            income = frontHalfIncome + backHalfIncome;
        }


        System.out.println("Total income:");
        System.out.println("$" + income);
    }
}