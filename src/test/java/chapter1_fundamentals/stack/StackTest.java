package chapter1_fundamentals.stack;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.rules.ExpectedException;

public class StackTest {
	
	
	public void testStackSizePushPop(Stack<Object> stack, 
			ExpectedException exception) {//accept a empty stack
		
		//Test that the size of empty Stack is 0.
		assertEquals(0, stack.size());

		// Push an element onto the stack. Test that its size is now 1.
		Object objectA = new Object();
		stack.push(objectA);
		assertEquals(1, stack.size());

		// Push another element onto the stack. Test that its size is now 2.
		Object objectB = new Object();
		stack.push(objectB);
		assertEquals(2, stack.size());

		// Pop an element from the stack.
		// Test that it matches the 2nd pushed value. Check that the size of the
		// stack is now 1.
		assertEquals(objectB, stack.pop());
		assertEquals(1, stack.size());

		// Pop an element from the stack. Test that it matches the 1st pushed
		// value.
		// Check that the size of the stack is 0
		assertEquals(objectA, stack.pop());
		assertEquals(0, stack.size());

		// Attempt to pop an element from the stack. You should receive an
		// ArrayIndexOutOfBounds exception.
		exception.expect(NoSuchElementException.class);
		stack.pop();
	}
	
	
	public void testStackIterator(Stack<Integer> stack) {//accept a empty stack
		//push 3 values onto stack 3 2 1
		Integer[] arr = {3, 2, 1};
		for(int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
		
		//iterate stack and assert value 1 2 3
		int i = 3;
		for (Integer v : stack) {
			assertEquals(v, arr[--i]);
		}
	}
}
