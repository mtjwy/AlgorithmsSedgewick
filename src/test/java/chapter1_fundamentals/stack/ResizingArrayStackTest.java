package chapter1_fundamentals.stack;

public class ResizingArrayStackTest extends StackTest {

	@Override
	public Stack<Object> createObjectStack() {
		return new ResizingArrayStack<Object>();
	}

	@Override
	public Stack<Integer> createIntegerStack() {
		return new ResizingArrayStack<Integer>();
	}
	
	

}
