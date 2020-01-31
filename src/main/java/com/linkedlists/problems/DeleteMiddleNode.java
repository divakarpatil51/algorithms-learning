package com.linkedlists.problems;

//Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
//the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
//that node.

public class DeleteMiddleNode {
	
	public static void main(String[] args){
		Node fourth = new Node(4, null);
		Node third = new Node(3, fourth);
		Node second = new Node(2, third);
		Node head = new Node(1, second);
		deleteMiddleNode(third);
	}
	
	public static void deleteMiddleNode(Node node){
		if(node == null || node.next == null) {
			return;
		}
		
		node.data = node.next.data;
		node.next = node.next.next;
	}
	
	
	private static class Node {
		int data;
		Node next;
		
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
}