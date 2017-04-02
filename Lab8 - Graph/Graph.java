import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

@SuppressWarnings("unused")
public class Graph {
	private class Vertex{
		private ArrayList<Vertex> neighbours;
		private int Distance;
		private String Label;
		
		private Vertex(String Name){
			this.neighbours= new ArrayList<Vertex>();
			this.Distance =0;
			this.Label = Name;
		}
		public void setNeighbour(Vertex destination){
			this.neighbours.add(destination);
		}
		public String getLabel(){
			
			return this.Label;
			
		}
	}
	Vertex[] GraphArray;
	Vertex[] GraphNeighbours;
	
	public Graph(String file) {
		this.GraphArray=null;
		build_graph(file);
	}

	
	public void build_graph(String file) {
		int  N = 0;
		int  M = 0;
		File k =new File(file);
	    Scanner s;
	    try {
			s = new Scanner(k);	
			N = Integer.parseInt(s.next());
			M = Integer.parseInt(s.next());
			System.out.println(N);
		    System.out.println(M);
		    GraphArray = new Vertex[N];
		    GraphNeighbours = new Vertex[M];
		    for(int i = 0; i < N; i++){
		    	Vertex Inter = new Vertex(s.next());
		    	GraphArray[i]= Inter;
		    	System.out.print( GraphArray[i].getLabel()+" ");
		    	
		    }
		    System.out.println(" \nNeighbours array");
		    for(int i = 0; i < M; i++){
		    	String First = s.next();
		    	String Last  = s.next();
		    	
		    	Vertex source = find(First);
		    	Vertex destination = find(Last);
		    	//System.out.println(" Source " + source.getLabel()+" Destination "+destination.getLabel());
		    	source.setNeighbour(destination);
		    }
			s.close();
		}
	    catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		set_levels(GraphArray[2]);
	}

	private Graph.Vertex find(String first) {
		for(int i = 0; i < GraphArray.length; i++ ){
    		if(first.equals(GraphArray[i].Label)){
    			Vertex source = GraphArray[i];
    			return source;
    		}
		}
		return null;
	}
	
	
	public void display(){
		for(int i = 0; i < GraphArray.length; i++ ){
			Vertex intermediate = GraphArray[i];
			System.out.print(intermediate.getLabel()+"-->");
			for(int j = 0; j <GraphArray[i].neighbours.size();j++ ){
				Vertex hmm = GraphArray[i].neighbours.get(j);
				System.out.print(hmm.getLabel()+",");
			}System.out.println();
		}
		
	}
	
	public void set_levels(Vertex source){
		for(int i = 0; i < GraphArray.length; i++){
				GraphArray[i].Distance=Integer.MAX_VALUE;//infinity -bignumber
			}
		Queue<Vertex> queue = new LinkedList<Vertex>();
		source.Distance = 0;
		queue.add(source);
		while( !queue.isEmpty() ){
			Vertex inter = queue.remove();
			for(int j = 0; j < inter.neighbours.size(); j++){
				Vertex neighbour = inter.neighbours.get(j);
				if(neighbour.Distance==Integer.MAX_VALUE){
					neighbour.Distance = inter.Distance+1;
					queue.add(neighbour);
				}
			}
		}
	    
	}
	
	public void display_levels(){
		for(int i = 0; i < GraphArray.length; i++ ){
			Vertex intermediate = GraphArray[i];
			if(intermediate.Distance == Integer.MAX_VALUE) 
				System.out.print(intermediate.getLabel()+" DIstance from Source: Infinity");
			else System.out.print(intermediate.getLabel()+" DIstance from Source:"+ intermediate.Distance);
			System.out.println();
		}		
	}

	public boolean is_connected(Vertex source){
		set_levels(source);
		for(int i = 0; i<GraphArray.length;i++){
			if(GraphArray[i].Distance==Integer.MAX_VALUE) return false;
		}
		return true;
	}


	public void set_levels(String string) {
		for(int i = 0;i < GraphArray.length;i++){
			if(string.equals(GraphArray[i].getLabel())){
				set_levels(GraphArray[i]);
			}
		}
	}

	public boolean is_connected(String string) {
		set_levels(string);
		for(int i = 0;i < GraphArray.length;i++){
			if(string.equals(GraphArray[i].getLabel())){
				return is_connected(GraphArray[i]);
			}
		}
	return false;
	}
}
