package com.stack.problems;

//TODO: Refactor this class!!
public class SortedStack {

	private StackNode sortedHead;
	private StackNode tempStack;
	
	public static void main(String[] args){
		SortedStack sortedStack = new SortedStack();
		sortedStack.push(10);
		sortedStack.push(1);
		sortedStack.push(20);
		sortedStack.push(5);
		sortedStack.push(6);
		sortedStack.push(32);
		
		sortedStack.print();
	}
	
	public void print() {
		System.out.println("Sorted stack::");
		StackNode sta = sortedHead;
		while(sta != null) {
			System.out.print(sta.data + "-->");
			sta = sta.previous;
		}
		System.out.println();
	}
	
	public void printTemp() {
		System.out.println("Temp stack::");
		StackNode sta = tempStack;
		while(sta.previous != null) {
			System.out.print(sta.data + "-->");
			sta = sta.previous;
		}
		
	}
	
	public void push(int data) {
		
		StackNode newNode = new StackNode();
		newNode.data = data;

		if(sortedHead == null) {
			sortedHead = newNode;
			//print();
			return;
		}
		
		while(sortedHead != null && sortedHead.data < data){
			if(tempStack == null){
				tempStack = sortedHead;
			}else {
				tempStack.previous = sortedHead;
			}
			//System.out.println("Sorted data --> " + sortedHead.data);
			sortedHead = sortedHead.previous;
		}
		
		if(sortedHead == null){
			sortedHead = newNode;
		}else {
			newNode.previous = sortedHead;
			sortedHead = newNode;
		}
		
		//printTemp();	
		copyFromToStack(tempStack, sortedHead);
		//print();
	}
	
	public void copyFromToStack(StackNode fromStackNode, StackNode toStackNode){
		while(fromStackNode != null){
			if(toStackNode == null) {
				toStackNode = fromStackNode;
			}else{
				toStackNode.previous = fromStackNode;
			}
			fromStackNode = fromStackNode.previous;
		}
	}
	
	public void pop() {
		if(sortedHead == null) {
			return;
		}
		
		sortedHead = sortedHead.previous;
	}
	
	public int peek() {
		return sortedHead.data;
	}
	
	public boolean isEmpty(){
		return sortedHead == null;
	}

	private class StackNode {
		StackNode previous;
		int data;
	}
}