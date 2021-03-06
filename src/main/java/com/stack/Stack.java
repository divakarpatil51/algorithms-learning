package com.stack;

/**
*Stack implementation using linked list.
*/
public class Stack<T> {

	private StackNode<T> head;
	
	/*
	*	Push data at the top of the stack.
	*/
	public void push(T data){
		StackNode<T> newHead = new StackNode<>(data, head);
		head = newHead;
	}

	/*
	*	Remove the top of the stack.
	*/
	public StackNode<T> pop() throws Exception {
		if(head == null){
			throw new Exception("Empty Stack");
		}
		head = head.previous;
		return head;
	}
	
	/*
	*	Get the top of the stack.
	*/
	public T peek() throws Exception{
		if(head == null){
			throw new Exception("Empty Stack");
		}
		return head.data;
	}
	
	public boolean isEmpty(){
		return head == null;
	}

	private static class StackNode<T> {
		
		T data;
		StackNode<T> previous;
		
		public StackNode(T data, StackNode<T> previous){
			this.data = data;
			this.previous = previous;
		}
	}
}