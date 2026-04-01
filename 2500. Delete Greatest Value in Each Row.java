class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
       int m = grid.length;

        // Step 1: Create array of heaps (no comparator yet)
        PriorityQueue<Integer>[] heaps = new PriorityQueue[m];

        // Step 2: Initialize each heap as MAX heap
        for (int i = 0; i < m; i++) {

            // 🔥 Here we use (b - a)
            heaps[i] = new PriorityQueue<>((a, b) -> b - a);

            for (int val : grid[i]) {
                heaps[i].offer(val);
            }
        }

        int answer = 0;

        // Step 3: Remove largest from each row
        while (!heaps[0].isEmpty()) {

            int max = 0;

            for (int i = 0; i < m; i++) {
                int removed = heaps[i].poll(); // largest element
                max = Math.max(max, removed);
            }

            answer += max;
        }

        return answer;

    

    }
}