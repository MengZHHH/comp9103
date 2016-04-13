package lab;

import java.util.Scanner;

public class tutwk5hwex1 {

	public static void main(String[] args) {
		// 
		Scanner scn = new Scanner(System.in);
		String word = args[0];
		//scn.close();
		int alength = 0;
		while (scn.hasNext()){
			alength++;
			String x = scn.next();
			System.out.println(x);
		}//scn.close();
		String[] paragraph = new String[alength];
		int[] counts = new int[paragraph.length];
		for (int i=0;i<paragraph.length;i++){
			paragraph[i] = scn.next();
		}
		for (int i=0;i<paragraph.length;i++){
			System.out.println(paragraph[i]);
		}

	}

}
