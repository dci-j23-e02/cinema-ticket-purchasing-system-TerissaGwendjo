public class Cinema {

    private int totalSeats;

    public Cinema(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public void bookSeat(int seatNumber) throws InvalidSeatException {
        if (seatNumber <= 0 || seatNumber > totalSeats) {
            throw new InvalidSeatException("Seat number " + seatNumber + " is invalid.");
        }
        System.out.println("Seat " + seatNumber + " booked successfully.");
    }
}
