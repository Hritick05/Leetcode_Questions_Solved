class Solution {
    public int findPairs(int[] nums, int k) {
         
        // Case 1: k cannot be negative
        if (k < 0) return 0;

        // Step 1: store frequency of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        // Step 2: check for valid pairs
        for (int num : map.keySet()) {
            
            if (k == 0) {
                // Need at least 2 same numbers
                if (map.get(num) >= 2) {
                    count++;
                }
            } else {
                // Check if num + k exists
                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}