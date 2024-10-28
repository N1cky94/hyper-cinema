package cinema;

public interface SeatFeeCalculator {
    int calculateMax();

    static SeatFeeCalculator build(ScreenRoom room) {
        if (room.seats() <= 60) {
            return new SmallRoomFeeCalculator(room);
        } else {
            return new LargeRoomFeeCalculator(room);
        }
    }
}
