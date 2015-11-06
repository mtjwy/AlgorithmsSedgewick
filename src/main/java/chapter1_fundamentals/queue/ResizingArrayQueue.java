package chapter1_fundamentals.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Visualize
 *                    first            last
 * 				a[. . . . . . . . . . . . . . ]
 * 
 *
 * @param <Item>
 * 
 *
 */


public class ResizingArrayQueue<Item> implements Queue<Item> {

	//TODO how to make it thread save 
	
	private Item[] a;
	private int N; // number of elements on queue
	private int first; // index of first element of queue
	private int last; // index of next available slot

	public ResizingArrayQueue() {
		a = (Item[]) new Object[2];
		N = 0;
		first = 0;
		last = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void enqueue(Item item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[last++] = item;
		if (last == a.length) {
			last = 0;
		}
		N++;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[(first + i) % a.length];// Note need to offset index to
												// match into temp[]
		}
		first = 0;
		last = N;
		a = temp;
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		Item item = a[first++];
		if (first == N) {
			first = 0;
		}
		N--;
		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}

	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		return a[first];
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item> {

		int i = 0;
		
		@Override
		public boolean hasNext() {
			
			return i < N;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = a[(first + i) % a.length];
			i++;
			return item;
		}
		
	}

}
