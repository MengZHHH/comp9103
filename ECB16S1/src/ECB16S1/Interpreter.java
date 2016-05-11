package ECB16S1;
import java.util.Arrays;
import java.util.Scanner;


public class Interpreter {
	public static Phonebookentry thephonebookentry;
	private static String[] values = {"name","birthday","phone","email","address","add", "delete", "save", "query"};

	public static int searchTerm(String term){
		int switch_int = Arrays.asList(values).indexOf(term);
		return switch_int;
	}
	
	public static boolean isTerm(String term){
		boolean test=false;
		for(String value: values) {
		    if(value.contains(term)){test=true;}
		}
		return test;}
	
	public static void interpret(Scanner scn, Scanner lscn){
		thephonebookentry = new Phonebookentry();
		lscn.nextLine();
			while (scn.hasNextLine()){
					String instruction = scn.nextLine();
				System.out.println("interpreter instruction:"+instruction);
					Scanner iscn = new Scanner(instruction);
					String keyword=null, param;
					if (iscn.hasNext()){
						keyword = iscn.next();
					}
					if (iscn.hasNextLine()){
						param = iscn.nextLine().trim();iscn.close();
						System.out.println("param:"+param);
					}
					else {iscn.close();continue;}
					int index = -1;
					if (isTerm(keyword)){ index = searchTerm(keyword); System.out.println("index = "+values[index]);}
					else { System.out.println("interpreter found invalid field type or command. Skipping through...");
					lscn.nextLine();
					scn.nextLine();
					continue;}
		
		switcher(thephonebookentry,index,param);			
					
			if (lscn.hasNextLine() && lscn.nextLine().isEmpty()){break;}//does this break loop early enough??
			}
}
public static void switcher(Phonebookentry thephonebookentry,int index,String param){	
	switch (index){
	
	default:{
		System.out.println("not a valid case yet"); break;}//scn.next();

	case 5:{//add
		String name,birthday;
		Scanner pscn = new Scanner(param);
		pscn.useDelimiter(";");
		String argname = pscn.next();String argbirthday = pscn.next();
		name = argname.replace("name ","").trim();birthday = argbirthday.replace("birthday ", "").trim();
		param = pscn.nextLine();
		System.out.println("addReplace name:"+name);
		System.out.println("addReplace birthday:"+birthday);
		System.out.println("param for add or replace:"+param);
		Phonebookentry.addReplace(name,birthday,param);pscn.close();break;
	}
	case 6:{//delete
		System.out.println("deleting..."+param);
		Phonebookentry.delete(param);break;
	}
	case 7:{//save
		//ECB.outputResults();
		break;
	}
	case 8:{//query
		Phonebookentry.query(param);break;
	}
	case 4:{//address
		Address address = new Address(param);
		System.out.println("added address");
		thephonebookentry.addField(address.toString()); break;}

	case 0:{//name
		Name name = new Name(param);
		System.out.println("added name");
		thephonebookentry.addField(name.toString()); break;}
	case 2:{//phone
		Phone phone = new Phone(param);
		System.out.println("added phone");
		thephonebookentry.addField(phone.toString()); break;}
	case 3:{//email
		Email email = new Email(param);
		System.out.println("added email");
		thephonebookentry.addField(email.toString()); break;}
	case 1:{//birthday
		Birthday birthday = new Birthday(param);
		System.out.println("added birthday");
		thephonebookentry.addField(birthday.toString()); break;}

}
}

	public static void main(String[] args) {
		

	}
}

