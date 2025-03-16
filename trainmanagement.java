
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Train class to store train information
class Train {

    private String trainName;
    private int trainNumber;
    private int totalSeats;
    private int availableSeats;
    private String source;

    public Train(String trainName, int trainNumber, int totalSeats) {
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;  // Initially all seats are available
    }

    public String getTrainName() {
        return trainName;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookTicket() {
        if (availableSeats > 0) {
            availableSeats--; // Decrease available seats when a ticket is booked
            return true;
        }
        return false; // No available seats
    }

    public void cancelTicket() {
        if (availableSeats < totalSeats) {
            availableSeats++; // Increase available seats when a ticket is cancelled
        }
    }

    @Override
    public String toString() {
        return "Train Name: " + trainName + ", Train Number: " + trainNumber + ", Available Seats: " + availableSeats;
    }
}

// Ticket class to store ticket information
class Ticket {

    private String passengerName;
    private int trainNumber;
    private int ticketID;
    private String source;
    private String destination;

    public Ticket(String passengerName, int trainNumber, String source, String destination, int ticketID) {
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.ticketID = ticketID;
        this.source = source;
        this.destination = destination;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public int getTicketID() {
        return ticketID;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketID + ", Passenger Name: " + passengerName + ", Source:" + source + ", Destination:" + destination + ", Train Number: " + trainNumber;
    }
}

// Main class to manage the application logic
public class trainmanagement {

    private static List<Train> trains = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();
    private static int ticketCounter = 1000; // Ticket ID starting point

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initializing some trains
        trains.add(new Train("Express Train", 101, 100));
        trains.add(new Train("Superfast Train", 102, 150));
        trains.add(new Train("Intercity Train", 103, 120));

        while (true) {
            System.out.println("\nTrain Ticket Management System");
            System.out.println("1. View Available Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View Booked Tickets");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewAvailableTrains();
                    break;
                case 2:
                    bookTicket(scanner);
                    break;
                case 3:
                    cancelTicket(scanner);
                    break;
                case 4:
                    viewBookedTickets();
                    break;
                case 5:
                    System.out.println("Thank you for using the Train Ticket Management System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to display available trains
    private static void viewAvailableTrains() {
        System.out.println("\nAvailable Trains:");
        for (Train train : trains) {
            System.out.println(train);
        }
    }

    // Method to book a ticket
    private static void bookTicket(Scanner scanner) {
        System.out.print("\nEnter your name: ");
        String passengerName = scanner.nextLine();

        System.out.print("Enter train number to book: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Enter source:");
        String source = scanner.nextLine();
        System.out.println("Enter destination:");
        String destination = scanner.nextLine();

        Train selectedTrain = findTrainByNumber(trainNumber);
        if (selectedTrain != null && selectedTrain.bookTicket()) {
            Ticket ticket = new Ticket(passengerName, trainNumber, source, destination, ticketCounter++);
            tickets.add(ticket);
            System.out.println("Ticket booked successfully! " + ticket);
        } else {
            System.out.println("Sorry, no available seats on the selected train.");
        }
    }

    // Method to cancel a ticket
    private static void cancelTicket(Scanner scanner) {
        System.out.print("\nEnter Ticket ID to cancel: ");
        int ticketID = scanner.nextInt();

        Ticket ticket = findTicketByID(ticketID);
        if (ticket != null) {
            Train train = findTrainByNumber(ticket.getTrainNumber());
            if (train != null) {
                train.cancelTicket();
                tickets.remove(ticket);
                System.out.println("Ticket cancelled successfully!");
            }
        } else {
            System.out.println("Ticket ID not found.");
        }
    }

    // Method to view all booked tickets
    private static void viewBookedTickets() {
        if (tickets.isEmpty()) {
            System.out.println("\nNo tickets booked yet.");
        } else {
            System.out.println("\nBooked Tickets:");
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

    // Helper method to find a train by its number
    private static Train findTrainByNumber(int trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        return null;
    }

    // Helper method to find a ticket by its ID
    private static Ticket findTicketByID(int ticketID) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketID() == ticketID) {
                return ticket;
            }
        }
        return null;
    }
}
