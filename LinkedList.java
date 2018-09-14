public class LinkedList<T>{
	
	/**
	 * 
	 * @author Allen Tran
	 * @version July 01 2018
	 *
	 */
	
	private LinkedNode<T> head;
	private LinkedNode<T> next;
	private LinkedNode<T> last;
	private int size;
	
	public LinkedList(){
		
		head = null;
		next = null;
		last = null;
		
	}
	
	public LinkedList(LinkedNode<T> head){
		
		next = head;
		size = 1;
		while(next.getNext() != null){
			size++;
			next = next.getNext();
			last = next;
			
		}
		
		
	}
	
	public void add(T element){
		
		if(head == null){
			
			head = new LinkedNode<T>(element);
			last = head;
			size++;
			
		}else{
			
			next = last;
			next.setNext(new LinkedNode<T>(element));
			last = next.getNext();
			size++;
		}
	}
	
	public String printList(){
		
		StringBuilder sb = new StringBuilder();
		LinkedNode<T> current = head;

		if(head == null){
			
			sb.append("There is no LinkedList");
			
		}else{ 
			
			current = head;
			
			while(current.getNext() != null){
				
				sb.append(current.getData());
				sb.append(",");
				current = current.getNext();
			
			}
			
			sb.append(current.getData());
			
					
		}
		
		//[10] -> [20] -> [50] -> [1]
		
		return sb.toString();
			
	}
	
	public LinkedNode<T> getHead() {
		return head;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setHead(LinkedNode<T> node) {
		head = node;
	}
	
	
}
			
	



