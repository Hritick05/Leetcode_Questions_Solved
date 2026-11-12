class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
      unordered_map<int, int> prefix_map;
        
        // Base case: To handle subarrays that start from index 0 and sum to k
        prefix_map[0] = 1; 
        
        int count = 0;
        int prefix_sum = 0;

        for (int num : nums) {
            // 1. Update the running total
            prefix_sum += num;
            
            // 2. If (prefix_sum - k) exists in map, we found valid subarray(s)
            if (prefix_map.find(prefix_sum - k) != prefix_map.end()) {
                count += prefix_map[prefix_sum - k];
            }
            
            // 3. Add the current prefix_sum to the map for future lookups
            prefix_map[prefix_sum]++;
        }
        return count;
      
    }
};