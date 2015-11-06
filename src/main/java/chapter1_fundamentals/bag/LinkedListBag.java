package chapter1_fundamentals.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class LinkedListBag<Item> implements Bag<Item>{

	private Node<Item> first;
	private int N;

	private class Node<Item> {
		Item item;
		Node<Item> next;
	}

	public LinkedListBag() {
		first = null;
		N = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void add(Item item) {

		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;

		N++;
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
