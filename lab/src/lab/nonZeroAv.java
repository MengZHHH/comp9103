package lab;

public class nonZeroAv {

	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		int sum = 0;
		do{
			
			System.out.println(args[i]);
			
			if (Integer.parseInt(args[i])!=0){
				sum = sum + Integer.parseInt(args[i]);
				j++;
				
			}
			i++;
		}while (i<args.length);
		double av = sum / j;
		System.out.println(av);

	}

}
