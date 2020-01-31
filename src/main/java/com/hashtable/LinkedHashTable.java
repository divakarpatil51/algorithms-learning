package com.hashtable;

public class LinkedHashTable<K, V> {

	private CustomLinkedList<K, V>[] linkedList;
	private static final int DEFAULT_SIZE = 10;

	public LinkedHashTable() {
		linkedList = new CustomLinkedList[DEFAULT_SIZE];
	}

	public LinkedHashTable(int size) {
		linkedList = new CustomLinkedList[size];
	}

	// Map Properties:
	// 1. Cannot have duplicate keys
	// 2. Can have only one null key

	public void put(K key, V value) {
		int hash = hashCode(key) % linkedList.length;

		CustomLinkedList<K, V> oldlinkedList = linkedList[hash];

		if (oldlinkedList == null) {
			CustomLinkedList<K, V> newLinkedList = new CustomLinkedList<>();
			newLinkedList.setNext(null);
			newLinkedList.setKey(key);
			newLinkedList.setValue(value);
			linkedList[hash] = newLinkedList;
			return;
		}

		// Chances of null pointer
		if ((key == null && oldlinkedList.getKey() == null) || key != null && key.equals(oldlinkedList.getKey())) {
			oldlinkedList.setValue(value);
			return;
		}

		CustomLinkedList<K, V> next = oldlinkedList.getNext();
		do {
			// Cases:
			// 1. No next
			// 2. Next has same key
			// 3. Next has different key
			if (next == null) {
				CustomLinkedList<K, V> newLinkedList = new CustomLinkedList<>();
				newLinkedList.setNext(null);
				newLinkedList.setKey(key);
				newLinkedList.setValue(value);
				oldlinkedList.setNext(newLinkedList);
			} else if ((key == null && oldlinkedList.getKey() == null)
					|| key != null && key.equals(oldlinkedList.getKey())) {
				next.setValue(value);
				break;
			} else {
				next = next.getNext();
			}
		} while (true);

	}

	public int size() {
		return linkedList.length;
	}

	public V get(K key) {
		int hash = hashCode(key) % linkedList.length;
		return linkedList[hash].getValue();
	}

	private int hashCode(K key) {
		// Always reduce the size of the hash code.
		return key == null ? 0 : key.hashCode() ^ 10;
	}

}
