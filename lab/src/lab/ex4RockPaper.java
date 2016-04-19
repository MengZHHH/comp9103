package lab;

import java.util.Random;

public class ex4RockPaper {

	public static void main(String[] args) {
/*  the scissor cuts the paper; the rock knocks the scissor; and the
		paper wraps the rock.*/
		int player1 = Integer.parseInt(args[0]);
		
		Random rn = new Random();
	    int player2 = rn.nextInt(3);
	    
	    System.out.println(player1);
	    System.out.println(player2);
	    
	    //if matching no winner
	    if (player1 == player2){
	    	System.out.println("no winner, choose wisely and play again");}
	    else {
	    	//switch on user input
	    	switch (player1){
	    	case 0:
	    		System.out.println("you choice: " + player1 +" is a rock");
	    		//switch on random number
	    		switch (player2){
	    		case 0:
	    			System.out.println("paper covers rock -> you loose");
	    			break;
	    		case 2:
	    			System.out.println("rock blunt scissor -> you win");
	    			break;
	    		}
	    		break;
	    		
	    	case 1:
	    		System.out.println("you choice: " + player1 +" is paper");
	    
	    		switch (player2){
	    		case 0:
	    			System.out.println("paper covers rock -> you win");
	    			break;
	    		case 2:
	    			System.out.println("scissor cut your paper -> you loose");
	    			break;
	    	
	    		}
	    		break;
	    	case 2:
	    		System.out.println("you choice: " + player1 +" is scissor");
	    		
	    		switch (player2){
	    		case 0:
	    			System.out.println("rock killed your scissors -> you loose");
	    			break;
	    		case 1:
	    			System.out.println("you cut the paper -> you win");
	    			break;
	    		}
	    		break;
	    	}
	    
	    
	    
	    }

	
	    
	    
	    
//
	}

}
