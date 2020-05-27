/** This is a little study about EXPECTIONS
 * in this example we have a VERY BAD SOLUTION
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
		
		System.out.println("*****************************************************************");
		System.out.println("******                    WELCOME                           *****");
		System.out.println("*****************************************************************");
		System.out.println("");
		System.out.println("Enter Room Number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Enter Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Enter Check-out date (dd/MM/yyyy); ");
		Date checkout = sdf.parse(sc.next());
		
		Date now = new Date();
		
		if(checkin.before(now)){
			System.out.println("Reservation Error: Date must be future day");
		}
		
		else if(!checkout.after(checkin)) {
			System.out.println("Reservation Error: Check-out date must be after Check-in date");
		}
		
		else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println("RESERVATION SUCCESSFUL");
			System.out.println("*****************************************************************");
			
			
		}
		
		
		
		
		sc.close();
	}

}
