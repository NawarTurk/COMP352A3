import java.util.Comparator;

public class Entry<K extends Comparable, V extends Comparable>{
	K key;
	V value;
	

	
	public Entry(K key2, V value2) {
		this.key = key2;
		this.value = value2;	
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public int compareK(Entry<K,V> o1, Entry<K,V> o2) {
		return o1.getKey().compareTo(o2.getKey());
	}
	
	public int compareV(Entry<K,V> o1, Entry<K,V> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}

}
	
	
	

