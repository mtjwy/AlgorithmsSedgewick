package chapter1_fundamentals.queue;


public class QueueWithTwoStacksTest extends QueueTest{

	@Override
	public Queue<Object> createObjectQueue() {
		return new QueueWithTwoStacks<Object>();
	}

	@Override
	public Queue<Integer> createIntegerQueue() {
		return new QueueWithTwoStacks<Integer>();
	}

	

}
