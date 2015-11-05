package chapter1_fundamentals.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack supported by an resizing array. 
 * use generic to make stack hold any Object. 
 * implement Iterable to support foreach() statement. 
 * 
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item>, Stack<Item> {

	private Item[] a;
	private int N;

	public ResizingArrayStack() {
		a = (Item[]) new Object[1];
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = item;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public Item pop() {
		
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		Item item = a[--N];
		a[N] = null;

		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}
	
	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return a[N - 1];
	}

	@Override
	public Iterator<Item> iterator() {

		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = N;

		@Override
		public boolean hasNext() {

			return i > 0;
		}

		@Override
		public Item next() {

			return a[--i];
		}

	}

}
