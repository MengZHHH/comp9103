package ECB16S1;
import java.util.ArrayList;
import java.util.Collections;


public class Sort {

	public static ArrayList<Phonebookentry> sortPhonebook(ArrayList<Phonebookentry> list){
        Sort sorter = new Sort();
        ArrayList<Phonebookentry> results = list;//ECB.results;
        sorter.sort(results);
		
		return results;
	}
	
	private ArrayList<Phonebookentry> results;
    private int length;
 
    public void sort(ArrayList<Phonebookentry> results) {
         
        if (results == null || results.size() == 0) {
            return;
        }
        this.results = results;
        length = results.size();
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        String pivot = results.get(lowerIndex+(higherIndex-lowerIndex)/2).getField("name");
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (results.get(i).getField("name").compareTo(pivot) < 0) {
                i++;
            }
            while (results.get(j).getField("name").compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
    	Collections.swap(results, i, j);
    	//Phonebookentry temp = results.get(i);
    	//results.set(i) = results.get(j);
        //results.set(j) = temp;
        
    }
     
    public static void main(String[] args){
         


    }


}
