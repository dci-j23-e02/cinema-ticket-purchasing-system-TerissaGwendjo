public class CinemaApp {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(10); // Assume a cinema with 10 seats
        Customer customer = new Customer("Alice", 30.00); // Customer with $30 balance

        // Scenario 1: Booking a valid seat with sufficient funds
        try {
            customer.purchaseTicket(cinema, 5, 10.00);
        } catch (InsufficientFundsException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Scenario 2: Booking an invalid seat number
        try {
            customer.purchaseTicket(cinema, 15, 8.00);
        } catch (InsufficientFundsException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Scenario 3: Attempting to purchase a ticket without sufficient funds
        try {
            customer.purchaseTicket(cinema, 3, 35.00);
        } catch (InsufficientFundsException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
