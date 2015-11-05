package chapter1_fundamentals.queue;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class ResizingArrayQueueTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testStackSizePushPop() {
		
		//Create an empty queue. Test that its size is 0.
		ResizingArrayQueue<Object> queue = new ResizingArrayQueue<Object>();
		assertEquals(0, queue.size());
		
		//enqueue an element. Test that its size is now 1.
		Object objectA = new Object();
		queue.enqueue(objectA);
		assertEquals(1, queue.size());
		
		//enqueue another element. Test that its size is now 2.
		Object objectB = new Object();
		queue.enqueue(objectB);
		assertEquals(2, queue.size());
		
		//Dequeue an element. 
		//Test that it matches the 1st enqueued value. Check that the size of the queue is now 1.
		assertEquals(objectA, queue.dequeue());
		assertEquals(1, queue.size());
		
		//Dequeue an element from the queue. Test that it matches the 2nd enqueued value. 
		//Check that the size of the queue is 0
		assertEquals(objectB, queue.dequeue());
		assertEquals(0, queue.size());
		
		//Attempt to dequeue an element from the queue. should receive an NoSuchElementException exception.
		exception.expect(NoSuchElementException.class);
		queue.dequeue();
		
		//Attempt to peek an element from the queue. should receive an NoSuchElementException exception.
		exception.expect(NoSuchElementException.class);
		queue.peek();
		
		
	}
	
	@Test
	public void testStackIterator() {
		ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<>();
		
		//enqueue 3 values 3 2 1
		Integer[] arr = {3, 2, 1};
		for(int i = 0; i < arr.length; i++) {
			queue.enqueue(arr[i]);
		}
		
		//iterate queue and assert value 1 2 3
		int i = 0;
		for (Integer v : queue) {
			assertEquals(v, arr[i++]);
		}
	}

}
