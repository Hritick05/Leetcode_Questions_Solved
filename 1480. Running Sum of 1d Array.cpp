class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        // Start from index 1 since the first element remains unchanged
        for (int i = 1; i < nums.size(); i++) {
            // Add the previous running sum to the current element
            nums[i] += nums[i - 1];
        }
        
        return nums;
    }
};