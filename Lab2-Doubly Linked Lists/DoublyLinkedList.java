/*
 * Course: EECS 114 Fall 2015
 *
 * First Name: Gaurav 	
 * Last Name: Venkatesh
 * Lab Section: 
 * email address: graghava@uci.edu
 * Assignment: lab2	
 * Filename : DoublyLinkedList
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
import java.util.Collection;

public class DoublyLinkedList<T> 
{
	public class Node<T>
		{ 
			private T data;
			public Node<T> previous;
			public Node<T> next;
				
			public Node(T data)
			{
				this.data=data;
				previous = null;
				next = null;
			}
			public Node(Node<T> previous,T data, Node<T> next)
			{
				this.previous = previous;
				this.next = next;
				this.data=data;
			}
			public T getData()
			{
				return data;
			}

		} 
	
	private int size;
	private Node<T> head;
	private Node<T> tail;
	
	public DoublyLinkedList()  
		{
		head = null;	
		tail = null;
		} 
	public DoublyLinkedList (Collection<? extends T> c)
		{
			head = null;
			tail=null;
		} 
	
	/*	
	public void Add(int index, T t)
	{
		int k=0;

		else if (index == 0) // Adding shit in front
			{
			Node<T> newnode = new Node<T>(null,t,head);
			newnode.previous = null;
			head = newnode;	
			size++;
			} 
		
		else if (index <= size) // Adding in the given index ?
			{
				Node<T> newnode = head;
				while (k < index && newnode.next!=null)
				{
					newnode=newnode.next;
					k++;
				}
				if(newnode.next == null) 
					{
					newnode = newnode.previous;
					Node<T> lolnode = new Node<T>(newnode,t,newnode.next);
					newnode.next=lolnode;
					size++;
					}
				else {
					newnode = newnode.previous;
					Node<T> lolnode = new Node<T>(newnode,t,newnode.next);
					newnode.next.previous = lolnode;
					newnode.next = lolnode;
					size++;
				}
				
			}
	}*/
	
	public void Add(int index, T t) {
		Node<T> newnode = head;
		int k = 0 ;
		if (head == null) // Adding if nothing there
		{
			head = new Node<T>(null,t,null);
			size++;
			return;
		}
		
		while(newnode.next != null && k < index) {
			newnode = newnode.next;
			k++;
		}
		if(size <= index){
			AddFront(newnode,t);
		}
		else {
			AddBefore(newnode,t);
		}
		size++;
	}
	public void AddBefore(Node<T> currentnode,T t){
		if(currentnode == head){
			currentnode.previous= new Node<T>(null,t,currentnode);
			head=currentnode.previous ;
		}
		else {
			currentnode.previous = new Node<T>(currentnode.previous,t,currentnode);
			currentnode.previous.previous.next = currentnode.previous;
		}
	}
		

	
	public void AddFront(Node<T> currentnode,T t){
		currentnode.next = new Node<T>(currentnode,t,currentnode.next);
		if (currentnode.next.next !=null) currentnode.next.next.previous = currentnode.next;
	}
	
	public int getSize(){
		int ola=0;
		Node<T> current = head;
		while(current != null){
			ola++;
			current = current.next;
		}
		return ola;
		
	}
	public void remove(int index) 
	{
		int k = 0;
		Node<T> currentnode = head;
		while( k < index){
			currentnode = currentnode.next;
			if (currentnode == null)
			{
				System.out.println("Out of bound ");
				return;
			}
			k++;
		}
		if(currentnode == head){
			head=currentnode.next;
			currentnode.next.previous=null;
			
		}
		else if (currentnode.next == null){
			currentnode.previous.next = null;
		}
		else	{
			//System.out.println("Going in ");
			currentnode.previous.next=currentnode.next;
			currentnode.next.previous=currentnode.previous;
		}
	} 
	
	public T get(int index)
	{
		int rotate=0;
		Node<T> currentnode = head;
		if (currentnode == null)
		{
			System.out.println("Out of bound");
			return null;
		}
		while(rotate < index ){
			currentnode = currentnode.next;
			if (currentnode == null)
			{
				System.out.println("Out of bound ");
				return null;
			}
			rotate++;
		}
		return currentnode.data;
	}
	
	public void remove(Object o){
		Node<T> currentnode = head;
		if (currentnode == null)
		{
			System.out.println("Out of bound");
			return;
		}
		//System.out.println(o);
		while (!currentnode.data.equals(o) && currentnode.next != null)
		{
			currentnode= currentnode.next;
		}
		//System.out.println(currentnode.data);
		if(currentnode == head){
			currentnode.next.previous = null;
			head =currentnode.next; 
		}
		else if (currentnode.next == null){
			currentnode.previous.next=null;
		}
		else {
			currentnode.previous.next = currentnode.next;
			currentnode.next.previous = currentnode.previous;
			}
		}
	/*
	public void remove(Object o) {} 
		/** 
		  *  Returns the element at the specified position.
		  *   
		  * @param index the position in which to look for.
		  * @return the element at the given position in th
		e list. If the index is out of range (index < 0 || 
		index >=size()) 
		   
	public T get(int index) {} 
	public int size() {} 
	pu blic boolean isEmpty() {}
	*/
	public void Printlist() {
		Node<T> current = head;
		while(current != null){
			System.out.println(current.getData());
			current = current.next;
			}
		}
	
	public boolean isEmpty(){
		int s=0;
		Node<T> current = head;
		while(current != null){
			current = current.next;
			s++;
	}
		if (s == 0){
			System.out.println("True");
			return true;
		}
		else{ 
			System.out.println("False");
			return false;
		}	
		}
		
} 

