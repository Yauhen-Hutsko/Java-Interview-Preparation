/**
 * LeetCode 167. Two Sum II - Input Array Is Sorted (Medium) — https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Two solutions:
 * - {@link #twoSum}  — resolved (but very slow), nested loops, speed O(n^2).
 * - {@link #twoSum2} — AI-resolved, two pointers, speed O(n) / memory O(1).
 */
class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
//        Input: numbers = [2,3,4], target = 6
//        Output: [1,3]
        int[] answer = new int[2]; //create array size of 2 for output
        int left = 0;

        for (; left < numbers.length; left++) {
            for (int right = left + 1; right < numbers.length; right++) {
                if (target - numbers[right] == numbers[left]) {
                    answer[0] = ++left;
                    answer[1] = ++right;
                    return answer; // stop immediately when find the answer
                }

            }
        }
        return answer;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[2];
    }
}
