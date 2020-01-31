package com.linkedlists.problems;

public class LoopDetection {
	
	public static void main(String[] args){
		Node fifth = new Node(5, null);
		Node fourth = new Node(4, fifth);
		Node third = new Node(3, fourth);
		Node second = new Node(1, third);
		Node head = new Node(2, second);
		
		fifth.next = second;
		
		Node node = findBeginning(head);
		if(node == null){
			System.out.println("No circular");
		}else {
		System.out.println(node.data);
		}
	}
	
	private static Node findBeginning(Node head){
		Node slow = head;
		Node fast = head;
		
		while (fast != null && fast.next != null) { 
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				break;
			}
		}
		
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
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