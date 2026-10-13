/**
 * LeetCode 26. Remove Duplicates from Sorted Array (Easy) — https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Status: resolved. Complexity: speed O(n) / memory O(1).
 */
class RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }
}
