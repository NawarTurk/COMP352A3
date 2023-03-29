
public class Drive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PQ pq = new PQ();
		pq.insert(1, "A");
		pq.insert(3, "B");
		pq.insert(5, "B");
		pq.insert(10, "B");
		pq.insert(17, "S");
		pq.insert(17, "B");
		pq.insert(9, "B");
		pq.insert(20, "B");
		pq.insert(25, "S");
		pq.insert(30, "B");
		pq.insert(35, "B");
		pq.insert(60, "B");

		pq.toggle();
		pq.toggle();
		pq.toggle();
		pq.insert(100, "j");
		pq.replaceKey(new Entry(9, "B"), 1000);
		pq.print();
		pq.replaceKey(new Entry(35, "B"), 1);
		pq.print();

		
//		int k = 7;
////		for (int i = 1; i<= pq.size();i++) {
////			pq.pqArray[i].setKey(k);
////			k--;
////		}
//		pq.print();
//		pq.bottomUpConstruction();

//		System.out.println("test");
//		pq.replaceKey(new Entry(1, "A"), 1000);
//		pq.print();
//		System.out.println("done");
//
//		System.out.println(pq.locateEntry(new Entry(10,"B"))[1]);
//		System.out.println(pq.hasChildren(4));
//		
//		Entry e = new Entry (5, "B");
//		pq.replaceValue(e, "X");
//		
//		System.out.println(pq.pqArray[1].getValue());
//		System.out.println(pq.pqArray[4].getValue());
//		System.out.println(pq.pqArray[5].getValue());
//		
//		pq.remove(new Entry(1,"A"));
//		System.out.println("ssss");
//
//		pq.print();
//		System.out.println("ss");
		
	}

}
