package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        Integer number  = sc.nextInt();
        sc.nextLine();

        System.out.print("Check-In date (dd/MM/yyyy): ");
        Date checkIn =  sdf.parse(sc.nextLine().trim());

        System.out.print("Check-Out date (dd/MM/yyyy): ");
        Date checkOut =  sdf.parse(sc.nextLine().trim());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date!");
        }
        else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation"+ reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-In date (dd/MM/yyyy): ");
            checkIn =  sdf.parse(sc.nextLine().trim());

            System.out.print("Check-Out date (dd/MM/yyyy): ");
            checkOut =  sdf.parse(sc.nextLine().trim());

            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future");
            }
            else if (checkOut.before(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date!");
            }
            else{
                reservation.updateDate(checkIn, checkOut);
                System.out.println("Reservation"+ reservation);
            }
        }
        
        sc.close();
    }
}
