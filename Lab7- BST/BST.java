	
public class BST {
   
	private static class BinaryNode {
	 private int value;
     private  BinaryNode left;
     private BinaryNode right;	
     private int height;
     private int depth;
     private int inorder_pos; 
     static int it = 0;
  
     public BinaryNode(int newVal) {
    	 this.value = newVal;
    	 this.left = null;
    	 this.right = null;
    	 this.height = 0;
    	 this.depth = 0;
    	 this.inorder_pos = 0;
     }
     
	private static BinaryNode insert(int value, BinaryNode t) {
    	 if(t == null){
			t= new BinaryNode(value);
			return t;
		}
		if(value<=t.value){
			if(t.left==null){
				t.left=new BinaryNode(value);
			}
			else{
				BinaryNode.insert(value, t.left);
			}
		}	
		else if(value > t.value){
			if(t.right == null){
				t.right= new BinaryNode(value);
			}
			else{
				BinaryNode.insert(value, t.right);
			}
		}		
    	 return t;
     }
     
     private static BinaryNode remove(int value, BinaryNode t) {
    	 BinaryNode IteratorNode = t;
    	 BinaryNode IteratorParent = t;
    	 int flag = 0;
    	 if(t == null){
			System.out.println("No element to remove");
			return t;
    	 }
    	 while(flag == 0){
    		 if(value < IteratorNode.value){
    			 if(IteratorNode.left==null){
    				 flag = -1;   
    			 }
    			 else{
    				 IteratorParent = IteratorNode;
    				 IteratorNode= IteratorNode.left;
    			 }
    		 }
    		 else if(value > IteratorNode.value){
    			 if(IteratorNode.right == null){
    				 flag =-1;
    			 }
    			 else{
    				 IteratorParent = IteratorNode;
    				 IteratorNode = IteratorNode.right;
    			 }
    		 }
    		 else if(IteratorNode.value == value){
    			 flag=1;
    		 }  
    	  }
    	 if(flag == -1){
    		 System.out.println("Could not find element");
    		 return t;
    	 }
    	 else if(flag == 1){
    		 System.out.println("Found : "+IteratorNode.value);
    	
    	 }
    	 // Found the Node (IteratorNode): Now to actually remove it and we have the Iterators parent also.	 
    	 //Case1: No child just set the node to null
    	 
    	 if(IteratorNode.left == null && IteratorNode.right == null){
    		 
    		 if(IteratorNode.value == t.value){
        		 return null;
        	 }
    		 if(IteratorParent.left.value == IteratorNode.value){
    			 IteratorParent.left = null;
    		 }
    		 else if(IteratorParent.right.value == IteratorNode.value){
    			 IteratorParent.right = null;
    		 }
    		 return t;
    	 }
    	 
    	 //Case2: Parent of one child
    	 //left child missing
    	 else if(IteratorNode.left == null){

			 BinaryNode replace = findMin(IteratorNode.right);
			 IteratorNode.value = replace.value;
			 //replace = remove(replace.value, replace);
			 IteratorNode.right = remove(replace.value, IteratorNode.right);
			 
    	 }
    	 //Right-Child missing
    	 else if (IteratorNode.right == null){

    		 BinaryNode replace = findMax(IteratorNode.left); 
    		 IteratorNode.value = replace.value;
    		 IteratorNode.left = remove(replace.value, IteratorNode.left);
    	 }
    	 else {
    		 //all other cases.
    		 BinaryNode replace = findMax(IteratorNode.left);
    		 IteratorNode.value = replace.value;
    		 IteratorNode.left = remove(replace.value,IteratorNode.left);
    	 }
		return t;
     }

	private static BinaryNode findMax(BinaryNode left) {
		while(left.right!=null){
			left = left.right;
		}
		return left;
	}

	private static BinaryNode findMin(BinaryNode right) {
		
		while(right.left!=null){
			right = right.left;
		}
		return right;
	}

