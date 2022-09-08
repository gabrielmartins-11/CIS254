import java.util.Scanner;
import java.util.Calendar;

public class NameAndAge {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Calendar currentDate = Calendar.getInstance();
		
		String name;
		int yearBorn;
		int currentYear = currentDate.get(Calendar.YEAR);


		System.out.println("\nHello, what is your name?");
		name = in.nextLine();

		System.out.println("\nWhat year were you born in?");
		yearBorn = in.nextInt();

		System.out.println("\nHello " + name + "! You are approxametly " + (currentYear - yearBorn) + " years old!\n");
	}
}