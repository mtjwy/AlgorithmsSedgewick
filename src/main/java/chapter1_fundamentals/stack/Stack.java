package chapter1_fundamentals.stack;


public interface Stack<Item> extends Iterable<Item>{
	public boolean isEmpty();
	public int size();
	public void push(Item item);
	public Item pop();
	public Item peek();
}
