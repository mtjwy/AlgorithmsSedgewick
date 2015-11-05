package chapter1_fundamentals.stack;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinkedListStackTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	StackTest stackTest = new StackTest();

	@Test
	public void testStackSizePushPop() {	
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		stackTest.testStackSizePushPop(stack, exception);
	}

	@Test
	public void testStackIterator() {
		LinkedListStack<Integer> stack = new LinkedListStack<>();

		stackTest.testStackIterator(stack);
	}

}
