class Solution {

    private int nextIndex(int[] nums, boolean forward, int current) {

        boolean direction = nums[current] > 0;

        // direction change → invalid
        if (direction != forward)
            return -1;

        int n = nums.length;

        // circular movement
        int next = ((current + nums[current]) % n + n) % n;

        // self loop → invalid
        if (next == current)
            return -1;

        return next;
    }



    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0)
                continue;

            int slow = i;
            int fast = i;

            boolean forward = nums[i] > 0;

            while (true) {

                slow = nextIndex(nums, forward, slow);
                if (slow == -1)
                    break;

                fast = nextIndex(nums, forward, fast);
                if (fast == -1)
                    break;

                fast = nextIndex(nums, forward, fast);
                if (fast == -1)
                    break;

                // cycle detected
                if (slow == fast) {

                    // self loop check
                    if (slow == nextIndex(nums, forward, slow))
                        break;

                    return true;
                }
            }

            // mark visited nodes
            slow = i;
            int val = nums[i];

           while(nums[slow] != 0 && (nums[slow] > 0) == (val > 0)){

    int next = ((slow + nums[slow]) % n + n) % n;
    nums[slow] = 0;
    slow = next;
}
        }

        return false;
    }
}