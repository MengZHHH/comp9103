package lab;

public class ex3Pyramid {

	public static void main(String[] args) {
// 
		int num = Integer.parseInt(args[0]);
		
		//init no stars on line one and count up in odds after print newline		
		for (int stars = 1; stars < num; stars += 2)
		{
			//print (half) the no of spaces from left until reaching a star location
		    for (int spaces = 0; spaces < (16 - stars / 2); spaces++)
		    {
		        System.out.print(" ");
		    }  
		    	//use current no of stars and keep printing on line til all are printed
		    	for (int printed = 0; printed < stars; printed++)
		    	{
		        System.out.print("*");
		    	}
		    System.out.println("");
		}

//		
	}
}