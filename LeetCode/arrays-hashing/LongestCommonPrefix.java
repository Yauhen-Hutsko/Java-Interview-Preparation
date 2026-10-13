/**
 * LeetCode 14. Longest Common Prefix (Easy) — https://leetcode.com/problems/longest-common-prefix/
 * Status: AI-resolved. Complexity: speed O(n * m) / memory O(1).
 */
class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String pref = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(pref)) {
                pref = pref.substring(0, pref.length() - 1);
                if (pref.isEmpty()) {
                    return "";
                }
            }
        }

        return pref;
    }
}
