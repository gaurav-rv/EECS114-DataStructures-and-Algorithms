import java.util.ArrayList;

public class WordLadder {

	public WordLadder(String start, String end, ArrayList<String> dictionary) {
			MyStack<String> NewList = new MyStack<String>();
			NewList.push(start);
			MyQueue<MyStack<String>> QStack = new  MyQueue<MyStack<String>>();
			QStack.push(NewList);
			
			while(QStack.isEmpty() != 0){
				for (int i=0; i<dictionary.size(); i++){
					MyStack<String> tempstack= QStack.front();

					int number = Difference(dictionary.get(i), tempstack.top());
					
					if(number == 1 ){
						
						if(dictionary.get(i).equals(end)){
								//QStack.front().push((String)dictionary.getAt(i));
								System.out.println(dictionary.get(i));
								
								while(QStack.front().isEmpty()!= true){
									System.out.println(QStack.front().top());
									QStack.front().pop();
									}
								return;
							}
					MyStack<String> TempStack = new MyStack<String>(QStack.front());
					TempStack.push( dictionary.get(i));
					QStack.push(TempStack);
					}			
				}
				QStack.pop();
			}
	}

	public int Difference(Object at, String top) {

		String teststring = at.toString();

		int count =0;
		
		if (teststring.length() != top.length() ){
			System.out.println("Not the same size");
			return 0;
			}
		for (int n=0;n<teststring.length();n++){
			if(teststring.charAt(n) != top.charAt(n) ){
				count ++;
				}
			}
		return count;
	}


}
