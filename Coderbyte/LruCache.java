import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Coderbyte — LRU Cache.
 * Given a list of accesses, simulate an LRU cache of capacity 5 and return its final content
 * from least to most recently used, joined with '-'.
 * <p>
 * Two solutions:
 * - {@link #lruCache}  — resolved, speed O(n) / memory O(1).
 * - {@link #lruCache2} — AI-resolved, speed O(n) / memory O(1).
 */
class LruCache {

    static void main(String[] args) {
       String[] arr = new String[]{"A","B","C","D","A","E","D","Z"};
       String[] arr2 = new String[]{"A","B","A","C","A","B"};
       String[] arr3 = new String[]{"A","B","C","D","E","D","Q","Z","C"};
        IO.println(lruCache2(arr));
        IO.println(lruCache2(arr2));
        IO.println(lruCache2(arr3));
    }

    static String lruCache2(String[] arr) {
        final int capacity = 5;
        Deque<String> cache = new ArrayDeque<>(capacity);
        for (String x : arr) {
            // remove() returns false on a miss -> evict the least recently used one if full
            if (!cache.remove(x) && cache.size() == capacity) {
                cache.removeFirst();
            }
            cache.addLast(x);   // most recently used goes to the tail
        }
        return String.join("-", cache);   // least -> most recently used, e.g. "E-D-Q-Z-C"
    }

    static String lruCache(String[] arr) {
        Deque<String> cache = new ArrayDeque<>(5);
        Arrays.stream(arr.clone()).iterator().forEachRemaining(
                    x->{
                        if ( cache.contains(x)) {
                            cache.removeFirstOccurrence(x);
                            cache.addLast(x);
                        } else if (cache.size() == 5 && !cache.contains(x)) {
                            cache.removeFirst();
                            cache.addLast(x);
                        } else if (cache.size() <5 && !cache.contains(x) ) {
                            cache.addLast(x);
                        }
                    });
        return cache.toString();
    }
}
