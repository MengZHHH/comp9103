package lab;
import java.util.Scanner;
public class tutwk5Interest {

	public static void main(String[] args) {
		// For each year, calculate and print out the year number, the money at the start of the
		//year, the interest earned and the total at the end of the year for a given number of years. F
		Scanner scn = new Scanner(System.in);
		
		double principle = scn.nextDouble();
		double intrate = scn.nextDouble();
		double years = scn.nextDouble();
		scn.close();
		
		
		for (int i = 1;i<years;i++){
			
			System.out.print("year " + i);
			System.out.print(" principle: " + principle + " interest: ");
			System.out.print(intrate*principle/100);//print interest
			principle = principle + (principle*intrate/100);
			System.out.println(" total: " + principle);//print total
			
			
		}

	}

}
