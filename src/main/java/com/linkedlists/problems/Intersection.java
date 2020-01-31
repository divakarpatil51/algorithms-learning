package com.linkedlists.problems;

//Intersection; Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
//node. Note that the intersection is defined based on reference, not value. That is, if the kth
//node of the first linked list is the exact same node (by reference) as the j t h node of the second
//linked list, then they are intersecting.
public class Intersection {
	
	public static void main(String[] args) {
		
		Node fifth2 = new Node(5, null);
		Node fourth2 = new Node(4, fifth2);
		Node third2 = new Node(3, fourth2);
		Node second2 = new Node(5, third2);
		Node head2 = new Node(2, second2);
		
		
		Node second = new Node(2, third2);
		Node head1 = new Node(1, second);
		intersection(head1, head2);		
	}
	
	private static void intersection(Node first, Node second){
		int firstLength = length(first);
		int secondLength = length(second);
		//TODO: find good solution;
	}
		
	private static int length(Node node){
		int length = 0;
		while(node != null){
			length++;
			node = node.next;
		}
		return length;
	}
	
	private static class Node {
		Node next;
		int data;
		
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
}