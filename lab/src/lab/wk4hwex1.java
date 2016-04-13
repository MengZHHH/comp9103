package lab;

public class wk4hwex1 {
/*to compare strings:
 * stringvariablename.compareTo()
 * or: stringvariablename.equals()
 */
	public static void main(String[] args) {
		// 
		String term = args[0];
		String[] array = new String[args.length];
		for (int i = 0;i<array.length;i++){
			array[i] = args[i];
			//System.out.println(i);
			//System.out.println(args[i]);
		}
		int index = 99;
		for (int k=1;k<array.length;k++){
			//System.out.println(array[k]);

			if (term.compareTo(array[k])==1){
			index = k-1;
			System.out.println(index);

			}
		}
		

	}

}
