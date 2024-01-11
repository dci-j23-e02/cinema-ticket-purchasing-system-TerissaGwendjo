### Assignment: Cinema Ticket Purchasing System with Custom Exceptions

#### Background
You are tasked with developing a simple cinema ticket purchasing system. The system should be able to handle various error conditions that may arise during the ticket purchasing process. To provide clear and specific error messages, you will create custom exceptions that represent these error conditions.

#### Objectives
1. Create two custom exceptions:
   - `InvalidSeatException` (checked): Thrown when a user tries to book a seat that does not exist or is invalid.
   - `InsufficientFundsException` (unchecked): Thrown when a user does not have enough funds to complete the ticket purchase.

2. Implement a `Cinema` class with a method to book tickets, which can throw the `InvalidSeatException`.
3. Implement a `Customer` class with a method to purchase tickets, which can throw the `InsufficientFundsException`.
4. Write a `CinemaApp` class with a `main` method to simulate the ticket purchasing process and handle the custom exceptions.

#### Instructions

**Step 1: Define Custom Exceptions**

- **InvalidSeatException.java**
  ```java
  public class InvalidSeatException extends Exception {
      public InvalidSeatException(String message) {
          super(message);
      }
  }
  ```

- **InsufficientFundsException.java**
  ```java
  public class InsufficientFundsException extends RuntimeException {
      public InsufficientFundsException(String message) {
          super(message);
      }
  }
  ```

**Step 2: Implement the Cinema Class**

- **Cinema.java**
  ```java
  public class Cinema {
      private int totalSeats;

      public Cinema(int totalSeats) {
          this.totalSeats = totalSeats;
      }

      public void bookSeat(int seatNumber) throws InvalidSeatException {
          if (seatNumber <= 0 || seatNumber > totalSeats) {
              throw new InvalidSeatException("Seat number " + seatNumber + " is invalid.");
          }
          // Assume the seat booking logic is implemented here
          System.out.println("Seat " + seatNumber + " booked successfully.");
      }
  }
  ```

**Step 3: Implement the Customer Class**

- **Customer.java**
  ```java
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
              // Additional error handling code if necessary
          }
      }
  }
  ```

**Step 4: Simulate the Ticket Purchasing Process**

- **CinemaApp.java**
  ```java
  public class CinemaApp {
      public static void main(String[] args) {
          Cinema cinema = new Cinema(100); // Cinema with 100 seats
          Customer customer = new Customer("John Doe", 50.00); // Customer with $50 balance

          try {
              customer.purchaseTicket(cinema, 101, 15.00); // Attempt to purchase an invalid seat
          } catch (InsufficientFundsException e) {
              System.err.println("Error: " + e.getMessage());
              // Additional error handling code if necessary
          }

          // Add more scenarios as needed to demonstrate the use of both custom exceptions
      }
  }
  ```

#### Assignment Tasks

1. Implement the custom exceptions as described above.
2. Complete the `Cinema` and `Customer` classes with the provided logic.
3. In the `CinemaApp` class, simulate different scenarios, such as:
   - Booking a valid seat with sufficient funds.
   - Booking an invalid seat number.
   - Attempting to purchase a ticket without sufficient funds.
4. Ensure that your program handles both custom exceptions appropriately and provides clear feedback to the user.

#### Deliverables

Students should submit the following Java files:
- `InvalidSeatException.java`
- `InsufficientFundsException.java`
- `Cinema.java`
- `Customer.java`
- `CinemaApp.java`

Each file should be well-commented, and the code should be formatted according to standard Java conventions. The program should compile and run without errors, demonstrating the correct use of custom exceptions.
