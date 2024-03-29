package application;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import model.entities.Reservation;
import java.util.Date;
import java.text.ParseException;


public class Program{

	public static void main(String args[]) throws ParseException{
	
	Scanner sc = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	System.out.print("Room number: ");
	
	int number = sc.nextInt();

	System.out.print("Check-in data (dd/MM/yyyy): ");

	Date checkIn = sdf.parse(sc.next());

	System.out.print("Check-out data (dd/MM/yyyy): ");

	Date checkOut = sdf.parse(sc.next());
	
	if(!checkOut.after(checkIn)){
	
	System.out.println("Error in reservation: Check-out date must be after check-in date.");
	
}
	else{

	Reservation reservation = new Reservation(number, checkIn, checkOut);

	System.out.println("Reservation: " + reservation);

	System.out.println();

	System.out.println("Enter data to update the reservation: ");

	System.out.print("Check-in data (dd/MM/yyyy): ");

	checkIn = sdf.parse(sc.next());

	System.out.print("Check-out data (dd/MM/yyyy): ");

	checkOut = sdf.parse(sc.next());
/* ---------------------------
	Date now = new Date();

	if(checkIn.before(now)||checkOut.before(now)){
	
	System.out.println("Error in reservation: Reservation dates for update must be future.");
}
	else if(!checkOut.after(checkIn)){
	System.out.println("Error in reservation: Check-out date must be after check-in date.");

}
---------------------------  */
//----------------------------------------
	
	String error = reservation.updateDates(checkIn, checkOut);
	if(error != null){
	System.out.println("Error in reservation: " + error);	
	
	}
	
	else{
	System.out.println("Reservation: " + reservation);
	
	}
	
}



	sc.close();
	}//main

}//class