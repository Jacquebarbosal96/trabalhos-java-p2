package Hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        String checkinString = scanner.nextLine();

        System.out.print("Check-out date (dd/MM/yyyy): ");
        String checkoutString = scanner.nextLine();

        try {
            Date checkin = sdf.parse(checkinString);
            Date checkout = sdf.parse(checkoutString);
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);

            // imprime dados da reserva inicial
            System.out.printf("Reservation: Room %d, check-in: %s, check-out: %s, %d nights%n",
                    reservation.getRoomNumber(),
                    sdf.format(reservation.getCheckin()),
                    sdf.format(reservation.getCheckout()),
                    reservation.duration());

            // atualização da reserva
            System.out.println("\nEnter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            String newCheckinString = scanner.nextLine();
            System.out.print("Check-out date (dd/MM/yyyy): ");
            String newCheckoutString = scanner.nextLine();

            Date newCheckin = sdf.parse(newCheckinString);
            Date newCheckout = sdf.parse(newCheckoutString);

            String error = reservation.updateDates(newCheckin, newCheckout);

            if (error != null) {
                System.out.println(error);
            } else {
                System.out.printf("Reservation: Room %d, check-in: %s, check-out: %s, %d nights%n",
                        reservation.getRoomNumber(),
                        sdf.format(reservation.getCheckin()),
                        sdf.format(reservation.getCheckout()),
                        reservation.duration());
            }

        } catch (ParseException e) {
            System.out.println("Invalid date format!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}