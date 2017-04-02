
public class QueueUnderflowException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4128603798523826231L;
	
	public QueueUnderflowException(){}
	public QueueUnderflowException(String s){
		super(s);
	}
}
