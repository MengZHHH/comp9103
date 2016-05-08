
public class Email {
private String email;
	
	public Email(String email){
		checkEmail(email);
		this.email = email;

	}
	
	public static boolean checkEmail(String email){
		//do some regex
		return true;
	}
	
	public String toString(){
		String emailcat = "email "+this.email;
		return emailcat;
	}
	
	
	public static void main(String[] args) {
		//

	}


}
