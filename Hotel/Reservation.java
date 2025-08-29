package Hotel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private int roomNumber;
    private Date checkin;
    private Date checkout;

    public Reservation(int roomNumber, Date checkin, Date checkout) {

        if (!checkout.after(checkin)) {
            throw new IllegalArgumentException("Error in reservation: Check-out date must be after check-in date");
        }


        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;

    }


    public int getRoomNumber() {
        return roomNumber;
    }


    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }


    public long duration() {
        long diffMillis = checkout.getTime() - checkin.getTime();
        return TimeUnit.MILLISECONDS.toDays(diffMillis);
    }


    public String updateDates(Date newCheckin, Date newCheckout) {
        Date now = new Date();

        if (newCheckin.before(now) || newCheckout.before(now)) {
            return "Error in reservation: Reservation dates for update must be future dates";
        }

        if (!newCheckout.after(newCheckin)) {
            return "Error in reservation: Check-out date must be after check-in date";
        }

        
        this.checkin = newCheckin;
        this.checkout = newCheckout;
        return null;
    }
}