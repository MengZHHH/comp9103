package ECB16S1;
public class Birthday {
	
private String birthday;
	
	public Birthday(String birthday){
		checkBirthday(birthday);
		this.birthday = birthday;

	}
	
	public static boolean checkBirthday(String birthday){
		//do some regex
		return true;
	}
	
	public String toString(){
		String birthdaycat = "birthday "+this.birthday;
		return birthdaycat;
	}
	
	
	public static void main(String[] args) {
		//

	}


}
