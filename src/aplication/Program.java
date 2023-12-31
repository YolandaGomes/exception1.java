package aplication;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.locks.ReadWriteLock;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check in date: (dd/MM/yyyy) ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check Out date: (dd/MM/yyyy) ");
        Date checkout = sdf.parse(sc.next());

        if (!checkout.after(checkin)){
            System.out.println(" Error in reservation, Check out mais cedo que check in");
        } else {
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println(reservation);
            System.out.println();
            System.out.println("Entre com o update da reserva: ");
            System.out.print("Check in date: (dd/MM/yyyy) ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check Out date: (dd/MM/yyyy) ");
            checkout = sdf.parse(sc.next());

            String error = reservation.updateDate(checkin, checkout);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }

        sc.close();
    }
}
