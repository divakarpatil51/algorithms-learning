package com.linkedlists.problems;

public class Palindrome {

	public static void main(String[] args) {
		Node sixth = new Node(6, null);
		Node fifth = new Node(1, sixth);
		Node fourth = new Node(7, fifth);		
		Node third = new Node(7, fourth);
		Node second = new Node(1, third);
		Node head = new Node(6, second);
		System.out.println(isPalindrome(head));
	}
	
	public static boolean isPalindrome(Node head) {
		Node reversed = reverse(head);
		return isEqual(head, reversed);
		
	}
	
	public static Node reverse(Node head) {
		Node reversed = null;
		while(head != null) {
			Node node = new Node(head.data, null);
			node.next = head;
			reversed = node;
			head = head.next;
		}
		
		while(reversed != null) {
			System.out.print(reversed.data + " --> ");
			reversed = reversed.next;
		}
		
		return reversed;
	}
	
	public static boolean isEqual(Node n1, Node n2) {
		while(n1 != null && n2 != null) {
			
			if(n1.data != n2.data){
				return false;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return true;
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