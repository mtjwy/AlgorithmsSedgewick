package chapter1_fundamentals.stack;

/**
 * Write a stack client Parentheses.java that reads in sequence of left and
 * right parentheses, braces, and brackets from standard input and uses a stack
 * to determine whether the sequence is properly balanced. For example, your
 * program should print true for [()]{}{[()()]()} and false for [(]).
 * 
 *
 */
public class BalanceParentheses {
	public static boolean isBalanced(String s) {
		if (s == null) return true;
		Stack<Character> stack = new LinkedListStack<>();
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') stack.push(s.charAt(i));
			if (s.charAt(i) == '{') stack.push(s.charAt(i));
			if (s.charAt(i) == '(') stack.push(s.charAt(i));
			if (s.charAt(i) == ']') {
				if (stack.isEmpty()) return false;
				if (stack.pop() != '[') return false;
			} else if (s.charAt(i) == '}') {
				if (stack.isEmpty()) return false;
				if (stack.pop() != '{') return false;
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) return false;
				if (stack.pop() != '(') return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		assert isBalanced(null);
		assert isBalanced("");
		assert isBalanced("(") == false;
		assert isBalanced("()");
		assert isBalanced(")(") == false;
		assert isBalanced("[()]{}{[()()]()}");
		assert isBalanced("[(])") == false;
	}
}
