class Solution {
private:
    int atMost(vector<int>& nums, int k) {
        if (k <= 0) return 0;

        unordered_map<int, int> freq;
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.size(); right++) {
            // 1. Expand window by including nums[right]
            freq[nums[right]]++;

            // 2. Shrink window if distinct integers exceed k
            while (freq.size() > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    freq.erase(nums[left]);
                }
                left++;
            }

            // 3. All subarrays ending at 'right' starting from 'left..right' are valid
            count += (right - left + 1);
        }

        return count;
    }

public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
};