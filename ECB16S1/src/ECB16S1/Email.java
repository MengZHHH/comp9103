package ECB16S1;
public class Email {
private String email;
	
	public Email(String email){
		this.email = email;

	}
	
	public boolean checkEmail(){
		//do some regex
		if (!email.matches("[A-Za-z0-9\\.\\@]+")){
			System.out.println("Wrong email format: "+email);return false;
		}
		return true;
	}
	
	public String toString(){
		String emailcat = "email "+this.email;
		return emailcat;
	}
	


}
