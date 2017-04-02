
public class MyStack<T> {
	
	final private int CAPACITY =4000;
	private int t;
	private T[] data;
	
	@SuppressWarnings("unchecked")
	public MyStack(){
		this.data = (T[]) new Object[CAPACITY];
		this.t = -1;
	}
	
	@SuppressWarnings("unchecked")
	public MyStack(MyStack<T> rhs){
		this.data = (T[]) new Object[CAPACITY];
		int i=0;
		t=-1;
		while(rhs.data[i]!=null){
			this.data[i]= rhs.data[i];
			this.t= t+1;
			i++;
		}
	}
	
	public boolean isEmpty(){
		if (t>(-1)) return false;
		return true;
	}
	
	public int size(){
		return t+1;
	}
	
	public void push(T value){
	try{
		if(t == CAPACITY -1){
			throw new StackOverflowException(" push() on MyStack with CAPACITY == "+CAPACITY +", size ==" +size());
		}
		t = t+1;
		data[t] = value;
		
		}
	catch(StackOverflowException s){s.printStackTrace();}
	}
	
	public void pop(){
	try{
		if(t>(-1)){
			@SuppressWarnings("unused")
			T k = data[t];
			t = t-1;
			return;
			}
		throw new StackUnderflowException(" pop() on MyStack with CAPACITY == "+CAPACITY +", size ==" +size());
	}
	catch(StackUnderflowException s){
		s.printStackTrace();
	}
	}
	
	public T top(){
		return this.data[t];
		
	}
	
	
}
