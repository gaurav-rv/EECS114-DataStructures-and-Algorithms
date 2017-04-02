/*
 * Course: EECS 114 Fall 2015
 *
 * First Name: Gaurav 	
 * Last Name: Venkatesh
 * Lab Section: 
 * email address: graghava@uci.edu
 * Assignment: lab3
 * Filename : Main 
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	     
		public static void main (String[] args) throws FileNotFoundException {
			IntStack newstack = new IntStack();
			newstack.push(2);
			newstack.push(3);
			newstack.Print();
			System.out.println("----");
			newstack.pop();
			newstack.Print();
			System.out.println(newstack.isEmpty());
			newstack.pop();
			System.out.println(newstack.isEmpty());
			newstack.pop();
			
			Generic<String> newgeneric = new Generic<String>();
			newgeneric.push("LOL");
			newgeneric.push("OK");
			newgeneric.Print();
			RPNEval();
			
		}     
		@SuppressWarnings("unchecked")
		public static void RPNEval () throws FileNotFoundException {
			//final int  MAX = 100;
		
			Generic<String> Postfix = new Generic<String>();
			
			try{
				File k1 =new File("input.txt");
			 @SuppressWarnings("resource")
			Scanner s = new Scanner(k1).useDelimiter(" ");
			 while(s.hasNext()){ 
				  Postfix.push( s.next()); 
			 	}
			 Postfix.Print();
			 }
			 catch(NullPointerException c){}
					
			Generic<String> reversedStack = new Generic<String>();
			while(!Postfix.isEmpty()){
				reversedStack.push(Postfix.pop());
			}
			System.out.println("---------------------------");
			reversedStack.Print();
			System.out.println("---------------------------");
			int number=0,a=0,b=0,result=0;
			@SuppressWarnings("rawtypes")
			Generic workingstack = new Generic<String>();
			while(!reversedStack.isEmpty()){
				String ok = reversedStack.pop();
				if(!ok.equals("+") && !ok.equals("-") && !ok.equals("*") && !ok.equals("/"))
				{
					 number = Integer.parseInt(ok);
					 workingstack.push(number);
				}
				else{
					b = Integer.valueOf(workingstack.pop().toString());
					//System.out.println(b);
					a = Integer.valueOf(workingstack.pop().toString());
					if(ok.equals("+")){ result = a+b; workingstack.push(result);}
					else if(ok.equals("*")){ result = a*b; workingstack.push(result);}
					else if(ok.equals("-")){ result = a-b; workingstack.push(result);}
					else if(ok.equals("/")){ result = a/b; workingstack.push(result);}
					//System.out.println(result);
				}
			}
				System.out.println(workingstack.pop());
			
		}
		
}
