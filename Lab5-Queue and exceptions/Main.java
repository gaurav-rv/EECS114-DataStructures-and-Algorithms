
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayList<String> Dictionary = new ArrayList<String>();
		File k1 =new File("words5.dict");
		int i=0;
		try{
		 	Scanner s = new Scanner(k1);
			while(s.hasNext()){ 
				
				Dictionary.add(s.next());; 
		 		i++;
				}
			s.close();
			}
		catch(NullPointerException c){c.printStackTrace();}
		catch (FileNotFoundException e) {e.printStackTrace();}
		WordLadder word = new WordLadder(args[1],args[2],Dictionary);
		System.out.println(" \n Trial purpose Poping an empty queue \n");
		MyQueue<String> Newq = new MyQueue<String>();
		Newq.pop();
		System.out.println(" \n Trial purpose Poping an empty stack \n ");
		MyStack<String> ok = new MyStack<String>();
		ok.pop();
		System.out.println(" \n Trial purpose Pushing  a full stack \n ");
		for(i=0;i<4001;i++){
			ok.push("LOL");
		}
	}

}
