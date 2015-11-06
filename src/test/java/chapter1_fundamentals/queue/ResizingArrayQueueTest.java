package chapter1_fundamentals.queue;



public class ResizingArrayQueueTest extends QueueTest{

	@Override
	public Queue<Object> createObjectQueue() {
		return new ResizingArrayQueue<Object>();
	}

	@Override
	public Queue<Integer> createIntegerQueue() {
		return new ResizingArrayQueue<Integer>();
	}

}
