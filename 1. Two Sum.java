class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap stores:
        // Key   -> Number
        // Value -> Index of that number
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array once
        for (int i = 0; i < nums.length; i++) {

            // Find the number required to reach the target
            int complement = target - nums[i];

            // If the required number already exists,
            // we have found the answer
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store the current number and its index
            map.put(nums[i], i);
        }

        // This line will never execute because
        // the problem guarantees exactly one solution.
        return new int[]{};
    }
}