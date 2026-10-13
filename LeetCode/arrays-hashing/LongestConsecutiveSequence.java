import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 128. Longest Consecutive Sequence (Medium) — https://leetcode.com/problems/longest-consecutive-sequence/
 * Status: resolved. Complexity: speed O(n) / memory O(n).
 */
class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        List<Integer> intList = Arrays.stream(nums).
                boxed().
                toList();
        int maxSeq = 1;
        int counter = 1;
        for (int i = 1; i < intList.size(); i++) {
            if (intList.get(i - 1).equals(intList.get(i))) {
                // do nothing
            } else if (intList.get(i - 1) + 1 != intList.get(i)) {
                maxSeq = Math.max(maxSeq, counter);
                counter = 1;
            } else {
                counter++;
                maxSeq = Math.max(maxSeq, counter);
            }
        }
        return maxSeq;
    }
}
