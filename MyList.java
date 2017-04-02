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
import java.awt.List;
import java.util.Arrays;

public class MyList {
	// Node class
	private class Node {
		private char value;
		private Node next;
	
		public Node() { this.value=(Character) null;this.next=null; }
	
		public Node(char value, Node next)
		{
			this.value=value;
			this.next= next;
		}
	
	// Accessor methods
		public char getElement() { return value; }
		public Node getNext() { return next; }
	// Modifier methods
		public void setElement(char v) { value = v; }
		public void setNext(Node n) { next = n; }
	}
	
	
	// MyList class
	private Node head;
	//private int size;
	// Implement required methods here
	public MyList(){
		head = null;
	}
	public MyList(MyList rhs){
		if(rhs.head == null) {return;}
		this.head = new Node(rhs.head.getElement(),null);
		Node current = this.head;
		Node rhsc = rhs.head;
		//Node next = new Node();
		
		while(rhsc!= null){
			if(rhsc.getNext() == null){
				return;
			}
			 current.setNext(new Node(rhsc.getNext().getElement(),null));
			 current = current.getNext();
			 rhsc= rhsc.getNext();
			}
		}

	/*Removes the element at the specified position in
	thislist.Returns true if this list contained the specified element. COMPLETE 
	*/ 
	boolean remove(int index) {
			Node newnode = head;
			int k = 0;
			if(newnode == null){
				System.out.println("Empty list");
				return false;
			}
			else if (index == 0){
				head = newnode.getNext();
				return true;
			}
			while (k < (index-1) ){
				newnode = newnode.next;
				if(newnode.next == null){
					System.out.println("Index out of bound");
					return false;
				}
				k++;
			}
		newnode.setNext(newnode.getNext().getNext()); 
		return true;
		}
	
	
	/* Removes the first occurrence of the specified element from
	thislist if it is present. Returns true if this list contained the specified element.*/
	boolean remove(char value){
			Node currentnode = head;
			if (currentnode.getElement() == value)
			{
				 head= currentnode.getNext();
			}
			else {
			while(currentnode.getNext().getElement()!= value)
			{
				currentnode=currentnode.getNext();
				if(currentnode.getNext() == null)
				{
					System.out.println("The element Does not Exsists");
					return false;
				}
			}
			}
				currentnode.setNext( currentnode.getNext().getNext());
		return true;
		}

	/*
	- Removes all occurrences of the specified element from this list,if it is present. Returns
	true if this list contained the specified element.
*/
	boolean removeAll(char value){
		int trigger =0;
		Node currentnode = head;
		
		if(currentnode == null){
			return false;
		}
		
		while (currentnode != null){
			if(currentnode.getNext() == null){
				if(trigger !=0)return true;
				return false;
			}
			if(this.head.getElement() == value){
				head = currentnode.getNext();
				trigger++;
			}
			else if(currentnode.getNext().getElement() == value){
				currentnode.setNext(currentnode.getNext().getNext());
				trigger++;
			} 
			currentnode = currentnode.getNext();
			
		}
		if(trigger != 0){
			return true;
		}
		/*while(currentnode!=null){
			if (currentnode.getElement() == value)
			{
				 head= currentnode.getNext();
				 trigger++;
			}
			if (currentnode.getNext().getNext() == null && currentnode.getNext().getElement()== value){
				currentnode.setNext(null);
				return true;
			}
			while(currentnode.getNext().getElement()!= value)
			{
				currentnode=currentnode.getNext();
				if(currentnode.getNext() == null){
					if(trigger != 0){
						return true;
					}
				System.out.println("The element Does not Exsists");
				return false;
				}
			}
			currentnode.setNext(currentnode.getNext().getNext());
			trigger++;
		}
		return true;*/
		return false;
	}
	
	/*- Returns the previous node for the specified node
	curr*/
	Node previous(Node curr) 
	{
		
		Node currentNode = head;
		if(currentNode == curr){
			return null;
		}
		while(currentNode.next != curr)
		{
			currentNode = currentNode.next;
			if(currentNode.next == null)
			{
				System.out.println("Does not contain curr");
			}
		}
		return currentNode;
	}
	
	/*- Returns the next node for the specified node
	curr
	.*/
	Node next(Node curr){
		if(curr != null){
		return curr.getNext();
		}
		return null;
		/*		Node currentNode = head;
		while(currentNode != curr)
		{
			currentNode= currentNode.next;
			if(currentNode.getNext()== null){
				System.out.println("DOES NOT EXSIST");
				return null;
			}
		}
		return currentNode.getNext();*/
		}
	
