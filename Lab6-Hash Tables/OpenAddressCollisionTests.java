import java.util.Random;

public class OpenAddressCollisionTests {
	static int linear[];
	static int quadratic[];
	static int cubic[];
	static int begin 			= 			59;
	static int end  		    =		   150;
	static int beg1  			=			 1;
	static int arra[];
	static int colide 			=			 0;
	static int sizefactor;
	static int linearcolide		=			 0;
	static int quadraticcolide  =			 0;
	static int cubiccolide 		=			 0;
	
	public static void main(String args[]){
		main1(0.25);
		main1(0.50);
		main1(0.75);
		main1(0.90);
	}
	public static void main1(double d){
		Random r = 	new Random();
		int size 			=   59;
		arra     			= 	new int[size];
		quadratic	 		= 	new int[size];
		cubic	 			=	new int[size];
		linear   			= 	new int[arra.length];
		double fillpercent  =   d; 
		sizefactor 			=   (int) (size*fillpercent);//Percentage of array filled
	
		
		for (int i=0;i<=sizefactor;i++){
			arra[i]= r.nextInt(begin-beg1)+beg1; // Inserting a number between 1 and 59 and storing in array
		}
		for(int i =0; i<=sizefactor;i++){
			linearprobing(arra,i);      	   //Calling linear probing on array and index
			quadraticprobing(arra,i);
			Cubicprobing(arra,i);
		}
		
		System.out.println("For A fill factor of : 	" +(fillpercent*100));
		System.out.println("Size = " +size+ " sizefactor is "+sizefactor);
		printopenarray(linear);
		System.out.println("Number of linear colisions:	"+linearcolide);
		printopenarray(quadratic);
		System.out.println("Number of quadratic collisions:  "+quadraticcolide);
		printopenarray(cubic);
		System.out.println("Number of cubic collisions : " + cubiccolide);
		
		
	}

	private static void printopenarray(int[] arra3) {
		for(int i =0; i<arra3.length;i++){
			System.out.println(i+":	"+arra3[i]);
		}
		
		
	}

	private static void Cubicprobing(int[] arra, int i) {
		int k1 = 0;
		int temp = (arra[i] + k1) % arra.length;
		int satisfied = 0;
		int rem1 =  0;
		int k1sqaure;
		while(satisfied == 0){
			if(cubic[temp] == 0){
				cubic[temp] = arra[i];
				satisfied = 1;
			}
			else{
				k1=k1+1;
				k1sqaure = k1*k1*k1; 
				if(k1sqaure > arra.length){
					rem1 = rem1 + k1sqaure - arra.length; 
				}	
				temp = ((arra[i] + k1sqaure + rem1) % arra.length);
				if(temp < 0){
				}
				cubiccolide++;
			}
		}
	}
	private static void quadraticprobing(int[] arra, int i) {
		int k1 = 0;
		int temp = (arra[i] + k1) % arra.length;
		int satisfied = 0;
		int rem1 =  0;
		
		int k1sqaure;
		while(satisfied == 0){
			if(quadratic[temp] == 0){
				quadratic[temp] = arra[i];
				satisfied = 1;
			}
			else{
				k1=k1+1;
				k1sqaure = k1*k1; 
				if(k1sqaure > arra.length){
					rem1 = rem1 + k1sqaure - arra.length; 
				}	
				temp = ((arra[i] + k1sqaure + rem1) % arra.length);
				if(temp < 0){
					}
				quadraticcolide++;
			}
		}
	}

	private static void linearprobing(int[] arra, int i) {
	
		
		int k1 = 0;
		int temp = (arra[i] + k1) % arra.length;
		int satisfied = 0;
		int rem1 =  0;
		int k1sqaure;
		while(satisfied == 0){
			if(linear[temp] == 0){
				linear[temp] = arra[i];
				satisfied = 1;
			}
			else{
				k1=k1+1;
				k1sqaure = k1; 
				if(k1sqaure > arra.length){
					rem1 = rem1 + k1sqaure - arra.length; 
				}	
				temp = ((arra[i] + k1sqaure + rem1) % arra.length);
				if(temp < 0){
					}
				linearcolide++;
			}
		}
	}	
}
	


