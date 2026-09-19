import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();

        // Step 1: candidate left endpoints (strictly decreasing values)
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        // Step 2: scan j from right to left
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }
        }

        return maxWidth;
    }
}