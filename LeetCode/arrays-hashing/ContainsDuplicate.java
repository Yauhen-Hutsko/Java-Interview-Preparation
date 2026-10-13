import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 217. Contains Duplicate (Easy) — https://leetcode.com/problems/contains-duplicate/
 * Status: resolved. Complexity: speed O(n) / memory O(n).
 */
class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (Integer i : nums) {
            if (!unique.add(i)) {
                return false;
            }
        }
        return true;
    }
}
