class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];

        int left = 0;
        int right = 0;
        int index = 0;

        while (right < nums.length) {

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                   nums[deque.getLast()] < nums[right]) {
                deque.removeLast();
            }

            // Add current index
            deque.addLast(right);

            // Remove elements outside the window
            if (deque.getFirst() < left) {
                deque.removeFirst();
            }

            // Window has size k
            if (right + 1 >= k) {

                result[index] = nums[deque.getFirst()];
                index++;

                left++;
            }

            right++;
        }

        return result;
    }
}