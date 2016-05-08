
public class Phone {

	private String phone;
	
	public Phone(String phone){
		checkPhone(phone);
		this.phone = phone;

	}
	
	public static boolean checkPhone(String phone){
		//do some regex
		return true;
	}
	
	public String toString(){
		String phonecat = "phone "+this.phone;
		return phonecat;
	}
	
	
	public static void main(String[] args) {
		//

	}

}
