package chapter1_fundamentals.queue;

public interface Queue<Item> extends Iterable<Item> {
	public int size();
	public boolean isEmpty();
	public void enqueue(Item item);
	public Item dequeue();
	public Item peek();
}
