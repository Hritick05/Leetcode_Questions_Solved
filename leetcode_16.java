class Solution {
    public int SumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum == target) {
                    return sum;          // exact match, can't do better
                } else if (sum < target) {
                    left++;              // need a larger sum
                } else {
                    right--;             // need a smaller sum
                }
            }
        }
        return closest;
    }
}