	private static void display(BinaryNode t) {
       if(t  != null){  
    	   display(t.right);
    	   for(int i =0;i<t.depth;i++){
    		   System.out.print("  ");
    	   }
    	   System.out.println(t.value);
    	   display(t.left);
    	   
       }
     }

	public static void inorderupdate(BinaryNode t){
	       if(t  != null){  
	    	   inorderupdate(t.left);
	    	   it++;
	    	   t.inorder_pos = it;
	    	   inorderupdate(t.right);   
	       }
	}
	public static void Inorderupdateprint (BinaryNode t){
		if(t  != null){  
	    	   Inorderupdateprint(t.left);
	    	   System.out.println(" In order Position: "+t.inorder_pos+" 	Value: "+t.value);
	    	   Inorderupdateprint(t.right);   
	       }
	}
	
	public static void inorder(BinaryNode t) {
	       if(t  != null){  
	    	   inorder(t.left);
	    	   System.out.println(t.value);
	    	   inorder(t.right);   
	       }
		
	}

	public static void Preorder(BinaryNode t) {
		if(t  != null){
			System.out.println(t.value);
			Preorder(t.left);
			Preorder(t.right);
		}
	}

	public static void postorder(BinaryNode t) {
		if(t  != null){
			postorder(t.left);
			postorder(t.right);
			System.out.println(t.value);
		}
	}

	public static void setInorder() {
		it=0;	
	}
   
	public static void setDepth(BinaryNode t){
		if(t!=null){
			
			t.depth=curr_depth;
			curr_depth ++;
			setDepth(t.left);
			setDepth(t.right);
			if(max_depth < curr_depth) max_depth = curr_depth;
			curr_depth--;
		}
	}
	public static void DepthPrint(BinaryNode t) {
		if(t  != null){
			System.out.println("key: "+t.value+"	Depth:"+t.depth);
			DepthPrint(t.left);
			DepthPrint(t.right);
		}
	}

	public static void setHeight(BinaryNode t) {
		if(t!=null){
			curr_height ++;
			t.height= max_depth - curr_height;
			setHeight(t.left);
			setHeight(t.right);	
			curr_height--;
		}
		
	}

	public static void HeightPrint(BinaryNode t) {
		if(t  != null){
			System.out.println("key: "+t.value+"	Height:"+t.height);
			HeightPrint(t.left);
			HeightPrint(t.right);
		}
		
	}
   } // end of BinaryNode class
   
   private static int curr_depth = 0;
   private static int curr_height= 0;
   private static int number_elements = 0; 
   private static int max_depth = 0;
   
   private BinaryNode root = null;
   
   public void insert(int value) {
	   number_elements++;
	 root = BinaryNode.insert(value, root);
	 BinaryNode.setHeight(root);
	 BinaryNode.setDepth(root);
   }
   
   public void remove(int value) {
   
	  root = BinaryNode.remove(value, root);
	  BinaryNode.setHeight(root);
	  BinaryNode.setDepth(root);
   }
   public void display() { 
	    BinaryNode.setInorder();
		BinaryNode.inorderupdate(root);
		BinaryNode.display(root); 
   }
   public void Inorder(){
	   System.out.println("IN ORDER :");
	   BinaryNode.inorder(root);
   }
   public void preorder(){
	   System.out.println("PRE ORDER :");
	   BinaryNode.Preorder(root);
   }
   public void postorder(){
	   System.out.println("POST ORDER :");
	   BinaryNode.postorder(root);
   }
   
   public void inorderupdate(){
	   System.out.println("INORDER UPDATE");
	   BinaryNode.setInorder();
	   BinaryNode.inorderupdate(root);
	   BinaryNode.Inorderupdateprint(root);
   }
   
   public void setDepth(){
	   curr_depth =0;
	   BinaryNode.setDepth(root);
	   BinaryNode.DepthPrint(root);
   }
   
   public void setHeight() {
	curr_height = 0;
	   BinaryNode.setHeight(root);
	   BinaryNode.HeightPrint(root);
   }
   
}
