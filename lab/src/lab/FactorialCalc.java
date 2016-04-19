package lab;

public class FactorialCalc {

	public static void main(String[] args) {
		// 
		int num = Integer.parseInt(args[0]);
		int numfac = 1;
		for (int i=1; i<=num; i++){
			numfac = numfac * i;
			
		}
		System.out.println(num + "! = " +numfac);
		

	}

}
