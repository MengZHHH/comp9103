package lab;

public class BMICalc {

	public static void main(String[] args) {
		// 
		double hgt = Double.parseDouble(args[0]);
		int wgt = Integer.parseInt(args[1]);
		double bmi = wgt/Math.pow(hgt,2);
		System.out.println("your bmi is: " +bmi);
		
		if (bmi < 18.5){ System.out.println("underwight");}
		else if (bmi < 25){ System.out.println("normal weight");}
		else if (bmi < 30){ System.out.println("overweight");}
		else { System.out.println("obese");}
		

	}

}
