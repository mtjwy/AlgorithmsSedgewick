package chapter1_fundamentals.stack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ResizingArrayStackTest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	StackTest stackTest = new StackTest();

	@Test
	public void testStackSizePushPop() {	
		ResizingArrayStack<Object> stack = new ResizingArrayStack<Object>();
		stackTest.testStackSizePushPop(stack, exception);
	}

	@Test
	public void testStackIterator() {
		ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();

		stackTest.testStackIterator(stack);
	}

}
