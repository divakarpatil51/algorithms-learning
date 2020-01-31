package com.linkedlists.problems;


//Remove Dups: Write code to remove duplicates from an unsorted linked list.
//FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?
public class RemoveDups {
	
	public static void main(String[] args) {
		System.out.println("Started");
		Node fifth = new Node(3, null);
		Node fourth = new Node(6, fifth);
		Node third = new Node(5, fourth);
		Node second = new Node(1, third);
		Node head = new Node(5, second);
		removeDuplicates(head);
	}
	
	private static void removeDuplicates(Node head){
		if(head == null){
			return;
		}
		Node current = head.next;
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				System.out.println("In loop" + current.data);
				
				if(runner.next.data == current.data){
					runner.next = runner.next.next;		
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
		
		while(head.next != null){
			System.out.println("Data --> " + head.data);
			head = head.next;
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
