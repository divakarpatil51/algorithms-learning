package com.stack;

public class Queue<T> {
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T data) {
		QueueNode<T> newNode =  new QueueNode<>(data, null);
		
		if(last != null){
			last.next = newNode; 
		}
		last = newNode;
		if(first == null){
			first = last;
		}
	}
	
	public void remove() throws Exception{
		if(first == null){
			throw new Exception("Empty queue");
		}
		
		first = first.next;
		if(first == null) {
			last = null;
		}
	}
	
	public T peek() throws Exception{
		if(first == null){
			throw new Exception("Empty queue");
		}
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size(){
		int size = 0;
		QueueNode<T> newfirst = first;
		while(newfirst != null){
			size++;
			newfirst = newfirst.next;
		}
		return size;
	}
	
	static class QueueNode<T> {
	
		QueueNode<T> next;
		T data;
		
		public QueueNode(T data, QueueNode<T> next){
			this.data =data;
			this.next = next;
		}
	}
}