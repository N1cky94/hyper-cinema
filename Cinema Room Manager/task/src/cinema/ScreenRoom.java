package cinema;

import cinema.pricing.SeatFeeCalculator;

public class ScreenRoom {
    private final SeatRow[] roomLayout;
    private final SeatFeeCalculator calculator;

    public ScreenRoom(int rows, int seatsPerRow) {
        roomLayout = new SeatRow[rows];
        for (int i = 0; i < rows; i++) {
            roomLayout[i] = new SeatRow(seatsPerRow);
        }
        this.calculator = SeatFeeCalculator.build(this);
    }

    public int getRows() {
        return roomLayout.length;
    }

    public int getSeatsPerRow() {
        return roomLayout[0].seats();
    }

    public int seats() {
        return getRows() * getSeatsPerRow();
    }

    public void reserveSeat(int row, int seat) {
        if (outOfRoomBounds(row, seat)) {
            throw new RuntimeException("Wrong input!");
        }

        roomLayout[row - 1].reserveSeat(seat);
    }

    private boolean outOfRoomBounds(int row, int seat) {
        return row > this.getRows() || row <= 0 || seat > this.getSeatsPerRow() || seat <= 0;

    }

    public int getPriceForSeat(int row, int seat) {
        return this.calculator.seatPrice(row, seat);
    }

    public int calculateMaxTurnover() {
        return this.calculator.calculateMax();
    }

    public int getReservedSeats() {
        int reservedSeats = 0;

        for (SeatRow row : roomLayout) {
            reservedSeats += row.getReservedSeats();
        }

        return reservedSeats;
    }

    public int getIncome() {
        int income = 0;

        for (int i = 0; i < roomLayout.length; i++) {
            income += roomLayout[i].getReservedSeats() * calculator.seatPrice(i + 1, 1);
        }
        return income;
    }

    public RoomStatistics getStatistics() {
        return new RoomStatistics(
                this.getReservedSeats(),
                this.seats(),
                this.getIncome(),
                this.calculateMaxTurnover()
        );
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Cinema:\n");

        builder.append(" ");
        for (int i = 1; i <= getSeatsPerRow(); i++) {
            builder.append(" ");
            builder.append(i);
        }
        builder.append("\n");

        for (int i = 1; i <= getRows(); i++) {
            builder.append("%d%s%n".formatted(i, roomLayout[i - 1]));
        }

        return builder.toString();
    }
}
