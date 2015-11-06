package chapter1_fundamentals.bag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

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

		// iterate bag and assert containing 1 2 3 4
		Set<Integer> set = new HashSet<>();
		for (Integer v : bag) {
			set.add(v);
		}
		
		for (int i = 0; i < nums.length; i++) {
			assertTrue(set.contains(nums[i]));
		}

	}


}
