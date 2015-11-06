package chapter1_fundamentals.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<Item> implements Queue<Item> {

	private class Node<Item> {
		Item item;
		Node<Item> next;
	}
	
	private Node<Item> first;
	private Node<Item> last;
	private int N;
	
	public LinkedListQueue() {
		first = null;
		last = null;
		N = 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public void enqueue(Item item) {
		if (isEmpty()) {
			first = new Node<Item>();
			first.item = item;
			last = first;
		} else {
			last.next = new Node<Item>();
			last.next.item = item;
			last = last.next;
		}
		N++;
	}

	@Override
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) {//easy to make mistake here!!!!! miss the if block
			last = null;
		}
		return item;
	}

	@Override
	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return first.item;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Item item : this) {
			sb.append(item).append(" ");
		}
		return sb.toString();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}
	
	private class ListIterator<Item> implements Iterator<Item>{
		
		Node<Item> cur;
		
		public ListIterator(Node<Item> first ) {
			cur = first;
		}

		@Override
		public boolean hasNext() {
			return cur != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = cur.item;
			cur = cur.next;
			return item;
		}
		
	}

}
