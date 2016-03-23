package lab;

public class ex2Triangle {

	public static void main(String[] args) {
// make a triangle print from numbers
		int num = Integer.parseInt(args[0]);
		//set current line no to at each new line and count to total base number (input)
		for (int cline = 1; cline <= num; cline++){
			//print the current number til it reaches the line number
			for (int cnum = 1; cnum <= cline; cnum++){
				System.out.print(cnum + " ");
			}
		System.out.println("");	
		}
		
		
//		
	}
		

}
