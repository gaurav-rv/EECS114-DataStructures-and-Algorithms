
public class Main {

	public static void main(String args[]){
		BST binary = new BST();
		int a[] ={4,2,6,1,3,5,7};//{2, 4, 6, 7, 8, 9,12}; //
		System.out.println("Inserting...");
		for(int i = 0; i < a.length; i++) {
		    binary.insert(a[i]);
		  	}
		binary.display();

		System.out.println("=========");
		binary.Inorder();
		binary.preorder();
		binary.postorder();
		binary.inorderupdate();
		System.out.println("	Display Depth	");
		binary.setDepth();
		System.out.println("	Display Height	");
		binary.setHeight();
		System.out.println("\n DISPLAY FUNCTION \n");
		binary.display();
		binary.remove(7);
		System.out.println("	After Removing 7	");
		binary.display();
	}
}
