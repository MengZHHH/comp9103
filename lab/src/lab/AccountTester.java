package lab;

public class AccountTester {

	public static void main(String[] args) {
		// test the BankAccount class
		String name = "jason";
		BankAccount jasonsacc = new BankAccount(name, 20000);
		jasonsacc.withdraw(1500);
		System.out.println(jasonsacc.getBalance());
		
	}

}
