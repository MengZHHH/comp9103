package ECB16S1;
import java.util.Arrays;
import java.util.Scanner;

/** 
 * The Interpreter class consists of static methods for interpreting the text format
 *  instruction file and phonebook input file and to call the necessary classes for 
 *  building the phonebook objects such as Email and compiling these objects into a 
 *  Phonebookentry.
 * @author Jason Lockie
 *
 */
public class Interpreter {
	public static Phonebookentry thephonebookentry;
	private static String[] values = {"name","birthday","phone","email","address",
		"add", "delete", "save", "query"};
/**
 * Static method searches the dictionary of keywords such as "birthday" and "delete" 
 * and returns an integer value used for the control variable in the Switcher method.
 * @param term -a string value
 * @return Returns an integer
 */
	public static int searchTerm(String term){
		int switch_int = Arrays.asList(values).indexOf(term);
		return switch_int;
	}
	/**
	 * Static method returns true when String parameter is found in the dictionary of keywords.
	 * @param term - String value
	 * @return boolean
	 */
	public static boolean isTerm(String term){
		boolean test=false;
		for(String value: values) {
		    if(value.contains(term)){test=true;}
		}
		return test;}
	/**
	 * Takes two scanner objects used for identifying keyword arguments and input 
	 * parameters which they relate to which are used to call the Switcher method.
	 * @param scn - scans by default delimiter
	 * @param lscn - scans by newline characters
	 */
	public static void interpret(Scanner scn, Scanner lscn){
		thephonebookentry = new Phonebookentry();
		lscn.nextLine();
			while (scn.hasNextLine()){
					String instruction = scn.nextLine();
					Scanner iscn = new Scanner(instruction);
					String keyword=null, param="is not set yet";
					if (iscn.hasNext()){
						keyword = iscn.next();
					}
					if (iscn.hasNextLine()){
						param = iscn.nextLine().trim();iscn.close();
					}
					else {iscn.close();continue;}
					int index = -1;
					if (isTerm(keyword)){ index = searchTerm(keyword);}
					else { System.out.println("interpreter found invalid field type or command. Skipping through...");
					lscn.nextLine();
					scn.nextLine();
					continue;}
		
		switcher(thephonebookentry,index,param);

			if (lscn.hasNextLine() && lscn.nextLine().isEmpty()){break;}
			}
}
	/**
	 * Static method contains a switch controlled by 
	 * @param thephonebookentry - The phonebook object which stores all information in an arraylist for each contact.
	 * @param index - control variable for switch comes from searchTerm based on the keyword object found in Interpret method.
	 * @param param - values used to construct the field entry (phone, email, address) into a Phonebookentry.
	 */
public static void switcher(Phonebookentry thephonebookentry,int index,String param){	
	switch (index){
	
	default:{
		System.out.println("oops, not sure how to perform that command..."); break;}

	case 5:{//add
		String name,birthday;
		Scanner pscn = new Scanner(param);
		pscn.useDelimiter(";");
		String argname = pscn.next();String argbirthday = pscn.next();
		name = argname.replace("name ","").trim();birthday = argbirthday.replace("birthday ", "").trim();
		param = pscn.nextLine();
		Phonebookentry.addReplace(name,birthday,param);pscn.close();break;
	}
	case 6:{//delete
		Phonebookentry.delete(param);break;
	}
	case 7:{//save
		ECB.saveResults();
		break;
	}
	case 8:{//query
		Phonebookentry.query(param);break;
	}
	case 4:{//address
		Address address = new Address(param);
		if (address.checkAddress()){
		thephonebookentry.addField(address.toString());}
		else { System.out.println("Not a valid address format: "+address.toString());}
		break;}

	case 0:{//name
		Name name = new Name(param);
		if (name.checkName()){
		thephonebookentry.addField(name.toString());}
		else { System.out.println("Not a valid phone format: "+name.toString());}
		break;}
	case 2:{//phone
		Phone phone = new Phone(param);
		if (phone.checkPhone()){
		thephonebookentry.addField(phone.toString());}
		else { System.out.println("Not a valid phone format: "+phone.toString());}
		break;}
	case 3:{//email
		Email email = new Email(param);
		if (email.checkEmail()){
		thephonebookentry.addField(email.toString());}
		else { System.out.println("Not a valid email format: "+email.toString());}
		break;}
	case 1:{//birthday
		Birthday birthday = new Birthday(param);
		if (birthday.checkBirthday()){
		thephonebookentry.addField(birthday.toString());}
		else { System.out.println("Not a valid birthday format: "+birthday.toString());}
		break;}

}
}
}

