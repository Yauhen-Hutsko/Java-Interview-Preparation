import java.util.Stack;

/**
 * LeetCode 150. Evaluate Reverse Polish Notation (Medium) — https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Status: resolved. Complexity: speed O(n).
 */
class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int addend1;
        int addend2;

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(token);
            } else {
                addend2 = Integer.parseInt(stack.pop());
                addend1 = Integer.parseInt(stack.pop());
                if (token.equals("+")) {
                    stack.push(String.valueOf(addend1 + addend2));
                }if (token.equals("-")) {
                    stack.push(String.valueOf(addend1 - addend2));
                }if (token.equals("*")) {
                    stack.push(String.valueOf(addend1 * addend2));
                }if (token.equals("/")) {
                    stack.push(String.valueOf(addend1 / addend2));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
