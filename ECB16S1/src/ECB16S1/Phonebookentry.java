package ECB16S1;
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
							nextparam = pscn.next().trim();
							String keyword, input;
							Scanner vscn = new Scanner(nextparam);
							keyword = vscn.next();input = vscn.nextLine();vscn.close();
							entry.rmField(keyword);//field already exists in entry
							System.out.println("adding keyword:"+keyword+"with input:"+input);
							int index = Interpreter.searchTerm(keyword);
							Interpreter.switcher(entry,index,input);
						
						}
					found =true;pscn.close();
					}
					
				}
			}
		}if (!found){//the add
			System.out.println("addReplace did not find matching entry");
			String paramcat ="";
			Scanner vscn = new Scanner(param);
			vscn.useDelimiter(";");
			while (vscn.hasNext()){
			paramcat = paramcat + vscn.next().trim() +"\n";}vscn.close();
			String fullparam = "name "+ name +"\n"+ "birthday " + birthday + "\n" + paramcat;
			System.out.println("sending:"+fullparam+"to the interpreter");
			Scanner nscn = new Scanner(fullparam);
			Scanner nlscn = new Scanner(fullparam);
			//ECB.setEntryId();
			Interpreter.interpret(nscn, nlscn);
			//ECB.thephonebook.add(ECB.getEntryId(),Interpreter.thephonebookentry);//out of bounds exception
			ECB.thephonebook.add(Interpreter.thephonebookentry);
		}
		
	}
	public void rmField(String field){
		for (String Field : aphonebookentry){
			if (Field.indexOf(field) != -1){
				aphonebookentry.remove(Field);
			}
		}
	}
	public static void query(String param){
		//query phone 9110110
		//query name joe bloggs
		//query birthday 12/04/1999
		for (Phonebookentry entry : ECB.thephonebook){
			System.out.println("quering new entry");
			System.out.println(entry.getEntry().getClass());
			for( int i=0;i<entry.getEntry().size();i++){
				String field = entry.getEntry().get(i);
			//for (String field : entry.getEntry()){
				System.out.println("entry field:"+field+"compared to param:"+param);
				if (field.equals(param)){
					ECB.results.add(entry);
					System.out.println("query matched an entry");
				}
			}
		}
	}
	public static void delete(String param){
		//delete Jeff Vader ; 8-07-1980
		//delete Jaff vaders
		Scanner scn = new Scanner(param);
		scn.useDelimiter(";");
		String name,birthday=null;
		name = scn.next().trim(); 
		if (scn.hasNext()){
			birthday = scn.next().trim();scn.close();
			//for (Phonebookentry entry : ECB.thephonebook){//throws concurrent modification error
			for (int i=0;i<ECB.thephonebook.size();i++){
				Phonebookentry entry = ECB.thephonebook.get(i);
				for (String field : entry.getEntry()){
					if (name.equals(field)){if (birthday==null){ECB.thephonebook.remove(entry);}
						for (String otherfield : entry.getEntry()){
							if (birthday.equals(otherfield)){
								ECB.thephonebook.remove(entry);
								
							}
						}
					}
				}
			}
		}
	}
	
	public String toString(){
		//print multiline string of entry for output file
		String entry ="";
		for (String field : aphonebookentry){
			entry = entry + field+"\n";
		}
		return entry;
	}
	public String getField(String field){
		String param =null;
		Scanner scn;
		for (String entryfield : aphonebookentry){
			scn = new Scanner(entryfield);
			if (scn.next().equals(field))
				param= scn.nextLine();scn.close();
		}
		return param;
	}

	public static void main(String[] args) {

	}

}
