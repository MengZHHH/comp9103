
public class Address {

	private String address;
	
	public Address(String address){
		checkAddress(address);
		this.address = address;

	}
	
	public static boolean checkAddress(String address){
		//do some regex
		return true;
	}
	
	public String toString(){
		String addresscat = "address "+this.address;
		return addresscat;
	}
	
	
	public static void main(String[] args) {
		//

	}

}
