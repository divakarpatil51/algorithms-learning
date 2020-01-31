package com.linkedlists.problems;

public class SumLists {

	public static void main(String[] args){
		Node third = new Node(5, null);
		Node second = new Node(9, third);
		Node head = new Node(2, second);
		
		Node third2 = new Node(7, null);
		Node second2 = new Node(1, third2);
		Node head2 = new Node(6, second2);
		
		//Node node = reverseSumListsByConvertingToInteger(head, head2);
		//while(node != null){
			//System.out.print(node.data + "-->");
			//node = node.next;
		//}
		
		Node node = reverseSumListsRecursion(head, head2, 0);
		while(node != null){
			System.out.print(node.data + "-->");
			node = node.next;
		}
	}
	
	private static Node reverseSumListsByConvertingToInteger(Node n1, Node n2) {
		int sum = 0;
		int multiplier = 1;
		
		while(n1 != null){
			sum += n1.data * multiplier;
			multiplier *= 10;
			n1 = n1.next;
		}
		
		int secondSum = 0;
		multiplier = 1;
		
		while(n2 != null){
			sum += (n2.data * multiplier);
			multiplier *= 10;
			n2 = n2.next;
		}
		
		sum += secondSum;
		int divisor = sum;
		
		Node head = null;
		Node curr = null;
		while(divisor != 0){
			int remainder = divisor % 10;
			divisor = divisor / 10;
			if(head == null){
				head = new Node(remainder, null);
				curr = head;
			}else {
				Node newNode = new Node(remainder, null);
				curr.next = newNode;
				curr = curr.next;
			}
		}
		return head;
	}
	
	private static Node reverseSumListsRecursion(Node n1, Node n2, int carry) {
		
		if(n1 == null && n2 == null & carry == 0){
			return null;
		}
		
		if(n1 != null){
			carry +=  n1.data;
		}
		
		if(n2 != null){
			carry +=  n2.data;
		}
		
		Node newNode = new Node(carry % 10, null);
		
		if(n1 != null || n2 != null){
			Node nextNode = reverseSumListsRecursion(n1 == null ? null : n1.next, n2 == null ? null : n2.next, carry / 10);
			newNode.next = nextNode;
		}
		
		return newNode;
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