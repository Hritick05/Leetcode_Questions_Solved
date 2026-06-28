class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
         // If k is 0 or 1, no positive product can be less than k
        if (k <= 1) {
            return 0;
        }

        // Left pointer of the sliding window
        int left = 0;

        // Stores the product of the current window
        int product = 1;

        // Stores the total number of valid subarrays
        int count = 0;

        // Traverse the array using the right pointer
        for (int right = 0; right < nums.length; right++) {

            // Include the current element in the window
            product *= nums[right];

            // If product becomes greater than or equal to k,
            // shrink the window from the left
            while (product >= k) {

                // Remove the leftmost element from the product
                product /= nums[left];

                // Move the left pointer forward
                left++;
            }

            // Current window [left...right] has product < k.
            //
            // Every subarray ending at 'right' is valid.
            //
            // Example:
            // Window = [5, 2, 6]
            //
            // Valid subarrays:
            // [6]
            // [2, 6]
            // [5, 2, 6]
            //
            // Number of valid subarrays:
            // right - left + 1

            count += (right - left + 1);
        }

        // Return the total number of valid subarrays
        return count;
    }
}