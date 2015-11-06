package chapter1_fundamentals.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import chapter1_fundamentals.stack.LinkedListStack;
import chapter1_fundamentals.stack.Stack;

public class QueueWithTwoStacks<Item> implements Queue<Item>{
	Stack<Item> stack1 = new LinkedListStack<Item>();//front of queue
	Stack<Item> stack2 = new LinkedListStack<Item>();//back of queue
	
	public int size() {
		return stack1.size() + stack2.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void enqueue(Item item) {
		stack2.push(item);
	}
	
	
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (stack1.isEmpty()) {
			moveStack2ToStack1();
		}
		return stack1.pop();
	}
	
	private void moveStack2ToStack1() {
		while (!stack2.isEmpty()) {	
			stack1.push(stack2.pop());
		}
	}
	
	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (stack1.isEmpty()) {
			moveStack2ToStack1();
		}
		return stack1.peek();
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item> {

		int i = 0;
		Stack<Item> stack3;
		
		Iterator<Item> stack1Iterator;
		Iterator<Item> stack3Iterator; 
		
		public QueueIterator() {
			stack3 = new LinkedListStack<Item>();
			//copy back queue stack2 to stack3
			for(Item item : stack2) {
				stack3.push(item);
			}
			stack1Iterator = stack1.iterator();
			stack3Iterator = stack3.iterator();
		}
		
		@Override
		public boolean hasNext() {
			
			return i < size();
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (i < stack1.size()) {
				i++;
				return stack1Iterator.next();
				
			} else {
				i++;
				return stack3Iterator.next();
			}
			
		}
		
	}
	
}
