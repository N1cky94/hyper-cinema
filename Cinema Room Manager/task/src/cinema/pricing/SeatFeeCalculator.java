package cinema.pricing;

import cinema.ScreenRoom;

public interface SeatFeeCalculator {
    int calculateMax();
    int seatPrice(int row, int seat);

    static SeatFeeCalculator build(ScreenRoom room) {
        if (room.seats() <= 60) {
            return new SmallRoomFeeCalculator(room);
        } else {
            return new LargeRoomFeeCalculator(room);
        }
    }
}
