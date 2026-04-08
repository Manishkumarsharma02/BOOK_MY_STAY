import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}


class ReservationValidator {
    private final List<String> validRooms = Arrays.asList("Single", "Double", "Suite");

    public void validate(String guestName, String roomType) throws InvalidBookingException {
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }
        if (!validRooms.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}


class RoomInventory {
    public RoomInventory() {}
}


class BookingRequestQueue {
    public BookingRequestQueue() {}
}


public class HotelBookingApp {

    public static void main(String[] args) {
        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            validator.validate(guestName, roomType);

            System.out.println("Booking successfully validated and queued!");

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}