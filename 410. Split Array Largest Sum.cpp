class Solution {
public:
    // Helper: checks if we can split nums into at most k subarrays
    // such that no subarray sum exceeds maxAllowedSum
    bool canSplit(const vector<int>& nums, int k, int maxAllowedSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= maxAllowedSum) {
                currentSum += num;
            } else {
                // Start a new subarray
                subarrays++;
                currentSum = num;
            }
        }

        return subarrays <= k;
    }

    int splitArray(vector<int>& nums, int k) {
        int low = 0;
        int high = 0;

        // low = max element, high = sum of all elements
        for (int num : nums) {
            low = max(low, num);
            high += num;
        }

        // Binary search on the answer range [low, high]
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;      // mid works, try to minimize it further
            } else {
                low = mid + 1;   // mid is too small, increase the limit
            }
        }

        return low;
    }
};