package lab;

public class pascaal {

	public static void main(String[] args) {
		// pascal's triangle
		int n = Integer.parseInt(args[0]);
		int[][] tri = new int[n][n];
		for (int i = 0;i<n;i++){
			for (int j=0;j<n;j++){
				if (i<1 || j<1){tri[i][j]=1;}
				else{
				
				
				tri[i][j] = tri[i-1][j] + tri[i-1][j-1];
				}
				
			}
		}
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				
				System.out.print(tri[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
		

	}

}
