
import java.lang.reflect.Array;

public class Generic<T> {
	public static int CAPACITY = 1000;  
	private T[] S = (T[]) new Object[CAPACITY];
	private int t = -1; // top index in array
	
	public Generic () {
		//final T[] S = (T[]) Array.newInstance(c, CAPACITY);
		
		this.S = S;
		this.t = t;
		
	}
	public void push (T x) {
		if(t == CAPACITY -1){
			System.out.println("Size Overflow exception");
			return;
		}
		t = t+1;
		S[t] = x;
	}     
	public T top () {
		return S[t];
		}
	
	public T pop () {
		if(t>(-1)){
			T k = S[t];
			t = t-1;
			return k;
			}
		return null;
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
