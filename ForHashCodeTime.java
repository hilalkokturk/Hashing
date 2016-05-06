public class ForHashCodeTime {
	int TableSize = 100;
	public Node[] table = new Node[TableSize];

	private int hash(String key) { // 0 milisecond

		long start = System.currentTimeMillis();
		int a = (key.hashCode() & 0x7fffffff) % 20;
		long end = System.currentTimeMillis();
		System.out.println("That took " + (end - start) + " milliseconds");
		return a;

	}



	private int hash3(String key) { // 0-1 arasý milisecond
		long start = System.currentTimeMillis();
		int hash = TableSize;
		for (int i = 0; i < key.length(); i++) {
			hash = (hash * 31 + key.charAt(i)) % 100;
			long end = System.currentTimeMillis();
			System.out.println("That took " + (end - start) + " milliseconds");
		}
		return hash;
	}

	private int hash4(String key) { 
	
		// süre stringe göre deðiþip 12 13'e bile çýkabiliyor

		long start = System.currentTimeMillis();
		int hash = 0;
		for (int i = 0; i < TableSize; i++) {
			hash = (hash * 8 + key.length() % TableSize);
			long end = System.currentTimeMillis();
			System.out.println("That took " + (end - start) + " milliseconds");

		}
		return hash;

	}

}
