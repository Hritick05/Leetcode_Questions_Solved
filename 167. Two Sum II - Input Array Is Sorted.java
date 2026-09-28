class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-indexed
            } else if (sum > target) {
                right--;   // need smaller sum
            } else {
                left++;    // need bigger sum
            }
        }
        return new int[]{-1, -1}; // never reached (exactly one solution guaranteed)
    }
}