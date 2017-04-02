
public class SimpleList<T> {

@SuppressWarnings({ "unchecked", "rawtypes" })
SimpleList(SimpleList rhs){
	if(rhs.head == null) {return;}
	this.head = new Node(rhs.head.getElement(),null);
	Node current = this.head;
	Node rhsc = rhs.head;
	//Node next = new Node();
	
	while(rhsc!= null){
		if(rhsc.getNext() == null){
			return;
		}
		 current.setNext(new Node(rhsc.getNext().getElement(),null));
		 current = current.getNext();
		 rhsc= rhsc.getNext();
		}
}

public SimpleList() {
	//this.head= this.head;
	size =0;
	// TODO Auto-generated constructor stub
}

@SuppressWarnings("hiding")
public class Node<T>{ 
	private T value;
	@SuppressWarnings("rawtypes")
	private Node next;

	public Node() { this.value=(T) null;this.next=null; }

	@SuppressWarnings("rawtypes")
	public Node(T value2, Node next)
	{
		this.value=value2;
		this.next= next;
	}

// Accessor methods
	public T getElement() { return value; }
	@SuppressWarnings("rawtypes")
	public Node getNext() { return next; }
	
// Modifier methods
	public void setElement(T v) { value = v; }
	public void setNext(@SuppressWarnings("rawtypes") Node n) { next = n; }
	}



	@SuppressWarnings("unused")
	private int size;
	private Node<T> head;

	@SuppressWarnings("rawtypes")
	Node next(Node curr){
		if(curr != null){
			return curr.getNext();
			}
			return null;
	 
	}
	
	Object getAt(int index){
		@SuppressWarnings("rawtypes")
		Node CurrentNode = head; 
		int k = 0;
		if(index<0){
			System.out.println("Impossible");
		}
		if(index == 0){
			return CurrentNode.getElement();
		}
		while (k<index)
		{
			CurrentNode = CurrentNode.getNext();
			if (CurrentNode == null){
				System.out.println("Out of Bound");
				return 0;
			}
			k++;
		}
		return CurrentNode.getElement();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void setAt(int index,T value){
		Node CurrentNode = head; 
		int k =0;
		while (k<index)
		{
			CurrentNode = CurrentNode.getNext();
			if (CurrentNode == null){
				System.out.println("Out of Bound");
				return;
			}
			k++;
		}
		CurrentNode.setElement(value);	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void InsertAtpos(int index,T value){
		Node currentnode = head;
		int k=0;
		int i = index;
		if(head == null){
			head = new Node(value,null);
			return;
		}
		else if (i ==0){
			head = new Node(value,head);
			return;
		}
		while (k< (i-1)){
			if (currentnode.getNext() == null){
				//System.out.println("Index out of Bound");
				currentnode.setNext( new Node(value,null));
				return;
			}
			currentnode= currentnode.getNext();
			k++;
		}
		currentnode.setNext( new Node(value,currentnode.getNext()));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	boolean removeAt(int index){
		Node newnode = head;
		int k = 0;
		if(newnode == null){
			System.out.println("Empty list  - remove at ");
			return false;
		}
		else if (index == 0){
			head = newnode.getNext();
			return true;
		}
		while (k < (index-1) ){
			newnode = newnode.next;
			if(newnode.next == null){
				System.out.println("Index out of bound");
				return false;
			}
			k++;
		}
	newnode.setNext(newnode.getNext().getNext()); 
	return true;
	}
	
	@SuppressWarnings("rawtypes")
	int size(){
		 int k=0;
			Node currentnode = head;
			if(currentnode == null){
				//System.out.println("Empty List-- size");
				return 0;
			}
			while(currentnode != null){
				k++;
				currentnode = currentnode.getNext();
			}
			return k;
	}
	
	public String toString(){
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	void print()
	{
		Node currentnode = head;
		while(currentnode!= null){
			System.out.println(currentnode.getElement());
			currentnode=currentnode.getNext();
		}
		
	
	}
	
	@SuppressWarnings("rawtypes")
	public int isEmpty(){
		@SuppressWarnings("unused")
		Node Currentnode = head;
		if(head == null){
			return 0;
		}
		else return 1;
	}
}
