package com.linkedlists.problems;
//Hints: #3, #24

public class Partition {
	
	public static void main(String[] args){
		
		Node seventh = new Node(1, null);
		Node sixth = new Node(2, seventh);
		Node fifth = new Node(10, sixth);
		Node fourth = new Node(0, fifth);
		Node third = new Node(8, fourth);
		Node second = new Node(5, third);
		Node head = new Node(8, second);
		partition(head,5);
	}
	
	private static void partition(Node head, int partition){
		if(head == null){
			return;
		}
		Node pivot = head;
		Node runner = head;
		while(runner != null){
			if(pivot.data < partition){
				pivot = pivot.next;
				runner = pivot;
			}else if(runner.data < partition){
				int data = pivot.data;
				pivot.data = runner.data;
				runner.data = data;
			}
			runner = runner.next;
		}
		
		System.out.println("Pivot-->" + pivot.data);
		
		while(head != null){
			System.out.println(head.data + "-->");
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