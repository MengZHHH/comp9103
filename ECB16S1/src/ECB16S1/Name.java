package ECB16S1;

public class Name {

	private String name;
	
	public Name(String name){
		this.name = name;

	}
	
	public boolean checkName(){
		//do some regex
		if (!name.matches("[A-Za-z \\s]+")){
			System.out.println("incorrect name format: "+name);return false;
		}
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
