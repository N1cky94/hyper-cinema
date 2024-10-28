package cinema;

public class SeatManager {
    private final ScreenRoom room;

    public SeatManager(ScreenRoom room) {
        this.room = room;
    }

    public int bookSeat(int row, int seat) {
        room.reserveSeat(row, seat);
        return room.getPriceForSeat(row, seat);
    }
}
