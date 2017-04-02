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
 * Assignment: lab8
 * Filename : Main 
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
	    //Graph.build_graph(args[0]);
	    Graph graph = new Graph(args[0]);
	    graph.set_levels("Nile");
	    graph.display();
	    System.out.println("\n Printing Levels \n");
	    graph.display_levels();
	    System.out.println(" \n Checking  node Friedland \n");
	    graph.set_levels("Friedland");
	    graph.display_levels();
	    System.out.println();
	    
	    System.out.println("Lodi is connected? : "+graph.is_connected("Lodi"));
	    System.out.println("Nile is connected? : "+graph.is_connected("Nile"));
	}

}
