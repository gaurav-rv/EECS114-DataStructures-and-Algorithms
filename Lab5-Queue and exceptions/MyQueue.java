
public class MyQueue<T> {

	public SimpleList<T> List_Q;
	
	public MyQueue(){
		this.List_Q = new SimpleList<T>();
	}
	public void push(T value){
		int k = List_Q.size();
		List_Q.InsertAtpos(k, value);
		
	}
	
	public void pop(){
		try{
			if(List_Q.isEmpty() == 0){throw new QueueUnderflowException(" pop() on MyQueue of size == " + List_Q.size());}
		List_Q.removeAt(0);
		
		}
		catch( QueueUnderflowException q){q.printStackTrace();}
	}
	
	@SuppressWarnings("unchecked")
	public T front(){
		return (T) List_Q.getAt(0);
		}
	
	public int isEmpty(){
		int k = List_Q.size();
		return k;
	}
	public void print() {
		// TODO Auto-generated method stub
		
	}
}
