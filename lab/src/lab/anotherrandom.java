package lab;

import java.util.Random;

public class anotherrandom {

	public static void main(String[] args) {
		// 
	for (int i=1;i<999999;i++){
		
		Random rn = new Random();
		int num = rn.nextInt(999);
		
		System.out.print(num);
		if (i % 43 ==0){System.out.println();}
	}
	}

}
