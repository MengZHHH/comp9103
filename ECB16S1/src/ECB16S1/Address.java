package ECB16S1;
public class Address {

	private String address;
	
	public Address(String address){
		
		this.address = address;

	}
	
	public boolean checkAddress(){
		//do some regex
		if (!address.matches("[A-Za-z0-9'\\.\\-\\s\\,\\#\\&\\n\\r/]+")){
		System.out.println("Address: "+address+ " Wrong format!!");
		return false;
		}
		return true;
	}
	
	public String toString(){
		String addresscat = "address "+this.address;
		return addresscat;
	}
	


}
