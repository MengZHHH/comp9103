package ECB16S1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
//import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ECB {
	public static ArrayList<Phonebookentry> thephonebook = new ArrayList<Phonebookentry>();
	public static ArrayList<String> results = new ArrayList<String>();
	protected static int entryid = -1;
	protected static int next_available_id = 0;
	private static File infile;
	private static File ifile;//instructions
	private static File outfile;	
	private static File rfile;//results
/**
 * The main method takes the args 0-3 in the order: Phonebookfile, instructionfile, 
 * outputfile, reportfile.
 * 	
 * The method will then perform the following actions on these files:
 * >Build the phone book from input Phonebookfile.
 *> Interpret and perform the instructions from the instructionfile.
 * >Write the outputfile with the resultant cantact information from the phonebook
 * >Write the entries from query instructions to the reportfile.
 * 
 * @param args - filenames: 4 arguments required
 */
	public static void main(String[] args){
		infile = new File(args[0]);
		ifile = new File(args[1]);
		outfile = new File(args[2]);
		rfile = new File(args[3]);

//build the phone book from input file		
		build();	

//open and interpret instructions 
		instruct();
		
		saveResults();//Optional if instruction uses save command

//Print the output phone book file
		savePhonebook();

	}
/**
 * Static method opens file args[2] and writes the phonebook entries 
 * separated by a blank line and with each field on a new line.
 */
	public static void savePhonebook(){
		FileWriter fw;
		try {
			fw = new FileWriter(outfile);
			PrintWriter pw = new PrintWriter(fw);
			for (Phonebookentry phonebookentry : thephonebook){
				pw.println(phonebookentry.toString());
		}pw.close();fw.close();System.out.println("phonebook output file saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Static method scans in the phonebook file specified at arg[0] and 
	 * call the interpreter to build the phonebook
	 */
	public static void build(){
		Scanner scn;
		try {
			scn = new Scanner(infile);
			Scanner lscn = new Scanner(infile);
			while (scn.hasNextLine()){
				setEntryId();
				System.out.println("new entry " + getEntryId());
				Interpreter.interpret(scn,lscn);
				if (true){
				//check for name and birthday exist in entry
					thephonebook.add(getEntryId(),Interpreter.thephonebookentry);}
				}
			System.out.println("phonebook built");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Opens scanner on specified file arg[1] and sends scanner to the interpreter 
	 * to perform commands specified in the file.
	 */
	public static void instruct(){

		try {
			Scanner lscn = new Scanner(ifile);
			Scanner scn = new Scanner(ifile);
			while (scn.hasNextLine()){
				System.out.println("new instruction");
				Interpreter.interpret(scn,lscn);
				}System.out.println("instructions finished");
			
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * Opens file specified at args[3] and writes the query results called 
	 * by the instruction file after sorting the results with the Sort class method.
	 */
	public static void saveResults(){
		
		try {
			FileWriter rfw = new FileWriter(rfile);
			PrintWriter rpw = new PrintWriter(rfw);
			System.out.println("outputting results to file");
			for (String phonebookentry : results){
				rpw.println(phonebookentry);
		}rpw.close();rfw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Static method increments the integer entryid which can be used as a 
	 * key to refer to phonebook entries where needed.
	 */
	public static void setEntryId(){
		entryid++;
		next_available_id++;
	}
	/**
	 * Static method returns the current entryid value which is incremented 
	 * upon each entry to the phonebook during the build() cycle.
	 * @return - integer value
	 */
	public static int getEntryId(){
		return entryid;
	}
}