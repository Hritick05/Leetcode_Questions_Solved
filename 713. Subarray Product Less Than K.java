class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

            // Edge case: if k <= 1, no subarray product can be strictly less than k
        // (since all nums are positive integers >= 1)
        if (k <= 1) return 0;

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Expand window to the right
            product *= nums[right];

            // Shrink window from the left until product < k
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // All subarrays ending at `right` and starting from
            // left, left+1, ..., right are valid → (right - left + 1) subarrays
            count += right - left + 1;
        }

        return count;

    }
}