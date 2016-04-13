package lab;
import java.util.Random;
public class sortArray {

	public static void main(String[] args) {
		// create array
		int num_entries = 10;
		int[] array = new int[num_entries];
		//insert random numbers into array
		Random rn = new Random();
		//int num =rn.nextInt(999);
		for (int i=0;i<array.length;i++){array[i]=rn.nextInt(999);}
		
		//Sort the array ASC
		//int[] array = {1,9,3,0,8,5,6,3,20,0,1,0};
		int sorted = 0;
		while (sorted < array.length-1){
			int temp = array[sorted];
			if (temp > array[sorted+1] && sorted >= 0){
				array[sorted] = array[sorted+1];
				array[sorted+1] = temp;
			if (sorted > 0){
				sorted--;}
				}
			else {
				sorted++;
			}
		// show each line being sorted:
		for (int i=0;i<array.length;i++){System.out.print(array[i]+" ");}
		System.out.println();
			
	}			
	}
}
