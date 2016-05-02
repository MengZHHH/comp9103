
public class Address {

	private String[] addresslist;
	
	public Address(int id, String[] address){
		checkAddress(address);
		addresslist = address;
	}
	
	public static boolean checkAddress(String[] address){
		//do some regex
		return true;
	}
	
	public String toString(){
		//print format as a string
		String addresscat = "";
		for (String address : addresslist){
			if (address == null){}else{
				addresscat = addresscat +" "+ address;}
		}
		return addresscat;
	}
	
	
	public static void main(String[] args) {
		//

	}

}
