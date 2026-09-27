class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;   // avoids overflow

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;    // uphill: peak is on the right
            } else {
                high = mid;       // downhill: peak is mid or on the left
            }
        }
        return low;   // low == high, which is the peak
    }
}