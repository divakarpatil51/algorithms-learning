package com.hashtable;

public class CustomBinaryTree<T> {

	private CustomBinaryTree<T> leftNode;
	private CustomBinaryTree<T> rightNode;
	private T value;

	public CustomBinaryTree<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(CustomBinaryTree<T> leftNode) {
		this.leftNode = leftNode;
	}

	public CustomBinaryTree<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(CustomBinaryTree<T> rightNode) {
		this.rightNode = rightNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
