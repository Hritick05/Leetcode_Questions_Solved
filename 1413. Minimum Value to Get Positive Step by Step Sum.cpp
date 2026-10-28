class Solution {
public:
    int minStartValue(vector<int>& nums) {
        int min_prefix_sum = 0;
        int current_prefix_sum = 0;
        
        // Calculate the prefix sum step-by-step and find the lowest point
        for (int num : nums) {
            current_prefix_sum += num;
            min_prefix_sum = min(min_prefix_sum, current_prefix_sum);
        }
        
        // The start value must be enough to keep the lowest point at exactly 1
        return 1 - min_prefix_sum;
    }
};