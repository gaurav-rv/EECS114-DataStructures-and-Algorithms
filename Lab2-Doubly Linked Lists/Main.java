import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Course: EECS 114 Fall 2015
 *
 * First Name: Gaurav 	
 * Last Name: Venkatesh
 * Lab Section: 
 * email address: graghava@uci.edu
 * Assignment: lab2
 * Filename : Main 
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public  class Main{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{ 
//TODO: Input a file name from args[0] (it can be h
//ave a directory appended to it) and open file to 
//store in Scanner object. 
	DoublyLinkedList <Integer> numLinkedList = new DoublyLinkedList<Integer>(); 
	
	File k =new File("words5.dict");
    Scanner s;
	try {
		s = new Scanner(k);
	    //System.out.println(s.nextInt());
	    //System.out.println(s.nextInt());
	    System.out.println(s.next());
	    System.out.println(s.next());
	    System.out.println(s.next());
	    System.out.println(s.next());
	    
	    s.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	numLinkedList.isEmpty();
	numLinkedList.Add(0, 0);
	numLinkedList.Add(1, 1);
	numLinkedList.Add(1, 2);
	numLinkedList.Add(2, 3);
	numLinkedList.Add(1, 4);
	numLinkedList.isEmpty();
	numLinkedList.Printlist();
	System.out.println("----After removing the first index----");
	numLinkedList.remove(1); 
	//numLinkedList.remove(5); 
	numLinkedList.Printlist();
	numLinkedList.remove(new Integer(0)); // to prevent
	System.out.println("After removing 0 from list");
	numLinkedList.Printlist();
	System.out.println("The second element of the list");
	System.out.println(numLinkedList.get(1));
	System.out.println("The size of the list currently is "+numLinkedList.getSize());

	
	} 
}
