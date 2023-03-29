import java.util.Comparator;

public class PQ<K extends Comparable, V extends Comparable> {
	private static int HEAP_CONSTANT = 1;
	private static final String MIN_HEAP = "Min Heap";

	Entry[] pqArray = new Entry[100];
	String currentState= MIN_HEAP;
	int lastNode=0;
	
	Entry removeTop() {
		if (this.size()==0) {
			System.out.println("The queue is empty");
			return null;
		} else {
			Entry e = this.pqArray[1];
			this.remove(e);
			return e;
		}
	}
	
	Entry insert(K key, V value) {
		Entry newEntry = new Entry(key, value);
		lastNode++;
		pqArray[lastNode] = newEntry;
		this.upHeap(lastNode);
		print();
		return newEntry;
	}
	
	K top() {
		return (K) pqArray[1].getKey();
	}
	
	Entry remove(Entry e) {
		int[] entryIndexArray = this.locateEntry(e);
		
		for (int i = 0; i<entryIndexArray.length ; i++) {
			if (entryIndexArray[i]==0) break;
			this.pqArray[entryIndexArray[i]]=this.pqArray[lastNode];
			lastNode--;
			this.upHeap(entryIndexArray[i]);
			this.downHeap(entryIndexArray[i]);
		}
		return e;	
	}
	
	K replaceKey (Entry e, K newKey) {
		// test
		K oldKey = (K) e.getKey();
		int[] entryIndexArray = this.locateEntry(e);
		for (int i = 0; i<entryIndexArray.length ; i++) {
			if (entryIndexArray[i] < 1) break;
			this.pqArray[entryIndexArray[i]].setKey(newKey);
			this.upHeap(entryIndexArray[i]);
			this.downHeap(entryIndexArray[i]);
		}
		return oldKey;
	}
	
	V replaceValue (Entry e, V newValue) {
		//test
		int[] entryIndexArray = this.locateEntry(e);
		
		V oldValue = (V) e.getValue();
		for (int i = 0; i<entryIndexArray.length ; i++) {
			if (entryIndexArray[i] < 1) break;
			this.pqArray[entryIndexArray[i]].setValue(newValue);
		}
		return oldValue;
	}
	
	String state() {
		return currentState;
	}
	
	// done
	Boolean isEmpty() {
		return pqArray.length == 0;
	}
	
	
	//done
	int size() {
		return lastNode;
	}
	
	void toggle() {
		if (HEAP_CONSTANT == 1) {
			HEAP_CONSTANT = -1;
		} else {
			HEAP_CONSTANT =1;
		}
		bottomUpConstruction();
	}
	
	
	void upHeap(int childNodeIndex) {
		int parentNodeIndex = childNodeIndex/2;
		
		while (parentNodeIndex > 0) {
			if (pqArray[parentNodeIndex].compareK(pqArray[parentNodeIndex], pqArray[childNodeIndex])==HEAP_CONSTANT) {
				Entry temp = pqArray[parentNodeIndex];
				pqArray[parentNodeIndex]=pqArray[childNodeIndex];
				pqArray[childNodeIndex]=temp;
				childNodeIndex = parentNodeIndex;
				parentNodeIndex=parentNodeIndex/2;			
			} else {
				break;
			}
		}
	}
	
	void downHeap(int nodeInex) {
		int parentNodeIndex = nodeInex;
		int childToSwitchIndex;
		int leftChildIndex;
		int rightChildIndex;
		
		while(this.hasChildren(parentNodeIndex) || this.hasLeftChild(parentNodeIndex) ) {
			leftChildIndex = 2*parentNodeIndex;
			rightChildIndex = 2*parentNodeIndex + 1;
			
			if (this.hasChildren(parentNodeIndex)) {
				if(this.pqArray[leftChildIndex].compareK(pqArray[leftChildIndex], pqArray[rightChildIndex])==HEAP_CONSTANT) {
					childToSwitchIndex = rightChildIndex;
				} else {
					childToSwitchIndex = leftChildIndex;
				}
				if (this.pqArray[parentNodeIndex].compareK(this.pqArray[parentNodeIndex], this.pqArray[childToSwitchIndex])==HEAP_CONSTANT) {
					this.switchNodes(parentNodeIndex,childToSwitchIndex);
					parentNodeIndex = childToSwitchIndex;
					continue;
				} else {
					break;
				}
			} else if (this.hasLeftChild(parentNodeIndex)) {
				childToSwitchIndex = leftChildIndex;
				if (this.pqArray[parentNodeIndex].compareK(this.pqArray[parentNodeIndex], this.pqArray[childToSwitchIndex])==HEAP_CONSTANT) {
					this.switchNodes(parentNodeIndex,childToSwitchIndex);
					parentNodeIndex = childToSwitchIndex;	
				} else {
					break;
				}
			} else {
				break;
			}
		}
	}
	
	
	//_Auxularry Methods
	
	private void switchNodes(int entry1Index, int entry2Index) {
		Entry temp = this.pqArray[entry1Index];
		this.pqArray[entry1Index] = this.pqArray[entry2Index];
		this.pqArray[entry2Index] =temp;
		
	}

	void print() {
		for (int i =1; i<=size(); i++) {
			System.out.print(pqArray[i].getKey() + " ");
		}
		System.out.println();
	}
	
	int[] locateEntry (Entry e) {
		int[] entryIndexArray = new int [this.size()];
		int index =0;
		for(int i = 1; i<= this.size(); i++) {
			if (e.compareK(e, pqArray[i])==0 && e.compareV(e,pqArray[i])==0) {
				entryIndexArray[index] = i;
				index++;
			}
		}
		return entryIndexArray;
	}
	
	boolean hasChildren(int entryIndex ) {
		return hasLeftChild(entryIndex) && hasRightChild(entryIndex);
	}

	private boolean hasRightChild(int entryIndex) {
		return entryIndex * 2 + 1 <= this.size();
	}

	private boolean hasLeftChild(int entryIndex) {
		return entryIndex * 2 <= this.size();
	}
	
	void bottomUpConstruction() {
		int startIndex = this.size()/2;
		for (int i =startIndex; i>=1; i--) {
			this.downHeap(i);
		}
		this.print();
	}
}
