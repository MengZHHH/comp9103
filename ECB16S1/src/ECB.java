import java.io.*;
import java.util.Arrays;
//import java.io.File;
import java.util.Scanner;
//import java.util.Locale;
//import arrayObject;
public class ECB {
	//CONFIG------------------
	private static int address_array_size = 10;//maximum amount of fields in address
	//------------------------
	private static File infile;
	private static Scanner scn;
	private File outfile;
	private FileWriter fw;
	protected static int entryid = -1;
	
	private static void setEntryId(){
		entryid++;
	}
	public int getEntryId(){
		return entryid;
	}
	/**check if the current string in the scanner object is a field identifier*/
	private static boolean checkFieldNames(String currentscan){
		String[] fieldnames = {"name","birthday","phone","email","address"};
		boolean test=false;
		for(String fieldname: fieldnames) {
		    if(fieldname.contains(currentscan)){test=true; System.out.println("found next field");}
		}
		return test;
	}
	/*create method here to take in the scans and add to objects
	 * ie if addr: then collect array (with nulls if necessary) and 
	 */
	public static void main(String[] args){
		//lets make the file------------------------------------------------------------------
	/*	try {
			FileWriter fw = new FileWriter(args[0]);
			Scanner s = new Scanner(System.in);
			PrintWriter o = new PrintWriter(fw);
			while (s.hasNext()){
				o.println(s.next());
			}
			o.close();
			s.close();
		} catch (IOException e) {
			System.out.println("error with file name");
			e.printStackTrace(); 
		} ----------------------------------------------------------------------------------------*/
		
		//lets scan the file and find what inside
		setEntryId();//Where/when do we know the new entry occurs as opposed to new fields of the same entry??
		
		System.out.println("mm");
		infile = new File(args[0]);
		try {
			scn = new Scanner(infile);
			//scn.useDelimiter(' ');
			String currentfield = scn.next();
			while (scn.hasNext()){//how can this be stopped after the end of file is reached??
				boolean newfield;
				//--This can be a method --might need it for other switches also----------------------
				String[] fieldnames = {"name","birthday","phone","email","address"};
				int index = Arrays.asList(fieldnames).indexOf(currentfield);
				//------------------------------------------------------------------------
				switch (index){
				
					case 4://address
						String[] address = new String[address_array_size];
						newfield = false;
						for (int i=0;i<address.length;i++){
							String currentscan = "";
							if (newfield == false){currentscan = scn.next();}

							if (newfield == false && checkFieldNames(currentscan) == false){
								address[i] = currentscan;
							}
								else { 
									if (newfield == false){currentfield = currentscan;}
									address[i] = null; newfield = true;} 
							}
							Address addressid = new Address(entryid,address);//will addressid cause naming conflict??
							System.out.println(addressid.toString());
							for (int j=0;j<address.length;j++){
								System.out.println(address[j]);
							}break;
				
					case 0://name
						String[] name = new String[6];
						newfield = false;
						for (int i=0;i<name.length;i++){
							String currentscan = "";
							if (newfield == false){currentscan = scn.next();}

							if (newfield == false && checkFieldNames(currentscan) == false){
								name[i] = currentscan;
							}
								else { 
									if (newfield == false){currentfield = currentscan;}
									name[i] = null; newfield = true;} 
							}
							//create new name entry for the current entryid
							//String nameid = "name"+Integer.toString(entryid);
							Name nameid = new Name(entryid,name);
							System.out.println(nameid.toString());
						/*	for (int j=0;j<name.length;j++){
								System.out.println(name[j]);
							} */ break;
					default:
						System.out.println("not a valid case yet");break;
					case 1:
						System.out.println("found a birthday"); currentfield="";break;
				}

					
			}
			

			//switch here on argument
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find the input file specified. Check the filename.");
			e.printStackTrace();
		} 
		
	}
	
}
/* old work
	private static Scanner scn = null;
	private static int caseno=0;
	private static String query = "";
	
	//method
    public static boolean querytest(String query){
    	String[] commands = {"add", "delete", "save", "print"};
    	for (int i=0;i<commands.length;i++){
    		if (commands[i].compareTo(query)==0){
    			caseno=i;
    			return true;}
    			else {}
    		}
    	return false;
    	}
	
	public static void main(String[] args) throws IOException  {
		
        try {
            scn = new Scanner(new BufferedReader(new FileReader("file.txt")));
            query = scn.next();
            if (scn.hasNext() && querytest(query)){
            while (scn.hasNext()) {

                    switch (caseno){
                    case 1:
                    	//write the array object in its class with an add method
                    	String inputstr ="";
                    	boolean commandfound = false;
                    	do {
                    		String nextterm = scn.next();
                    		if (querytest(nextterm)==false){
                    			inputstr = inputstr +" "+ nextterm;
                    		}
                    		else {commandfound = true;}
                    	                 		
                    	} while (scn.hasNext() && commandfound == false);
                    	//stringOfType.collect(inputstr);
                    	//System.out.println(arrayObject.add(inputstr));//just print the add method output atm
                    	System.out.println(inputstr);
                    	break;
                    default:
                    	System.out.println("default case, dont understand theargument");
                    	break;
                    }
                              
            }
      
            } else {
                scn.next();}
        } finally {scn.close();}
            

		}

}*/
