import java.util.HashMap;
import java.util.Stack;

/**
 * LeetCode 20. Valid Parentheses (Easy) — https://leetcode.com/problems/valid-parentheses/
 * Status: resolved. Complexity: speed O(n).
 */
class ValidParentheses {

    public static boolean isValid(String s) {
        // Input: s = "([])"
        HashMap<Character, Character> pairs = new HashMap<>();

        HashMap<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put('(', ')');
        bracketPairs.put('{', '}');
        bracketPairs.put('[', ']');
        HashMap<Character, Character> reversedBracketPairs = new HashMap<>();
        reversedBracketPairs.put(')', '(');
        reversedBracketPairs.put('}', '{');
        reversedBracketPairs.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if (s.length() % 2 == 1 || reversedBracketPairs.containsKey(chars[0])) {
            return false;
        }

        for (char c : chars) {
            if (bracketPairs.containsKey(c)) {  // if open bracket -> add to stack
                stack.push(bracketPairs.get(c));
            } else if (!stack.isEmpty() && stack.peek() == c) { // if closing bracket matches -> remove from stack
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
