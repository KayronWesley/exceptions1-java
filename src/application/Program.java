/** This is a little study about EXPECTIONS
 * in this example we have a BAD SOLUTION
 * to resolve the exception
**/

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.println("Enter Room Number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Enter Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Enter Check-out date (dd/MM/yyyy); ");
		Date checkout = sdf.parse(sc.next());
		Reservation reservation = new Reservation(roomNumber, checkin, checkout);
		System.out.println("Reservation: " + reservation);
		System.out.println("Reservation Update " );
		System.out.println("Enter Check-in date (dd/MM/yyyy): ");
		checkin = sdf.parse(sc.next());
		System.out.println("Enter Check-out date (dd/MM/yyyy); ");
		checkout = sdf.parse(sc.next());
		
		String error = reservation.updateDates(checkin, checkout);
		
		if (error != null) {
			System.out.println("Reservation Error: " + error);
		}
		else {
		System.out.println("Reservation: " + reservation);
		System.out.println("RESERVATION SUCCESSFUL");
		}
		sc.close();
	}

}
