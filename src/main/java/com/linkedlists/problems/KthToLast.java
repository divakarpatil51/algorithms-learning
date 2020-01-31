package com.linkedlists.problems;

//Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
//#8, #25, #41, #67, #126
public class KthToLast {

	public static void main(String[] args){
		Node tenth = new Node(10, null);
		Node ninth = new Node(9, tenth);
		Node eight = new Node(8, ninth);
		Node seventh = new Node(7, eight);
		Node sixth = new Node(6, seventh);
		
		Node fifth = new Node(5, sixth);
		Node fourth = new Node(4, fifth);
		Node third = new Node(3, fourth);
		Node second = new Node(2, third);
		Node head = new Node(1, second);
		findElementNumber(head, 6);
	}
	
	private static void findElementNumber(Node head, int elementNumber){
		int size = 0;
		Node current = head;
		while(current.next != null) {
			size++;
			current = current.next;
		}
		elementNumber = size - elementNumber + 1;
		size = 0;
		current = head;
		while(current.next != null) {
			
			if(size == elementNumber){
				System.out.println("Element at "+ elementNumber +" is " + current.data);
				break;
			}
			size++;
			current = current.next;
		}
		
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