package lab;

public class countLetter {

	public static void main(String[] args) {
		/*Write a program to read a string from the command-line arguments, count the number of
occurrence for each uppercase or lowercase letter contained in it. (Hint: define two arrays of
size 26 to save the number of upper letter occurrence and lower letter occurrence in the string
respectively)
Note: String methods may be used:
 char charAt(int index): Returns the character at the specified index
 int length(): Returns the length of the string*/
String word = args[0];
int[] countsu = new int[26];
int[] countsl = new int[26];
//populate tables
for (int i=0;i<countsu.length;i++){
	countsu[i] = 0;
	countsl[i] = 0;
}
String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String lower = "abcdefghijklmnopqrstuvwxyz";

for (int i=0;i<word.length();i++){
	for (int j=0;j<26;j++){
		if (word.charAt(i)==upper.charAt(j)){
			countsu[j] = countsu[j]++;	
		}
		if (word.charAt(i)==lower.charAt(j)){
			countsl[j] = countsl[j]++;
		}
		
	}	

}
for (int j=0;j<26;j++){System.out.println(lower.charAt(j));
						System.out.println(countsl[j]);}



	}

}
