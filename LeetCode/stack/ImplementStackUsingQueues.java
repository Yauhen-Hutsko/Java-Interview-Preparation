import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode 225. Implement Stack using Queues (Easy) — https://leetcode.com/problems/implement-stack-using-queues/
 * Status: AI-resolved. Complexity: reading O(1), writing O(n) / memory O(n).
 */
class ImplementStackUsingQueues {

    static class  MyStack {
        private Queue<Integer> queue;
        private Queue<Integer> queue2;

        public MyStack(){
            queue = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        public void push(int x) {
            queue2.offer(x);
            while (!queue.isEmpty()) {
                queue2.offer(queue.poll());
            }
            Queue<Integer> tmp = queue;
            queue = queue2;
            queue2 = tmp;
        }

        public int pop(){
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
