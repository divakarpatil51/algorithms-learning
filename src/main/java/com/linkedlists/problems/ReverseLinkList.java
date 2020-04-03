package com.linkedlists.problems;

public class ReverseLinkList {

	public static void main(String[] args) {
		ListNode last = new ListNode(5, null);
		ListNode fourth = new ListNode(4, last);
		ListNode third = new ListNode(3, fourth);
		ListNode second = new ListNode(2, third);
		ListNode head = new ListNode(1, second);

		ListNode node = head;
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}

		ListNode reversedList = reverseList(head);
		System.out.println("");
		while (reversedList != null) {
			System.out.print(reversedList.val + "->");
			reversedList = reversedList.next;
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int x, ListNode next) {
		val = x;
		this.next = next;
	}
}
