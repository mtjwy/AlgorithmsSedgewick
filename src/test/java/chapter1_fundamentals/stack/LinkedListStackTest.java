package chapter1_fundamentals.stack;



public class LinkedListStackTest extends StackTest {


	@Override
	public Stack<Object> createObjectStack() {
		return new LinkedListStack<Object>();
	}

	@Override
	public Stack<Integer> createIntegerStack() {
		return new LinkedListStack<Integer>();
	}

}