	/*- Returns true if this list contains the specified value
	.*/
	boolean contains(char value){
		Node currentnode = head;
		if(head == null){
			System.out.println("Empty List");
		return false;
		}
		while(currentnode.getElement()!=value){
			currentnode = currentnode.getNext();
			if(currentnode == null){
				return false; 
			}
		}
		System.out.println("Exsists");
		return true;
		}
	
	/*- Returns the element at the specified position in this list. Index of first element in
	list is0 .*/
	public char get(int index){
		Node CurrentNode = head; 
		int k =0;
		if(index == 0){
			return CurrentNode.getElement();
		}
		while (k<index)
		{
			CurrentNode = CurrentNode.getNext();
			if (CurrentNode == null){
				System.out.println("Out of Bound");
				return 0;
			}
			k++;
		}
		return CurrentNode.getElement();
		}
	
	/*- Replaces the element at the specified position in this list with
	the specified element.*/
	void set(int index, char value)
	{
		Node CurrentNode = head; 
		int k =0;
		while (k<index)
		{
			CurrentNode = CurrentNode.getNext();
			if (CurrentNode == null){
				System.out.println("Out of Bound");
				return;
			}
			k++;
		}
		CurrentNode.setElement(value);
		}

	
	/*	- Compares the specified MyList with this list for equality. 
	Equal lists have exactly identical items in same order in list.*/
	boolean equals(MyList llist){
		Node current = this.head;
		Node rotate = llist.head;
		if (llist.size() != this.size()){
			System.out.println("Not same size");
			return false;
		}
		if(current == null|| rotate == null ){
			System.out.println("Empty List");
			return false;
		}
		while(current!= null){

			if(current.getElement() != rotate.getElement()){
				System.out.println("Does not match");
				return false;
			}
			current = current.getNext();
			rotate = rotate.getNext();
		}
		return true;
		}
	
	/*	- Inserts a node with specified value at the front of the list.*/
	void pushFront(char value){
		Node HeadNode = head;
		if (head == null)
		{
			Node CurrentNode = new Node(value,null);
		}
		else{
		Node CurrentNode = new Node(value,head);
		head = CurrentNode;
		}
	}
	
	/*	- Inserts a node with specified value
	at the back of the list.*/
	void pushBack(char value){
		Node CurrentNode = head;
		if (CurrentNode == null)
		{
			Node newNode = new Node(value,null);
			head=newNode;
		}
		while (CurrentNode.getNext() != null)
		{
			CurrentNode= CurrentNode.getNext();
		}
		Node newnode = new Node(value,null);
		CurrentNode.setNext(newnode);
	}

	/*	- Removes the front item from the list.*/
	void popFront(){
		Node CurrentNode = head;
		if (CurrentNode == null){
			System.out.println("Empty List");
			return;
		}
		//CurrentNode.setNext(CurrentNode);
		head = CurrentNode.getNext();
	}

	/*- Removes the last item from the list.*/
	void popBack(){
		Node CurrentNode = head;
		if (CurrentNode == null){
			System.out.println("Empty List");
			return;
		}
		else if (CurrentNode.getNext() == null)
		{
			head = null;
			return;
		}
		while(CurrentNode.getNext().getNext() != null)
		{
			CurrentNode = CurrentNode.getNext();
		}
		CurrentNode.setNext(null);
	}
	
	/*	- Swaps the value of the node at position i in the list with value of the
	node at positionj. Be sure you handle out-of-range calls*/
	
	void swap(int i, int j){
		int k=0,l=0;
		Node first = head;
		if (first == null )
		{
			System.out.println("Empty List");
		}
		while(k<i){
			first= first.getNext();
			if( first == null ){
				System.out.println("Index out of bound 1");
				return;
				}
			k++;
			}
		char store1 =first.getElement();
		
		Node secondNode = head;
		while(l<j){
			secondNode= secondNode.getNext();
			if(secondNode == null){
				System.out.println("Index out of bound 2");
				return;
				}
			l++;
			}
		char store2=secondNode.getElement();
		first.setElement(store2);
		secondNode.setElement(store1);
		}
		
	
	/*	- Inserts a node with specified value at position i in the
	list, shifting elements starting at i to the right, if needed.*/
	void insertAtPos(int i, char value){
		Node currentnode = head;
		int k=0;
		if(head == null){
			head = new Node(value,null);
			return;
		}
		else if (i==0){
			head = new Node(value,head);
			return;
		}
		while (k< (i-1)){
			if (currentnode.getNext() == null){
				//System.out.println("Index out of Bound");
				currentnode.setNext( new Node(value,null));
				return;
			}
			currentnode= currentnode.getNext();
			k++;
		}
		currentnode.setNext( new Node(value,currentnode.getNext()));
	}
	
