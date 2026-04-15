class Solution {
    public int reachNumber(int target) {
        // Step 1: Make target positive (problem is symmetric)
        // Going to -5 is same # of moves as going to +5
        target = Math.abs(target);

        int sum = 0;
        int n = 0;

        // Step 2: Keep adding moves until sum >= target
        // AND the difference (sum - target) is even
        while (true) {
            if (sum >= target && (sum - target) % 2 == 0) {
                return n;
            }
            n++;       // take the next move
            sum += n;  // move n adds n steps forward (tentatively)
        }
    }
}