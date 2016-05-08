package ECB16S1;

public class Name {

	private String name;
	
	public Name(String name){
		checkName(name);
		this.name = name;

	}
	
	public static boolean checkName(String name){
		//do some regex
		return true;
	}
	
	public String toString(){
		String namecat = "name "+this.name;
		return namecat;
	}
	
	
	public static void main(String[] args) {
		//

	}

}
