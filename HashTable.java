
//----------------------------------------------------- 
// Title: Hash Table Class 
// Author: Hilal Köktürk
// ID: 49093709988 
// Section: 1 
// Assignment: 1 
// Description: This class is the Hash Table class. 
//It consists of hash table implementation method. 
//----------------------------------------------------

public class HashTable {
	
	public HashTable() {
		//--------------------------------------------------------         
		// Summary: This is the constructor of HashTable class(empty constructor).   
		//---------------------------------------------------------


	}

	int TableSize = 100;
	int count = 1;
	public Node[] table = new Node[TableSize];

	private int hash(String key) {
		 //--------------------------------------------------------         
		// Summary: This method hash the given key.         
		// Precondition: Key is string       
		// Postcondition: Key will be hashed. So this method return the hash value.    
		//---------------------------------------------------------

		return (key.hashCode() & 0x7fffffff) % 100;

	}

	public void find() {
		
		//--------------------------------------------------------         
		// Summary: This method will find the most used top ten hastag value.          
		// Postcondition: it found the top ten hastag value and their count.
		//Also it print the information of the hastag name and count.
		//---------------------------------------------------------
		
		
		String[] topten = new String[10];
		int[] top10 = new int[10];
		for (int i = 0; i < 10; i++) {
			String st = "";
			int top = 0;
			for (int j = 0; j < table.length; j++) {
				for (Node n = table[j]; n != null; n = n.getNext()) {
					if (n.getCount() > top) {
						st = n.getKey();
						top = n.getCount();
					}
				}
			}
			topten[i] = st;
			top10[i] = top;
			for (Node n = table[hash(st)]; n != null; n = n.getNext()) {
				if (n.getKey().equals(st)) {
					n.setCount(0);
				}
			}
		}
		for (int i = 0; i < topten.length; i++) {
			System.out.println(topten[i] + ": " + top10[i]);
		}
	}

	public void put(String key) {
		 //--------------------------------------------------------         
		// Summary: This method put the given key on the hash table.        
		// Precondition: Key is string       
		// Postcondition: Keys put the hash table.      
		//---------------------------------------------------------
		int i = hash(key);
		Node n = table[i];
		while (n != null) {
			if (key.equals(n.getKey())) {
				n.increaseCount();
				return;
			} else {
				n = n.getNext();
			}
		}
		table[i] = new Node(key, table[i]);
	}

	public int get(String key) {
		//--------------------------------------------------------         
		// Summary: This method get the given key.         
		// Precondition: Key is string       
		//---------------------------------------------------------
		
		int hash = hash(key);
		if (table[hash] == null)
			return -1;
		else {
			Node entry = table[hash];
			while (entry != null && entry.getKey() != key)
				entry = entry.getNext();
			if (entry == null)
				return -1;
			else
				return entry.getCount();
		}
	}

}