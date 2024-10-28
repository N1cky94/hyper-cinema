package cinema;

public class SmallRoomFeeCalculator implements SeatFeeCalculator {
    private static final int FEE = 10;
    private final ScreenRoom room;

    SmallRoomFeeCalculator(ScreenRoom room) {
        this.room = room;
    }

    @Override
    public int calculateMax() {
        return room.seats() * FEE;
    }
}
