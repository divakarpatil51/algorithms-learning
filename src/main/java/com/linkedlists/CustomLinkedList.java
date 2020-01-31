package com.linkedlists;

import java.util.Iterator;

public class CustomLinkedList {

	private Node head;

	public static class Node {
		private Node next;
		private int data;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public Node addFirst(int data) {
		head = new Node(data, head);
		return head;
	}

	public Node traverseList() {
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		return n;
	}

	public void addLast(int data) {
		if (head == null) {
			addFirst(data);
			return;
		}
		Node last = traverseList();
		last.next = new Node(data, null);
	}

	public void insertAfter(int key, int data) {
		// Checks:
		// 1. Head can be null
		// 2. No after present.
		Node n = head;
		while (n != null && n.data != key) {
			n = n.next;
		}
		if (n != null) {
			n.next = new Node(data, n.next);
		}

	}

	public void insertBefore(int key, int data) {
		Node current = head;
		Node before = null;
		while (current != null && current.data != key) {
			before = current;
			current = current.next;
		}
		if (before != null) {
			before.next = new Node(data, current);
		}

	}

	public void delete(int key) {
		if (head == null)
			throw new RuntimeException("cannot delete");

		if (head.data == key) {
			head = head.next;
			return;
		}

		Node cur = head;
		Node prev = null;

		while (cur != null && cur.data != key) {
			prev = cur;
			cur = cur.next;
		}

		if (cur == null)
			throw new RuntimeException("cannot delete");

		// delete cur node
		prev.next = cur.next;
	}

	public CustomLinkedList copy() {
		if (head == null)
			return null;
		CustomLinkedList twin = new CustomLinkedList();
		Node tmp = head;
		twin.head = new Node(head.data, null);
		Node tmpTwin = twin.head;

		while (tmp.next != null) {
			tmp = tmp.next;
			tmpTwin.next = new Node(tmp.data, null);
			tmpTwin = tmpTwin.next;
		}

		return twin;
	}
	
	public LinkedListIterator iterator(){
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<Integer> {

		private Node nextNode;

		public LinkedListIterator() {
			nextNode = head;
		}

		@Override
		public boolean hasNext() {
			return nextNode == null || nextNode.next != null;
		}

		@Override
		public Integer next() {
			if (!hasNext())
				throw new RuntimeException("No next element found");
			Integer res = nextNode.data;
			nextNode = nextNode.next;
			return res;
		}

	}
}