	/*	- Inserts a node with specified value at position i+1 in the list.*/
	void insertAfter(int i, char value){
		Node currentnode = head;
		int k=0;
		if(head == null){
			head = new Node(value,null);
			return;
		}
		/*
		else if (i==0){
			head = new Node(value,head);
			return;}*/
		
		while (k< i){
			if (currentnode.getNext() == null){
				//System.out.println("Index out of Bound");
				currentnode.setNext( new Node(value,null));
				return;
			}
			currentnode= currentnode.getNext();
			k++;
		}
		currentnode.setNext( new Node(value,currentnode.getNext()));	
	}

	/*- Inserts a node with specified
	value at position i-1
	in the list.*/
	void insertBefore(int i, char value){
		Node currentnode = head;
		int k=0;
		if(head == null){
			head = new Node(value,null);
			return;
		}
		else if (i==0 || i==1){
			head = new Node(value,head);
			return;
		}
		while (k< (i-2)){
			if (currentnode.getNext() == null){
				//System.out.println("Index out of Bound");
				currentnode.setNext( new Node(value,null));
				return;
			}
			currentnode= currentnode.getNext();

			k++;
		}
		currentnode.setNext( new Node(value,currentnode.getNext()));
	}
	
	/*	- Returns a list object that is a portion of
	this list between the specified fromIndex, inclusive, and toIndex, exclusive.*/
	MyList subList(int fromIndex, int toIndex){
		//Node currentnode = head;
		int difference = toIndex-fromIndex;
		char[] full = toArray();
		char[] temp = new char[difference];
		//int j=0;
		
		MyList sublist = new MyList();
		sublist.head = new Node(full[fromIndex],null);
		Node first = sublist.head;
		Node temp1 = null;
		for(int i=(fromIndex+1);i<=toIndex;i++){
				temp1 = new Node(full[i],null);
				first.setNext(temp1);
				first = first.getNext();
			}
		return sublist;
		}

	
/*	-  Returns  the  position  of  the  first  occurrence  of value
	in this list.   If  the character is not in the list, the method returns -1.*/
	int find(char value){
		int k=0;
		Node currentnode = head;
		if (currentnode == null ){
			System.out.println("Empty List");
			return -1;
		}
		while (currentnode != null){
			if(currentnode.getElement() == value){
				return k;
			}
			currentnode = currentnode.getNext();
			k++;
		}
		return -1;}

	/*	- Returns the position of the first occurrence of
	queryStr in this
	list. If qu eryStr is not in the list, the method returns -1
*/
	int find(MyList queryStr){
		Node currentnode = head;
		while (currentnode != null){
			
		}
		return 0;
		}
	
	/*- Returns an array containing all of the items in this list in proper sequence
	 *  (from first to last element).*/
	char[] toArray(){
		Node currentnode = head;
		int i=0;
		char[] a = new char[this.size()]; 
		if(currentnode == null){
			System.out.println("Empty List");
		}
		while(currentnode != null){
			a[i] = currentnode.getElement();
			currentnode = currentnode.getNext();
			i++;
		}
		return a;
		}
	
	/*- Reverses the items in the list.*/
	void reverse(){
		Node currentnode = head;
		Node previous = null;
		while(currentnode !=null){
			Node next = currentnode.getNext();
			currentnode.setNext(previous);
			previous = currentnode;
			currentnode=next;
		}
		head = previous;
	}
	
	/* Returns the number of items in the list.*/
	int size(){
		int k=0;
		Node currentnode = head;
		if(currentnode == null){
			System.out.println("Empty List");
			return 0;
		}
		while(currentnode != null){
			k++;
			currentnode = currentnode.getNext();
		}
		return k;
		}
	
	
	/*- Prints the contents of the list.  Allows for printing a MyList
	instance llist to standard output in following way,*/
	//llist.print();

	void print()
	{
		Node currentnode = head;
		while(currentnode!= null){
			System.out.println(currentnode.getElement());
			currentnode=currentnode.getNext();
		}
	}

	 /*- Overrides the toString() method. Returns the formatted contents of
	this as a String. Allows for printing a MyList instance llist
	to standard output in following way, System.out.println("llist contents = " + llist);*/
	public String toString(){
		if(this.head == null)
		return null;
		return new String(this.toArray());
	}
}
