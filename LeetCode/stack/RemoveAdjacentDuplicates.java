import java.util.Stack;

/**
 * LeetCode 1047. Remove All Adjacent Duplicates In String (Easy) — https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * Status: resolved. Complexity: speed O(n) / memory O(n).
 */
class RemoveAdjacentDuplicates {

    //    it could be improved by using StringBuilder itself as a stack;
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
