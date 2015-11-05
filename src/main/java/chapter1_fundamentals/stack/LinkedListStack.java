package chapter1_fundamentals.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<Item> implements Iterable<Item>, Stack<Item> {

	private Node<Item> first;
	private int N;

	private class Node<Item> {
		Item item;
		Node<Item> next;
	}

	public LinkedListStack() {
		first = null;
		N = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {

		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;

		N++;
	}

	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

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

	private class ListIterator<Item> implements Iterator<Item> {
		Node<Item> cur;

		public ListIterator(Node<Item> first) {
			cur = first;
		}

		public boolean hasNext() {
			return cur != null;
		}

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
