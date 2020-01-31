package com.stack.problems;

public class MyQueue {

	private StackNode permStack;
	private StackNode tempStack;
	private int size;
	
	public static void main(String[] args) throws Exception {
		MyQueue queue = new MyQueue();
		
		System.out.println("After enqueue 10: ");
		queue.enqueue(10);
		
		System.out.println("After enqueue 11: ");
		queue.enqueue(11);
		
		System.out.println("After enqueue 12");
		queue.enqueue(12);
				
		queue.dequeue();
		System.out.println("After dequeue");
		queue.printStack();
		
	}
	
	public void printStack(){
		while( permStack!= null) {
			System.out.println(permStack.data);
			permStack = permStack.next;
		}
	}
	
	public void enqueue(int val){
		StackNode nextStackNode = new StackNode();
		nextStackNode.data = val;
		size++;
		
		if(permStack == null){
			permStack = nextStackNode;
			return;
		}
		
		while(permStack.next != null) {
			permStack = permStack.next;
		}
		
		permStack.next = nextStackNode;
		printStack();
	}
	
	public void dequeue() throws Exception {
		if(permStack == null) {
			throw new Exception("Empty queue!!");
		}
		tempStack = permStack;
		int tempSize = size;
		while(true) {
			tempSize--;
			if(tempSize == 1) {
				permStack = null;
				break;
			}
			tempStack = permStack.next;
			permStack = permStack.next;
		}
		size--;
		while(tempStack != null){
			permStack = tempStack.next;
			tempStack = tempStack.next;
		}
		
	}
	
	private boolean isEmpty() {
		return permStack != null;
	}

	private class StackNode {
		StackNode next;
		int data;
	}
}