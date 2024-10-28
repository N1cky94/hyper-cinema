package cinema;

public class ScreenRoom {
    private final int rows;
    private final int seatsPerRow;
    private final SeatFeeCalculator calculator;

    public ScreenRoom(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.calculator = SeatFeeCalculator.build(this);
    }

    public int getRows() {
        return rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public int seats() {
        return rows * seatsPerRow;
    }

    public int calculateMaxTurnover() {
        return this.calculator.calculateMax();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Screen:\n");

        builder.append("  1 2 3 4 5 6 7 8\n");
        for (int i = 1; i < 8; i++) {
            builder.append("%d S S S S S S S S%n".formatted(i));
        }

        return builder.toString();
    }
}
