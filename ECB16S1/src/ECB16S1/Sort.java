package ECB16S1;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Quicksort method implemented for ArrayList<Phonebookentry> type. Sorts first by alphabetical order
 *  in Name and then ascending order in Birthday.
 * @author Jason Lockie
 *
 */
public class Sort {
	private static ArrayList<Phonebookentry> results;
    private int length;
/**
 * 
 * @param query - arraylist of Phonebookentry type from the Phonebookentry.query() method
 * @return - returns the ArrayList<Phonebookentry> in a sorted order by Name and then Birthday
 */
	public static ArrayList<Phonebookentry> sortPhonebook(ArrayList<Phonebookentry> query){
        Sort sorter = new Sort();
        results = query;
        ArrayList<Phonebookentry> srtdquery = sorter.sort();
		
		return srtdquery;
	}
	
 /**
  * First performs quicksort on name (ascending order) then by birthday ascending order.
  * @param results - arraylist of Phonebookentry type
  */
    public ArrayList<Phonebookentry> sort() {
    	length = results.size() -1; 
        if (results == null || results.size() == 0) { 
        	System.out.println("Sorter didnt find entries to sort");
        	return results;
        }
        
        quickSortByName(0, length);
        fineSortByBirthday();
        return results;
    }

    private void quickSortByName(int lowindex, int highindex) {
        
        int i = lowindex;
        int j = highindex;
        String pivot = results.get(length/2).getField("name");
        while (i <= j) {
           
            while (results.get(i).getField("name").compareTo(pivot) < 0) {
                i++;
               
            }
            while (results.get(j).getField("name").compareTo(pivot) > 0) {
                j--;
            
            }
            if (i <= j) {

            	swapIt(i, j);
                i++;
                j--;
            	
            }
        }
        if (lowindex < j)
        	quickSortByName(lowindex, j);
        if (i < highindex)
        	quickSortByName(i, highindex);
    }
    
    private void fineSortByBirthday() {
        
        int i = 0;
        int j = results.size()-1;

        while (j>0) {
           i=0;
   
            while (!results.get(i).getField("name").equals(results.get(j).getField("name")) && i<j) {
                i++;
            }
            if (results.get(i).getBirthdate()>results.get(j).getBirthdate()){
                swapIt(i, j);}
                j--;
        }
            
        }
 /**
  * Swap function for two Phonebookentry in an arraylist at indices i and j.
  * @param i
  * @param j
  */
    private void swapIt(int i, int j) {
    	Collections.swap(results, i, j);
        
    }


}
