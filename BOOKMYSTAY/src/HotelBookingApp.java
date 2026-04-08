import java.util.LinkedList;
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

class BookingRequestQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    public void addRequest(Reservation request) {
        queue.add(request);
    }

    public boolean hasPendingRequests() {
        return !queue.isEmpty();
    }

    public Reservation processNextRequest() {
        return queue.poll();
    }
}


public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Booking Request Queue");
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);
        int count = 1;
        while (bookingQueue.hasPendingRequests()) {
            Reservation current = bookingQueue.processNextRequest();
            System.out.println("Processing Request #" + count);
            System.out.println("Guest: " + current.getGuestName());
            System.out.println("Room Type: " + current.getRoomType());
            count++;
        }
    }
}