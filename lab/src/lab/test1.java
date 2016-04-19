package lab;

public class test1 {

	public static void main(String[] args) {
		// 
		int lines = Integer.parseInt(args[0]);
		
		for (int line=1; line <= lines; line++){
			System.out.print("|");
			
			for (int j =0; j<line ;j++){
				System.out.print(" ");
			}
			System.out.print("*");
			
			for (int k =lines; k>line ;k--){
				System.out.print(" ");
			}
			
		System.out.println("|");		
		}
	}

}
