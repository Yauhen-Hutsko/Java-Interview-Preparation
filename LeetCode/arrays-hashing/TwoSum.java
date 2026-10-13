import java.util.HashMap;

/**
 * LeetCode 1. Two Sum (Easy) — https://leetcode.com/problems/two-sum/
 * Status: resolved. Complexity as noted in the original: speed O(n^2) / memory O(1)
 * (the active code is the hashmap solution; the double loop is kept commented out).
 */
class TwoSum {

    public int[] twoSumEasy(int[] nums, int target) {
        // hashmap based fast solution
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int look = target - nums[i];

            if (hashmap.containsKey(look)) {
                return new int[]{hashmap.get(look), i};
            }
            hashmap.put(nums[i], i);    // put all nums into hashmap k - num, v - index
        }
//        slow solution with double loop
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length && j!=i; j++) {
//                if (target - nums[j] == nums[i]) {
//                    return new int[]{i, j};
//                }
//            }
//        }
        return new int[2];
    }
}
