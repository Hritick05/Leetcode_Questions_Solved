class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
        // Step 1: Iterate through every number in the target range
        for (int i = left; i <= right; i++) {
            bool covered = false;
            
            // Step 2 & 3: Check if the current number 'i' is in any of the ranges
            for (const auto& range : ranges) {
                if (i >= range[0] && i <= range[1]) {
                    covered = true;
                    break; // Found the number, no need to check other ranges
                }
            }
            
            // Step 6: If 'i' was not found in any range, the whole range isn't covered
            if (!covered) {
                return false;
            }
        }
        
        // Step 7: All numbers from left to right were found
        return true;
    }
};