package lab;


public class RecLength {

	public static void main(String[] args) {
		/* a useful message  */
		
		int length = Integer.parseInt(args[0]);
		double width = Integer.parseInt(args[1]);
		double area = (length * width);
		double diag = Math.sqrt(Math.pow(length,2) + Math.pow(width,2));
		
		System.out.println("diagonal length is: " + diag);
		System.out.println("area is: " + area);
		
		
	}

}
