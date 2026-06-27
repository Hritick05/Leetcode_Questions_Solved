class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map stores:
        // Key   -> remainder (prefixSum % k)
        // Value -> first index where this remainder appeared
        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum = 0 before the array starts (at index -1)
        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Update prefix sum
            prefixSum += nums[i];

            // Find remainder
            int remainder = prefixSum % k;

            // If same remainder appeared before
            if (map.containsKey(remainder)) {

                int previousIndex = map.get(remainder);

                // Subarray length should be at least 2
                if (i - previousIndex >= 2) {
                    return true;
                }

            } else {
                // Store only the first occurrence
                map.put(remainder, i);
            }
        }

        return false;
    }
}