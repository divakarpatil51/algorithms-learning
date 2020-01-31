package com.stack.problems;

//Three in One: Describe how you could use a single array to implement three stacks.
public class MultiStack<T> {

	private int numberOfStacks = 3;
	private T[] values;
	private int[] stack;
	private int totalSize;
	
	public MultiStack(int stackSize){
		totalSize = stackSize;
		values = (T[])new Object[numberOfStacks * stackSize];
		stack = new int[numberOfStacks];
	}
	
	public void push(int stackNum, T value) throws Exception {
		if(isFull(stackNum)){
			throw new Exception("Stack is full!");
		}
		stack[stackNum]++;
		values[getHeadFor(stackNum)] = value;
	}
	
	public T pop(int stackNum) throws Exception {
		if(isEmpty(stackNum)){
			throw new Exception("Stack is empty!");
		}
		
		int head = getHeadFor(stackNum);
		T val = values[head];
		values[head] = null;
		stack[stackNum]--;
		return val;
	}
	
	public T peek(int stackNum) throws Exception {
		if(isEmpty(stackNum)){
			throw new Exception("Stack is empty!");
		}
		return values[getHeadFor(stackNum)];
	}
	
	private int getHeadFor(int stackNum) {
		return stackNum * totalSize - 1 + stack[stackNum];
	}
	
	private boolean isFull(int stackNum) {
		return stack[stackNum] == totalSize;
	}
	
	private boolean isEmpty(int stackNum) {
		return stack[stackNum] == 0;
	}
}