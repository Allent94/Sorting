
public class LinkedNode<T> implements Comparable<T> {
	
	/**
	 * 
	 * @author Allen Tran
	 * @version July 01 2018
	 *
	 */
	
	public T data;
	
	private LinkedNode<T> next;
	public LinkedNode(T element){
		data = element;
		next = null;
	}
	
	public LinkedNode(LinkedNode<T> theNode){
		
		data = theNode.getData();
		
	}
	
	public void setData(T no){
		
		data = no;
		 
	}

	public T getData() {		
		return data;
	}	
	
	public void setNext(LinkedNode<T> node){
		
		next = node;
		
	}
	
	public LinkedNode<T> getNext(){
		
		return next;
		
	}
	

	public String toString(){
		
		return data.toString();
		
		
	}

	   @SuppressWarnings("unchecked")
	   @Override
	   
	   public int compareTo(T theNode) {
		   
	       return ((Comparable<T>) this.getData()).compareTo(theNode);
	   }
	  
	}
