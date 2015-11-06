package chapter1_fundamentals.bag;


public class LinkedListBagTest extends BagTest {

	@Override
	public Bag<Integer> createIntegerBag() {
		return new LinkedListBag<Integer>();
	}

	

}
