
public class Node { // Generic node of a linked list

	private Object data; // instead of C/C++ void*
	private Node next;

	public Node( Object o, Node n ) {
	          data = o;  next = n;
	}
	
	public void setData (Object d) {
		
	}
    public void setNext(Node n) {
    	
    }
    public Object getData() {
    	 
    		return data;
    }
    public Node getNext() {
    	
    		return next;
    }
    
	 // end class Node
}
