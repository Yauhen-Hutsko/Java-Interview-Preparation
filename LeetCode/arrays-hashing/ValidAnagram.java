import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 242. Valid Anagram (Easy) — https://leetcode.com/problems/valid-anagram/
 * Status: resolved. Complexity: speed O(2n) / memory O(n).
 */
class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        Map<Character, Integer> charCollection = new HashMap<>();
        for (char a : s.toCharArray()) {
            charCollection.put(a, charCollection.getOrDefault(a, 0) + 1);

        }
        for (char b : t.toCharArray()) {
            charCollection.put(b, charCollection.getOrDefault(b, 0) - 1);
        }

        return charCollection.values().stream().allMatch(a -> a == 0);
    }
}
