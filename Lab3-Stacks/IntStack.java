/*
 * Course: EECS 114 Fall 2015
 * First Name: Gaurav 	
 * Last Name: Venkatesh
 * Lab Section: 
 * email address: graghava@uci.edu
 * Assignment: lab3
 * Filename : IntStack
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
public class IntStack {
	public static int CAPACITY = 1000;  
	private int[] S = new int[CAPACITY];
	private int t = -1; // top index in array
	
	public Integer Stack () {
		this.S = S;
		this.t = t;
		return t;
		
	}
	public void push (int x) {
		if(t == CAPACITY -1){
			System.out.println("Size Overflow exception");
			return;
		}
		t = t+1;
		S[t] = x;
	}     
	public int top () {
		return S[t];}
	public void pop () {
		if(t>(-1)){
		t = t-1;
		}
	}
	public boolean isEmpty () {
		if (t>(-1)) return false;
		return true;}
	public void Print(){
		int i=0;
		while(i<=t){
			System.out.println(S[i]);
			i++;
		}
	}
}

