import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.util.Locale;

public class ECB {

	public static void main(String[] args) {
		/*This is the main class ECB to be called for phonebook queries and manipulations
		java ECB16S1.ECB phonesample05.txt instructsample05.txt outputfile05.txt reportfile05.txt
		call class, phonerecords in, queries in, modified phonerecords out, query results out
		*/
		//TODO 
		//note on class structure
		//scanning input from file
		//define list object structure
		//define classes to create which will be called from the main() query language interpretor
		//
		String filePath = System.getProperty("user.dir");
		Scanner s = null;
        double sum = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("file.txt")));
            s.useLocale(Locale.US);
            
            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }   
            }
        } finally {
            s.close();
        }


		}

}
