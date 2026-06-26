class Solution {
    public int subarraySum(int[] nums, int k) {
       
        // HashMap stores:
        // Key   -> Prefix Sum
        // Value -> How many times this prefix sum has appeared
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case:
        // Before processing any element, prefix sum is 0.
        // We have seen it once.
        map.put(0, 1);

        int sum = 0;     // Current prefix sum
        int count = 0;   // Number of subarrays with sum = k

        // Traverse the array
        for (int num : nums) {

            // Add current element to prefix sum
            sum += num;

            // If (sum - k) exists,
            // then a subarray ending here has sum = k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Store the current prefix sum
            // If already present, increase its frequency
            // Otherwise, insert it with frequency 1
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}