package cinema;

public record RoomStatistics(
        int purchasedTickets,
        int maxSeats,
        int income,
        int prospectedIncome
) {
    public double purchasedTicketsPercentage() {
        return ((double) purchasedTickets() / maxSeats()) * 100;
    }
}
