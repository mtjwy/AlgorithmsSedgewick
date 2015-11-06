package chapter1_fundamentals.bag;



public class ResizingArrayBagTest extends BagTest {

	@Override
	public Bag<Integer> createIntegerBag() {
		return new ResizingArrayBag<>();
	}

	
}
