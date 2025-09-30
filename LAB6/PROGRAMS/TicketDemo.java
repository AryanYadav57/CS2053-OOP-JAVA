package lab006;

class TicketBooking {
    private int availableTickets = 5;

    // Synchronized method to ensure thread safety
    synchronized void bookTicket(String threadName) {
        if (availableTickets > 0) {
            System.out.println(threadName + " is booking a ticket.");
            availableTickets--;
            System.out.println(threadName + " successfully booked a ticket. Tickets left: " + availableTickets);
        } else {
            System.out.println(threadName + " tried to book a ticket, but none are available.");
        }
    }
}

class BookingThread extends Thread {
    TicketBooking booking;
    String threadName;

    BookingThread(TicketBooking booking, String threadName) {
        this.booking = booking;
        this.threadName = threadName;
    }

    public void run() {
        booking.bookTicket(threadName);
    }
}

public class TicketDemo {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();

        // Multiple threads trying to book tickets
        BookingThread t1 = new BookingThread(booking, "User-1");
        BookingThread t2 = new BookingThread(booking, "User-2");
        BookingThread t3 = new BookingThread(booking, "User-3");
        BookingThread t4 = new BookingThread(booking, "User-4");
        BookingThread t5 = new BookingThread(booking, "User-5");
        BookingThread t6 = new BookingThread(booking, "User-6");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
