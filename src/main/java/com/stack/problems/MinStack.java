package com.stack.problems;

//Stack Min: How would you design a stack which, in addition to push and pop, has a function min
//which returns the minimum eiement? Push, pop and min should ail operate in 0 ( 1 ) time.
public class MinStack<T extends Comparable<T>> {
	
	//#27, #59, #78
	private int minElement;
	private T[] stack;
	private T[] minStack;
	private int head;
		
	public MinStack(int size){
		stack = (T[]) new Object[size];
		minStack = (T[]) new Object[size];
	}
	
	public void push(T data) throws Exception {
		if(isFull()){
			throw new Exception("Stack is full");
		}
		stack[++head] = data;
		if(getMinElement().compareTo(data) > 0){
			minStack[minElement++] = data;
		}
	}
	
	public T pop() {
		if(stack[head] == getMinElement()){
			minElement--;
		}
		T data = stack[head];
		head--;
		return data;
	}
	
	public T getMinElement() {
		return minStack[minElement];
	}
	
	private boolean isFull(){
		return head == stack.length;
	}
	
}