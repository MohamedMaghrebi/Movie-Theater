
import java.util.Random;
import java.util.Scanner;

public class MovieTheaterSeating {
    private static final int TOTAL_SEATS = 60;
    private static final int RESERVED_SEATS = 35;
    private char[] seats = new char[TOTAL_SEATS];
    private String[] names = {
            "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hannah",
            "Ivan", "Jack", "Kara", "Liam", "Mona", "Nate", "Olivia", "Paul", "Quinn",
            "Rita", "Steve", "Tina", "Uma", "Victor", "Wendy", "Xander", "Yara", "Zane",
            "Arthur", "Betty", "Clark", "Diana", "Eddie", "Fiona", "George", "Helen", "Isaac"
    };

    public MovieTheaterSeating() {
        // Initialize all seats to '0' (available)
        for (int i = 0; i < TOTAL_SEATS; i++) {
            seats[i] = '0';
        }
        // Randomly reserve 35 seats
        Random random = new Random();
        int reservedCount = 0;
        while (reservedCount < RESERVED_SEATS) {
            int seatIndex = random.nextInt(TOTAL_SEATS);
            if (seats[seatIndex] == '0') {
                seats[seatIndex] = 'X';
                reservedCount++;
            }
        }
    }

    public void displaySeatingChart() {
        System.out.println("Seating Chart (0 = available, X = reserved):");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            System.out.print(seats[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    public void reserveSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            System.out.println("Invalid seat number. Please choose a number between 1 and " + TOTAL_SEATS + ".");
            return;
        }
        if (seats[seatNumber - 1] == 'X') {
            System.out.println("Sorry, seat " + seatNumber + " is already taken.");
        } else {
            seats[seatNumber - 1] = 'X';
            System.out.println("Seat " + seatNumber + " has been successfully reserved.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Blue Whale Theater!");
        System.out.println("Now Showing: Space Dragons");
        System.out.println("Year Released: December 1, 2024");
        System.out.println("Running Time: 1h 32m");
        System.out.println("Rated: PG");
        System.out.println();

        MovieTheaterSeating theater = new MovieTheaterSeating();
        theater.displaySeatingChart();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a seat number to reserve (1-60) or 0 to exit:");
            int seatNumber = scanner.nextInt();
            if (seatNumber == 0) {
                break;
            }
            theater.reserveSeat(seatNumber);
            theater.displaySeatingChart();
        }
        scanner.close();
    }
}
