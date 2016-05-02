
public class Name {

	private String[] namelist;
	
	public Name(int id, String[] names){
		checkName(names);
		namelist = names;
	}
	
	public static boolean checkName(String[] names){
		//do some regex
		return true;
	}
	
	public String toString(){
		//print format as a string
		String namecat = "";
		for (String name : namelist){
			if (name == null){}else{
			namecat = namecat +" "+ name;}
		}
		return namecat;
	}
	
	
	public static void main(String[] args) {
		//

	}

}
