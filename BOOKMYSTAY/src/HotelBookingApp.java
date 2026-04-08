import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}

class RoomAllocationService {
    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Integer> roomCounter = new HashMap<>();

    public RoomAllocationService() {

        inventory.put("Single", 2); // Set to 2 to demonstrate "No Rooms Available"
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    public void processBooking(Reservation reservation) {
        String type = reservation.getRoomType();
        int available = inventory.getOrDefault(type, 0);

        if (available > 0) {
            inventory.put(type, available - 1);

            int currentCount = roomCounter.getOrDefault(type, 0) + 1;
            roomCounter.put(type, currentCount);
            String roomId = type + "-" + currentCount;

            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() +
                    ", Room ID: " + roomId);
        } else {
            System.out.println("Booking failed for Guest: " + reservation.getGuestName() +
                    ". No " + type + " Rooms available.");
        }
    }
}

public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing");

        Queue<Reservation> bookingQueue = new LinkedList<>();
        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Single"));
        bookingQueue.add(new Reservation("Vanmathi", "Single")); // This should fail as we only have 2


        RoomAllocationService service = new RoomAllocationService();

        while (!bookingQueue.isEmpty()) {
            service.processBooking(bookingQueue.poll());
        }
    }
}