package cinema;

public class LargeRoomFeeCalculator implements SeatFeeCalculator {
    private static final int FRONT_SEAT_FEE = 10;
    private static final int BACK_SEAT_FEE = 8;
    private final ScreenRoom room;

    public LargeRoomFeeCalculator(ScreenRoom room) {
        this.room = room;
    }

    @Override
    public int calculateMax() {
        int front;
        int back;

        if (room.getRows() % 2 == 0) {
            front = room.getRows() / 2;
            back = front;
        } else {
            front = (room.getRows() - 1) / 2;
            back = front + 1;
        }

        front *= room.getSeatsPerRow();
        back *= room.getSeatsPerRow();

        return front * FRONT_SEAT_FEE + back * BACK_SEAT_FEE;
    }
}