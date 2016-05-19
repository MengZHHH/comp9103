package ECB16S1;
public class Phone {

	private String phone;
	
	public Phone(String phone){
		this.phone = phone;

	}
	
	public boolean checkPhone(){
		//do some regex
		if (!phone.matches("\\d{6,10}")){
			System.out.println("incorrect phone format"+phone);return false;
		}
		return true;
	}
	
	public String toString(){
		String phonecat = "phone "+this.phone;
		return phonecat;
	}
	


}
