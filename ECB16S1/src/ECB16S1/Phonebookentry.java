package ECB16S1;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Phonebookentry hoolds an arraylist<String> which contains all the "fields" (Email,Address,etc.) for a particular Phonebook contact.
 * @author Jason Lockie
 *
 */
public class Phonebookentry {
	private ArrayList<String> aphonebookentry;
	
	public Phonebookentry() {
		aphonebookentry = new ArrayList<String>();
	}
	/**
	 * Recieves a string value which is entered to the Phonebookentry arraylist. THe first index of the string should contain the keyword argument for the field type.
	 * @param field - String
	 */
	public void addField(String field){
		//add field to an entry list 
		aphonebookentry.add(field);		
	}
	/**
	 * Class method: returns the arraylist<string> holding the Phonebookentry contact information.
	 * @return - ArrayList<String>
	 */
	public ArrayList<String> getEntry(){
		return aphonebookentry;
	}
	/** 
	 * Static method searches Thephonebook for matching phonebook entries based on the input parameters "name, "birthday". If the entry exists then the contact information in the input "param" is appended or updated. If an existing entry is not found then a new entry is added to the phonebook.
	 * @param name - string of contact name
	 * @param birthday - string of contact birthday
	 * @param param - string of additional contact information
	 */
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
							entry.rmField(keyword);
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
			vscn.useDelimiter(";");
			while (vscn.hasNext()){
			paramcat = paramcat + vscn.next().trim() +"\n";}vscn.close();
			String fullparam = "name "+ name +"\n"+ "birthday " + birthday + "\n" + paramcat;
			Scanner nscn = new Scanner(fullparam);
			Scanner nlscn = new Scanner(fullparam);
			//ECB.setEntryId();
			Interpreter.interpret(nscn, nlscn);
			//ECB.thephonebook.add(ECB.getEntryId(),Interpreter.thephonebookentry);
			ECB.thephonebook.add(Interpreter.thephonebookentry);
		}
		
	}
	/**
	 * Recieves a string as an argument. If the string matches an entry in the Phonebookentry then it is removed.
	 * @param field - String value should contain the keyword argument as the first index.
	 */
	public void rmField(String field){
		for (String Field : aphonebookentry){
			if (Field.indexOf(field) != -1){
				aphonebookentry.remove(Field);
			}
		}
	}
	/**
	 * Static method: queries all entries in Thephonebook for matching fields with the Sting paramater. If entries are found then the entry is entered to the results output file.
	 * @param param - String value contains keyword argument at first index followed by the contacts information for the corresponding keyword's field.
	 */
	public static void query(String param){

		String beginquery = "====== query "+param+" ======"+'\n';
		String finishquery = "====== end of query "+param+" ======"+'\n';
		ArrayList<Phonebookentry> query = new ArrayList<Phonebookentry>();
		ECB.results.add(beginquery);
		for (Phonebookentry entry : ECB.thephonebook){
			for (String field : entry.getEntry()){
				if (field.equals(param)){
					query.add(entry);
				}
			}
		}
		query = Sort.sortPhonebook(query);
		if (query!=null){ 
		for (Phonebookentry entry : query){
			ECB.results.add(entry.toString());
		}
		}
		ECB.results.add(finishquery);
	}
	public double getBirthdate(){
;
		String birthday = getField("birthday");
		int day,month,year;
		String[] datearr = birthday.split("-");
		day = Integer.parseInt(datearr[0].trim());
		month= Integer.parseInt(datearr[1].trim());
		year= Integer.parseInt(datearr[2].trim());
		float simplecompare = (year+((float)month/12)+((float)day/365));
		return simplecompare;
	}
	/**
	 * Static method searches the phonebook for a matching name or matching name and birthday and deletes the corresponding entry from the phonebook.
	 * @param param - example: Jaff vaders, or: Jeff Vader ; 8-07-1980
	 */
	public static void delete(String param){

		Scanner scn = new Scanner(param);
		scn.useDelimiter(";");
		String name,birthday=null;
		name = scn.next().trim(); 
		if (scn.hasNext()){
			birthday = scn.next().trim();scn.close();
			//for (Phonebookentry entry : ECB.thephonebook){
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
	/**
	 * Prints multiline string of phonebook  entry for output phone book file
	 */
	public String toString(){

		String entry ="";
		for (String field : aphonebookentry){
			entry = entry + field+"\n";
		}
		return entry;
	}
	/**
	 * Searches the phonebook entry object for a matching entry and returns the entry as a string
	 * @param field - Search term including keyword argument for the field
	 * @return - String value
	 */
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

	
}
