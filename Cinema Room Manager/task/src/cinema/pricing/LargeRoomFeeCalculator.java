package cinema.pricing;

import cinema.ScreenRoom;

public class LargeRoomFeeCalculator implements SeatFeeCalculator {
    private static final int FRONT_SEAT_FEE = 10;
    private static final int BACK_SEAT_FEE = 8;
    private final ScreenRoom room;

    LargeRoomFeeCalculator(ScreenRoom room) {
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

    @Override
    public int seatPrice(int row, int seat) {
        int front;

        if (room.getRows() % 2 == 0) {
            front = room.getRows() / 2;
        } else {
            front = (room.getRows() - 1) / 2;
        }

        return row <= front ? FRONT_SEAT_FEE : BACK_SEAT_FEE;
    }
}
