import java.util.ArrayList;
import java.util.Scanner;



public class Phonebookentry {
	private ArrayList<String> aphonebookentry;
	
	public Phonebookentry() {
		aphonebookentry = new ArrayList<String>();
	}
	
	public void addField(String field){
		//add field to an entry list 
		aphonebookentry.add(field);
		
	}
	public ArrayList<String> getEntry(){
		return aphonebookentry;
	}
//	public void replaceField(int entryId, ){
	//	Interpreter.switcher(Phonebookentry phonebookentry,int index,String param)
		
//	}
	
	public static void addReplace(String name, String birthday, String param){
		boolean found =false;
		Scanner pscn = new Scanner(param);
		for (Phonebookentry entry : ECB.thephonebook){
			for (String field : entry.getEntry())
			if (name.equals(field)){
				for (String otherfield : entry.getEntry()){
					if (birthday.equals(otherfield)){
						String nextparam = "";
						String nextfield = null;
						while (pscn.hasNext()){
							if (nextfield == null){
								nextfield = pscn.next();
							}
							String fieldparam = "";
							while (!Interpreter.isTerm(nextparam) && pscn.hasNext()){
								nextparam = pscn.next();
								fieldparam = fieldparam + nextparam + " ";
							}int index = Interpreter.searchTerm(nextfield);
							Interpreter.switcher(entry,index,fieldparam);
						}
						found =true;pscn.close();
					}
					
				}
			}
		}if (!found){
			String fullparam = "name "+ name + "birthday " + birthday + " " + param;
			Scanner nscn = new Scanner(fullparam);
			Scanner nlscn = new Scanner(fullparam);
			ECB.setEntryId();
			Interpreter.interpret(nscn, nlscn);
		}
		
	}
	public void rmField(String field){
		
	}
	public void updateField(String field,String newField){
		//if field is address (get switch num) then
		//.remove() the address
		//
	}
	
	public String toString(){
		//print multiline string of entry for output file
		String entry ="";
		for (String field : aphonebookentry){
			entry = entry + field+" ";
		}
		return entry;
	}

	public static void main(String[] args) {

	}

}
