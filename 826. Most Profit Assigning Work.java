class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        // Step 1: bundle difficulty with its profit
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // sort jobs by difficulty (ascending)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Step 2: sort workers by ability (ascending)
        Arrays.sort(worker);

        // Step 3: sweep
        int i = 0;          // job pointer
        int best = 0;       // best profit among jobs unlocked so far
        int total = 0;      // final answer

        for (int w : worker) {
            // unlock every job this worker can do
            while (i < n && jobs[i][0] <= w) {
                best = Math.max(best, jobs[i][1]);
                i++;
            }
            // this worker takes the best job available to them
            total += best;
        }

        return total;
    }
}