class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: find meeting point inside the cycle
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];          // 1 step
            fast = nums[nums[fast]];    // 2 steps
        } while (slow != fast);

        // Phase 2: find entrance of the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}