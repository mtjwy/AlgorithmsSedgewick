package chapter1_fundamentals.queue;

/**
 * In the Josephus problem from antiquity, N people are in dire straits and
 * agree to the following strategy to reduce the population. They arrange
 * themselves in a circle (at positions numbered from 0 to N-1) and proceed
 * around the circle, eliminating every Mth person until only one person is
 * left. Legend has it that Josephus figured out where to sit to avoid being
 * eliminated. Write a Queue client Josephus.java that takes M and N from the
 * command line and prints out the order in which people are eliminated (and
 * thus would show Josephus where to sit in the circle).
 * 
 *
 */
public class JosephusProblem {
	public static void printEleminateOrder(int n, int m) {
		Queue<Integer> queue = new LinkedListQueue<>();
		for (int i = 0; i < n; i++) {
			queue.enqueue(i);
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < m - 1; i++) {
				queue.enqueue(queue.dequeue());
			}
			System.out.print(queue.dequeue() + " ");
		}
	}
	
	public static void main(String[] args) {
		printEleminateOrder(5, 1);
		System.out.println();
		printEleminateOrder(7, 2);
		System.out.println();
		printEleminateOrder(20, 5);
	}
}
