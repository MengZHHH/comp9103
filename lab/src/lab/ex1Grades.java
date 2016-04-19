package lab;

public class ex1Grades {

	public static void main(String[] args) {
// use switch to take case insen. grade input. output grade % range =
		
		String gradelist = "HDCPF QWERTYUIOASGJKLZXCVBNM";
		char grade = ' ';
		
		String charin = args[0];
		char charinup = charin.toUpperCase().charAt(0);
		
		//Iterate through gradelist and exit once grade has been matched
		for (int i = 0; charinup != grade; i++){
			grade = gradelist.charAt(i);
		}
		System.out.println("Input was:" + charin);
		System.out.println("grade = " + grade);
		System.out.print("grade range:");
		
		switch (grade){
		
		default:
			System.out.println(charin + " is not really a grade, SOMETHING WENT WRONG :-(");
			break;
		case 'H':
			System.out.println("85% to 100%");
			break;
		case 'D':
			System.out.println("75% to 85%");
			break;
		case 'C':
			System.out.println("65% to 75%");
			break;
		case 'P':
			System.out.println("50% to 65%");
			break;
		case 'F':
			System.out.println("<50%");
			break;
		
		}
		

		
		
		
//
	}

}
