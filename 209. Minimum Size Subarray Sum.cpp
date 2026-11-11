class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left = 0;
        int current_sum = 0;
        int min_length = INT_MAX;
        
        for (int right = 0; right < nums.size(); right++) {
            // Expand the window by adding the current element
            current_sum += nums[right];
            
            // Shrink the window from the left as long as the condition is met
            while (current_sum >= target) {
                // Update the minimum length found so far
                min_length = min(min_length, right - left + 1);
                
                // Remove the leftmost element from the sum and shrink the window
                current_sum -= nums[left];
                left++;
            }
        }
        
        // If min_length was never updated, return 0. Otherwise, return min_length.
        return min_length == INT_MAX ? 0 : min_length;
    }
};