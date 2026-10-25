
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find the maximum pile size
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        int answer = right;

        while (left <= right) {

            int k = left + (right - left) / 2;
            long hours = 0;

            // Calculate hours needed at speed k
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + (long) k - 1) / k;
            }

            if (hours <= h) {
                answer = k;
                right = k - 1;
            }
            else {
                left = k + 1;
            }
        }

        return answer;
    }
}
