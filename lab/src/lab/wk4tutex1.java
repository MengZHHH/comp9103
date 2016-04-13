package lab;

public class wk4tutex1 {

	public static void main(String[] args) {
		//
		//double[][] prices = new double[3][3];
		double[][] prices = {{1,2,3},{4,5,6}};
		//String[] studentNames = new String[3];
		for (int j=0;j<prices.length ;j++){
			for (int k=0;k< prices[j].length;k++){
				System.out.println("$"+prices[j][k]+" ");
			}
		}

	}

}
