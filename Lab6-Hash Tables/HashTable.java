import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class HashTable {
	static int size =10;
	@SuppressWarnings("unchecked")
	static LinkedList<String>[] HashTable = new LinkedList[size];
	@SuppressWarnings("unchecked")
	static LinkedList<String>[] HashTable1 = new LinkedList[size];
	@SuppressWarnings("unchecked")
	static LinkedList<String>[] HashTable2 = new LinkedList[size];
	@SuppressWarnings("unchecked")
	static LinkedList<String>[] HashTable3 = new LinkedList[size];
	static int hcol1=0;
	static int hcol2=0;
	static int hcol3=0;
	static int hcol4=0;
	public static void processFile(String filename) {
		int i=0;
		try{
			while(i<size){
				HashTable[i]= new LinkedList<String>();
				HashTable1[i]= new LinkedList<String>();
				HashTable2[i]= new LinkedList<String>();
				HashTable3[i]= new LinkedList<String>();
				i++;
			}
			File k1 =new File(filename);
			@SuppressWarnings("resource")
			Scanner s = new Scanner(k1);
			 while(s.hasNext()){
				 String word = s.next();
				 HashFunction(word);
				 HashFunction1(word);
				 HashFunction2(word);
				 HashFunction3(word);
			 }
		}
		catch(FileNotFoundException f){f.printStackTrace();}
		System.out.println("Printing the first hash function with size = 10 (sum of ascii values) ");
		print(HashTable);
		printstat(hcol1,1);
		System.out.println();
		System.out.println("Printing the second hash function with size = 10 (sum of a first 3 letters) ");
		print(HashTable1);
		printstat(hcol2,2);
		System.out.println();
		System.out.println("Printing the Third hash function with size = 10 (sum of keys) ");
		print(HashTable2);
		printstat(hcol3,3);
		System.out.println("Printing out my own Function");
		print(HashTable3);
		printstat(hcol4,4);
	}

	private static void HashFunction3(String word) {
		int sum1;
		char char1= word.charAt(0);
		char char2= word.charAt(2);
		char char3= word.charAt(1);
		int asci1 = (int) char1;
		int asci2 = (int) char2;
		int asci3 = (int) char3;
		
		sum1 = (asci1 + 4*(asci2) + 24*(asci3)) % size;
		if(!HashTable3[sum1].isEmpty()) hcol4++;
		HashTable3[sum1].add(word);
		
	}

	public static void HashFunction(String word) {
		int sum =0;
		for(int i=0;i<word.length();i++){
			char charecter = word.charAt(i);
			int ascivalue = (int) charecter;
			sum= sum +ascivalue;
		}
			int value = sum % size;
			if(!HashTable[value].isEmpty()) hcol1++;
			HashTable[value].add(word);
			
	}

	public static void HashFunction2(String word) {
		int sum2 =0;
		for (int i=0;i<word.length()-1;i++){
			sum2 = (int) (sum2 + (word.charAt(i)*(word.length()-1-i)) * Math.pow(37, i));
		}
		int value = sum2 % 10;
		if(!HashTable2[value].isEmpty()) hcol3++;
		HashTable2[value].add(word);
		
	}

	public static void HashFunction1(String word) {
		int sum1;
		char char1= word.charAt(0);
		char char2= word.charAt(1);
		char char3= word.charAt(2);
		int asci1 = (int) char1;
		int asci2 = (int) char2;
		int asci3 = (int) char3;
		
		sum1 = (asci1 + 27*(asci2) + 729*(asci3)) % size;
		if(!HashTable1[sum1].isEmpty()) hcol2++;
		HashTable1[sum1].add(word);
	}
	
	public static void print(LinkedList<String>[] hashing){
		for(int i =0; i< hashing.length ;i++){
			System.out.print(i+" :	 ");
			for(int j =0; j<hashing[i].size();j++){
				System.out.print(hashing[i].get(j)+", ");
			}
			System.out.println();
		}
	}
	public static void printstat(int hcol, int i){
		
		double avg = 0;
		int temp = 0;
		int large = 0;
		int div=0;
		if(i == 1){
			int[] sum = new int[HashTable.length];
			int value=0;
			large = HashTable[0].size();
			sum[0] = HashTable[0].size();
			for(int j = 1; j < HashTable.length; j++){
				temp = HashTable[j].size();
				if(temp>large) large = temp;
				sum[j] = HashTable[j].size();
			}
			for(int k =0; k < sum.length;k++ ){
				value = value + sum[k]; 
				if(sum[k]>0)div++;
			}			

			avg = (double)value / div;
			System.out.println("number of collisions: "+hcol1);
			System.out.println("Average: "+avg);
			System.out.println("The longest list: "+large);
		}
		if(i==2){
			int[] sum = new int[HashTable1.length];
			int value=0;
			//int div=0;
			double ok = 0;
			large = HashTable1[0].size();
			sum[0] = HashTable1[0].size();
			for(int j = 1; j < HashTable1.length; j++){
				temp = HashTable1[j].size();
				if(temp>large) large = temp;
				sum[j] = HashTable1[j].size();
			}
			for(int k =0; k < sum.length;k++ ){
				value = value + sum[k];
				
				if(sum[k]>0)div++;
				
			}			
			
			ok = (double)value / div;
			System.out.println("number of collisions: "+hcol2);
			System.out.println("Average: "+ ok);
			System.out.println("The longest list: "+large);	
		}
		if(i==3){
			int[] sum = new int[HashTable2.length];
			int value=0;
			//int div=0;
			large = HashTable2[0].size();
			sum[0] = HashTable2[0].size();
			for(int j = 1; j < HashTable2.length; j++){
				temp = HashTable2[j].size();
				if(temp>large) large = temp;
				sum[j] = HashTable2[j].size();
			}
			for(int k =0; k < sum.length;k++ ){
				value = value + sum[k]; 
				if(sum[k]>0)div++;
			}			
			avg = (double) value / div;
			System.out.println("number of collisions: "+hcol3);
			System.out.println("Average: "+avg);
			System.out.println("The longest list: "+large);
		}
		if(i==4){
			int[] sum = new int[HashTable3.length];
			int value=0;
			//int div=0;
			large = HashTable3[0].size();
			sum[0] = HashTable3[0].size();
			for(int j = 1; j < HashTable3.length; j++){
				temp = HashTable3[j].size();
				if(temp>large) large = temp;
				sum[j] = HashTable3[j].size();
			}
			for(int k =0; k < sum.length;k++ ){
				value = value + sum[k]; 
				if(sum[k]>0)div++;
			}			
			avg = (double) value / div;
			System.out.println("number of collisions: "+hcol3);
			System.out.println("Average: "+avg);
			System.out.println("The longest list: "+large);
		}
	}
}
