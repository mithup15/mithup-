package tic;
import java.util.*;
public class TicTacToeBoard {

	  /**
	   * This method should load a string into your TicTacToeBoard class.
	   * @param board The string representing the board
	   */
		String str;
	  public TicTacToeBoard(String board) {
		  this.str=board.toLowerCase();
	  }

	  /**
	   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
	   * @return an enum value corresponding to the board evaluation
	   */
	  public Evaluation evaluate() 
	  {
		  int countx=0;
		  int counto=0;
		 if(str.length()!=9)
			 return Evaluation.UnreachableState;
		 for(int i=0;i<str.length();i++) {
			 if(str.charAt(i)=='x')
				 countx++;
			 else if(str.charAt(i)=='o')
				 counto++;
	   }
	     if(Math.abs(countx-counto)>1) 
		  return Evaluation.UnreachableState;
	     if(check(str,'x'))
	    	 return Evaluation.Xwins;
	     else if(check(str,'o'))
	    	 return Evaluation.Owins;
	     else
	    	 return Evaluation.NoWinner;
	     
	}
	  
	private boolean check(String str2, char c) {
		if(str2.charAt(0)==c &&str2.charAt(1)==c  &&str2.charAt(2)==c) 
		{
			return true;
		}
		if(str2.charAt(3)==c &&str2.charAt(4)==c  &&str2.charAt(5)==c) 
		{
			return true;
		}		if(str2.charAt(6)==c &&str2.charAt(7)==c  &&str2.charAt(8)==c) 
		{
			return true;
		}		if(str2.charAt(0)==c &&str2.charAt(3)==c  &&str2.charAt(6)==c) 
		{
			return true;
		}		if(str2.charAt(1)==c &&str2.charAt(4)==c  &&str2.charAt(7)==c) 
		{
			return true;
		}		if(str2.charAt(2)==c &&str2.charAt(6)==c  &&str2.charAt(8)==c) 
		{
			return true;
		}		if(str2.charAt(0)==c &&str2.charAt(4)==c  &&str2.charAt(8)==c) 
		{
			return true;
		}		if(str2.charAt(2)==c &&str2.charAt(4)==c  &&str2.charAt(6)==c) 
		{
			return true;
		}
		return false;
		
	}

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);  
		while(true) {
			String str= sc.next(); 
			TicTacToeBoard object = new TicTacToeBoard(str);  
			System.out.println(object.evaluate());
		}
	}
	}
