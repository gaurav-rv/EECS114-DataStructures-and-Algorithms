/*
 * Course: EECS 114 Fall 2015
 *
 * First Name: Gaurav 	
 * Last Name: Venkatesh
 * Lab Section: 
 * email address: graghava@uci.edu
 * Assignment: Assignment
 * Filename : Main 
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
public class Main {
	public static void main(String[] args) 
	{ 
		
		MyList rhs = null;
		MyList charLinkedList = new MyList(); 
		//charLinkedList.previous();
		System.out.println("Populating the list");
		charLinkedList.insertAtPos(0, 'a');
		charLinkedList.insertAtPos(0, 'b');
		charLinkedList.insertAfter(0, 'n');
		charLinkedList.insertAtPos(0, 'a');
		charLinkedList.insertAtPos(1, 'q');
		charLinkedList.insertBefore(7, 'b');
		charLinkedList.insertBefore(9, 'z');
		//charLinkedList.insertBefore(2, 'a');
		//charLinkedList.insertBefore(1, 'a');
		charLinkedList.print();
		System.out.println("Removing b");
		//charLinkedList.remove('l');
		charLinkedList.removeAll('b');
		charLinkedList.remove('a');
		charLinkedList.print();
		System.out.println("swapping");
		charLinkedList.swap(3, 3);
		charLinkedList.print();
		charLinkedList.contains('z');
		System.out.println(charLinkedList.get(5));
		charLinkedList.set(6, '1');
		charLinkedList.print();
		System.out.println(" push front ----------- push back");
		charLinkedList.pushFront('m');
		charLinkedList.pushBack('o');
		charLinkedList.print();
		System.out.println("Find b:");
		System.out.println(charLinkedList.find('b'));
		System.out.println("Find m:");
		System.out.println(charLinkedList.find('m'));
		System.out.println("Number of elements");
		System.out.println(charLinkedList.size());
		System.out.println("Array form");
		System.out.println(charLinkedList.toArray());
		System.out.println("Reversing the list");
		charLinkedList.reverse();
		charLinkedList.print();
		System.out.println("SubListing");
		charLinkedList.subList(0, 3).print();
		MyList newlist = new MyList(charLinkedList);
		System.out.println("Testing Equals method");
		System.out.println(charLinkedList.equals(newlist));
		System.out.println("Testing TO string");
		System.out.println(charLinkedList.toString());

/*		//System.out.println("After removing all a ");
		//charLinkedList.removeAll('a');
		//charLinkedList.print();
		System.out.println("After popping first element ");
		charLinkedList.popFront();
		charLinkedList.print();
		System.out.println("After popping last element ");
		charLinkedList.popBack();
		charLinkedList.print();*/
	}

}
