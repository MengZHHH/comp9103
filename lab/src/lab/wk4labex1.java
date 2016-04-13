package lab;

public class wk4labex1 {

	public static void main(String[] args) {
		// 
		//double sum = 0;
		int n = Integer.parseInt(args[0]);
		double[][] darray = new double[n][n];
		
		for (int i=1;i<=n;i++){
			for (int j=1;j<=n;j++){
			darray[i-1][j-1]=Double.parseDouble(args[i]);
			//System.out.println(darray[i-1][j-1]);	
			
			}
		}
		double sumdiag = 0;
		for (int i=0; i<darray.length;i++){
			int j = 2-i;
			sumdiag = sumdiag + darray[i][j];
		}
		System.out.println(sumdiag);
		
		
	}

}
