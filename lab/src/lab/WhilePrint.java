package lab;

public class WhilePrint {

	public static void main(String[] args) {
		// msg
		double i = 1;
		
		
		while (i < 1200) {
			System.out.println("quote");
			i++ ;
			
			if ((i % 2) == 0){
				System.out.println("divisible by two");
			}
		
			else {
				System.out.println("NOT divisible by two");
			}
			
		}

	}

}
