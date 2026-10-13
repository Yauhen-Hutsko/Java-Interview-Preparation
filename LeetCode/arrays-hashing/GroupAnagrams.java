import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode 49. Group Anagrams (Medium) — https://leetcode.com/problems/group-anagrams/
 * Status: resolved. Complexity: speed O(n * k) / memory O(n * k).
 */
class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        //intuition - create a list of 'buckets'. use hashcodes of sorted arrays(not strings itself) for comparing
        List<List<String>> buckets = new ArrayList<>();
        HashMap<Integer, List<String>> groups = new HashMap<>();

        for (String str : strs) {   // calculate hash for each string.
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            int hash = Arrays.hashCode(chars);
            if (groups.containsKey(hash)) {
                groups.get(hash).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                groups.put(hash, list);
            }
        }
        buckets.addAll(groups.values());
        return buckets;
    }
}
