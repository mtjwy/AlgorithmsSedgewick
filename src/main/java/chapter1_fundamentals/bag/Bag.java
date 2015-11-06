package chapter1_fundamentals.bag;

public interface Bag<Item> extends Iterable<Item> {
	
	public boolean isEmpty();
	public int size();
	public void add(Item item);
}
