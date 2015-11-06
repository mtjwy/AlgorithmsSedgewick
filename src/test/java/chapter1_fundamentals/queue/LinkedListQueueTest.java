package chapter1_fundamentals.queue;



public class LinkedListQueueTest extends QueueTest{

	@Override
	public Queue<Object> createObjectQueue() {
		return new LinkedListQueue<Object>();
	}

	@Override
	public Queue<Integer> createIntegerQueue() {
		return new LinkedListQueue<Integer>();
	}

	

}
