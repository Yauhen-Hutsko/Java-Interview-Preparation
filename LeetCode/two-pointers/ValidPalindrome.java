/**
 * LeetCode 125. Valid Palindrome (Easy) — https://leetcode.com/problems/valid-palindrome/
 * Status: resolved. Complexity: speed O(n) / memory O(1).
 */
class ValidPalindrome {

    public boolean isPalindrome(String s) {
//        IO.println(clazz.isPalindrome("A man, a plan, a canal: Panama"));
//        IO.println(clazz.isPalindrome("race a car"));
//        IO.println(clazz.isPalindrome("poop"));
//        IO.println(clazz.isPalindrome("0P"));
        String pure = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        char[] chars = pure.toCharArray();
        IO.println(pure);
        int i = 0;
        int k = chars.length - 1;
        while (i < chars.length / 2) {
            if (chars[i] != chars[k]) {
                return false;
            }
            i++;
            k--;
        }
        return true;
    }
}
