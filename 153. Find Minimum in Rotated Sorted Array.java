class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;   // avoids overflow

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;   // min is strictly to the right
            } else {
                hi = mid;       // mid could be the min, keep it
            }
        }
        return nums[lo];        // lo == hi → the minimum
    }
}