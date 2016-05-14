package ECB16S1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
//import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ECB {
	public static ArrayList<Phonebookentry> thephonebook = new ArrayList<Phonebookentry>();
	public static ArrayList<Phonebookentry> results = new ArrayList<Phonebookentry>();
	protected static int entryid = -1;
	protected static int next_available_id = 0;
	private static File infile;
	private static File ifile;//instructions
	private static File outfile;	
	private static File rfile;//results
	
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
	public static void build(){
		Scanner scn;
		try {
			scn = new Scanner(infile);
			Scanner lscn = new Scanner(infile);
			while (scn.hasNextLine()){
				setEntryId();
				System.out.println("new entry " + getEntryId());
				Interpreter.interpret(scn,lscn);
				thephonebook.add(getEntryId(),Interpreter.thephonebookentry);
				}
			System.out.println("phonebook built");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
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
	
	public static void saveResults(){
		//sort query results
		ArrayList<Phonebookentry> sortedresults = Sort.sortPhonebook(results);
		System.out.println("srted results");
		//output results of instructions
		try {
			FileWriter rfw = new FileWriter(rfile);
			PrintWriter rpw = new PrintWriter(rfw);
			System.out.println("outputting results to file");
			for (Phonebookentry phonebookentry : sortedresults){
				rpw.println(phonebookentry.toString());
		}rpw.close();rfw.close();
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