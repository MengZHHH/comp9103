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
					if (birthday.equals(otherfield)){//the replace
						pscn.useDelimiter(";");
						while (pscn.hasNext()){
							String nextparam;
							nextparam = pscn.next();
							String keyword, input;
							Scanner vscn = new Scanner(nextparam);
							keyword = vscn.next();input = vscn.nextLine();vscn.close();
							entry.rmField(keyword);//field already exists in entry
							int index = Interpreter.searchTerm(keyword);
							Interpreter.switcher(entry,index,input);
						
						}
					found =true;pscn.close();
					}
					
				}
			}
		}if (!found){//the add
			String paramcat ="";
			Scanner vscn = new Scanner(param);
			while (vscn.hasNext()){
			paramcat = paramcat + vscn.next() +"\n";}vscn.close();
			String fullparam = "name "+ name +"\n"+ "birthday " + birthday + "\n" + paramcat;
			Scanner nscn = new Scanner(fullparam);
			Scanner nlscn = new Scanner(fullparam);
			ECB.setEntryId();
			Interpreter.interpret(nscn, nlscn);
		}
		
	}
	public void rmField(String field){
		for (String Field : aphonebookentry){
			if (Field.indexOf(field) != -1){
				aphonebookentry.remove(Field);
			}
		}
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
