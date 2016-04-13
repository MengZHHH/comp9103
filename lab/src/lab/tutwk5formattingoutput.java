package lab;

import java.util.Scanner;

public class tutwk5formattingoutput {

	public static void main(String[] args) {
		// 
		Scanner scn = new Scanner(System.in);
		
		String surname = scn.next();
		String firstname = scn.next();
		scn.useDelimiter("-");
		int day = scn.nextInt();
		int month = scn.nextInt();
		int year = scn.nextInt();
		
	
		System.out.printf("%s %s was born on %2i %2i %4i",firstname, surname, day, month, year);

	}

}
