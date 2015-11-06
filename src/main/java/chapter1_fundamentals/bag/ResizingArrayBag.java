package chapter1_fundamentals.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayBag<Item> implements Bag<Item> {
	Item[] a;
	int N;

	public ResizingArrayBag() {
		a = (Item[]) new Object[2];
		N = 0;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public void add(Item item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = item;
	}

	private void resize(int max) {
		assert max >= N;
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {
		private int i = 0;

		public boolean hasNext() {
			return i < N;
		}

		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return a[i++];
		}
	}

}
