package com.hashtable;

public class CustomLinkedList<K, V> {

	private CustomLinkedList<K, V> next;
	private K key;
	private V value;

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public CustomLinkedList<K, V> getNext() {
		return next;
	}

	public void setNext(CustomLinkedList<K, V> next) {
		this.next = next;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
