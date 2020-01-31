package com.hashtable;

public class BinaryTreeHashTableImpl<K, V> {

//	The advantage of this is potentially using less space, since we no longer allocate a large array.
//	0 ( l o g N)
//	lookup time
	private CustomBinaryTree<V>[] binaryTree;
	private static final int DEFAULT_SIZE = 10;

	public BinaryTreeHashTableImpl() {
		binaryTree = new CustomBinaryTree[DEFAULT_SIZE];
	}

	public BinaryTreeHashTableImpl(int size) {
		binaryTree = new CustomBinaryTree[size];
	}

	public void put(K key, V value) {
		int hash = hashCode(key) % binaryTree.length;

		CustomBinaryTree<V> newLinkedList = new CustomBinaryTree<>();
		newLinkedList.setValue(value);
		CustomBinaryTree<V> oldlinkedList = binaryTree[hash];
		if (oldlinkedList == null) {
			binaryTree[hash] = newLinkedList;
		} else {
			oldlinkedList.setLeftNode(null);
			oldlinkedList.setRightNode(null);
		}

	}

	public V get(K key) {
		int hash = hashCode(key) % binaryTree.length;
		return binaryTree[hash].getValue();
	}

	private int hashCode(K key) {
		return key.hashCode() / 10;
	}
}
