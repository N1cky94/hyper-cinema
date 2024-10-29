package cinema;

import java.util.Arrays;

public class SeatRow {
    private final char[] row;

    public SeatRow(int seats) {
        this.row = new char[seats];
        fillWithAvailableSeats();
    }

    public int seats() {
        return row.length;
    }

    public boolean isAvailable(int seat) {
        return row[seat - 1] == 'S';
    }

    public void reserveSeat(int seat) {
        row[seat - 1] = 'B';
    }

    public int getReservedSeats() {
        int sum = 0;
        for (char seat : row) {
            if (seat == 'B') {
                sum++;
            }
        }

        return sum;
    }

    private void fillWithAvailableSeats() {
        for (int i = 0; i < seats(); i++) {
            row[i] = 'S';
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (char el : row) {
            builder.append(" ");
            builder.append(el);
        }
        return builder.toString();
    }
}
