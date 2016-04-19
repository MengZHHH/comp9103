package lab;
import java.util.Random;
public class someRandomNumbers {

	public static void main(String[] args) {
// different methods of calling random numbers in a range:
		
		Random rand = new Random();
	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    
	    //or:
	    Random rn = new Random();
	    int answer = rn.nextInt(10) + 1;
	    
	    //or:
	    
	    Random rn = new Random();

	    for(int i =0; i < 100; i++)
	    {
	        int answer = rn.nextInt(10) + 1;
	        System.out.println(answer);
	    }
	    
	    
//
	}

}
