package cinema.utils;

import java.util.Scanner;

public class Keyboard {
    private static final Scanner KEYBOARD = new Scanner(System.in);

    public static int getNumber() {
        return Integer.parseInt(KEYBOARD.nextLine());
    }

    public static int getNumber(String message) {
        System.out.println(message);
        return getNumber();
    }
}
