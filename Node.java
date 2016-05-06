  public class Node {
	  

	//----------------------------------------------------- 
	// Title: Node Class 
	// Author: Hilal Köktürk
	// ID: 49093709988 
	// Section: 1 
	// Assignment: 1 
	// Description: This class represent the Node class of Hash table. 
	//----------------------------------------------------

	  	protected String key;
        
        protected Node next;
        
        protected int count;
        
        public Node(String key, Node next) {
        	
       	//--------------------------------------------------------         
    	// Summary: This is constructor of the Node class.       
    	// Precondition: Key is string and next is Node        
    	//---------------------------------------------------------
            this.key = key;
            this.next = next;
            this.count = 1;
        }
        public int getCount() {return count;} // this method returns the count.
        
        public void increaseCount() {count++;}//this method increase the count.
        
        public String getKey() {return key;}//this method returns the key.
        
        public Node getNext() {return next;} // this method return the next node.
        
        public void setKey(String key) {this.key = key;} // this method set the given string value of key
        
        public void setNext(Node next) {this.next = next;} //this method set the given node value of next.
        
        public void setCount(int count) {this.count = count;} //this method set the given integer value of count.
        
    }