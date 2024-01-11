public class Customer {
    private String name;
    private double walletBalance;

    public Customer(String name, double walletBalance) {
        this.name = name;
        this.walletBalance = walletBalance;
    }

    public void purchaseTicket(Cinema cinema, int seatNumber, double ticketPrice) {
        if (walletBalance < ticketPrice) {
            throw new InsufficientFundsException(name + " does not have enough funds to purchase the ticket.");
        }
        try {
            cinema.bookSeat(seatNumber);
            walletBalance -= ticketPrice;
            System.out.println(name + " purchased a ticket for seat " + seatNumber);
        } catch (InvalidSeatException e) {
            System.err.println("Ticket purchase failed: " + e.getMessage());

        }
    }

}
