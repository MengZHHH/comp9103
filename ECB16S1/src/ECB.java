import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
//import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ECB {
	public static ArrayList<Phonebookentry> thephonebook = new ArrayList<Phonebookentry>();
	protected static int entryid = -1;
	protected static int next_available_id = 0;
	private static File infile;
	private static File ifile;//instrauctions
	private static File outfile;	
	private static File rfile;//results


	
	public static void main(String[] args){
		infile = new File(args[0]);
		ifile = new File(args[1]);
		outfile = new File(args[2]);
		rfile = new File(args[3]);
		try {
			Scanner scn = new Scanner(infile);
			Scanner lscn = new Scanner(infile);
			FileWriter fw = new FileWriter(outfile);
			PrintWriter pw = new PrintWriter(fw);

//build the phone book from input file		
		while (scn.hasNextLine()){
		setEntryId();
		System.out.println("new entry " + getEntryId());
		Interpreter.interpret(scn,lscn);
		thephonebook.add(getEntryId(),Interpreter.thephonebookentry);
		}

//open and interpret instructions
		scn = new Scanner(ifile);
		lscn = new Scanner(ifile);
		while (scn.hasNextLine()){
			System.out.println("new instruction");
			Interpreter.interpret(scn,lscn);
			}
		//sort query results
		//output results of instructions
		
//Print the output phone book file
			for (Phonebookentry phonebookentry : thephonebook){
					pw.println(phonebookentry.toString());
				pw.println("blank line");
			}pw.close();fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setEntryId(){
		entryid++;
		next_available_id++;
	}
	public static int getEntryId(){
		return entryid;
	}
}