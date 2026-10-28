class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int total_sum = 0;
        int left_sum = 0;
        
        // Step 1: Calculate total sum
        for (int num : nums) {
            total_sum += num;
        }
        
        // Step 2: Traverse to find the pivot
        for (int i = 0; i < nums.size(); i++) {
            // right_sum is total_sum minus the left elements minus the current element
            int right_sum = total_sum - left_sum - nums[i];
            
            if (left_sum == right_sum) {
                return i; // Leftmost pivot found
            }
            
            // Add current element to left_sum for the next iteration
            left_sum += nums[i];
        }
        
        return -1;
    }
};