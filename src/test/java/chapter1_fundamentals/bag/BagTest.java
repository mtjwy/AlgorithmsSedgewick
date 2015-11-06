package chapter1_fundamentals.bag;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public abstract class BagTest {

	public abstract Bag<Integer> createIntegerBag();

	@Test
	public void testBagSizeAddIterator() {

		// Test that the size of empty Bag is 0.
		Bag<Integer> bag = createIntegerBag();
		assertEquals(0, bag.size());

		Integer[] nums = { 1, 2, 3, 4 };

		// Add element to the bag one by one. Test that its size is right.
		for (int i = 0; i < nums.length; i++) {
			bag.add(nums[i]);
			assertEquals(i + 1, bag.size());
		}

		// iterate bag and assert value 1 2 3 4
		int i = 0;
		for (Integer v : bag) {
			assertEquals(v, nums[i++]);
		}

	}


}
