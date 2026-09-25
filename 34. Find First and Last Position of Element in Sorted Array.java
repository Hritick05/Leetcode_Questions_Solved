class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target, true);
        int last  = binarySearch(nums, target, false);
        return new int[]{first, last};
    }

    private int binarySearch(int[] nums, int target, boolean findFirst) {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;   // avoids integer overflow

            if (nums[mid] == target) {
                ans = mid;                      // record, don't stop
                if (findFirst) high = mid - 1;  // hunt further left
                else           low  = mid + 1;  // hunt further right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}