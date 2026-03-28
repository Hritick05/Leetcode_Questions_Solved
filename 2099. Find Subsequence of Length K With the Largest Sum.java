class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Min heap based on value
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Step 1: maintain k largest elements
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});

            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }

        // Step 2: extract elements
        int[][] arr = new int[k][2];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            arr[idx++] = minHeap.poll();
        }

        // Step 3: sort by index
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        // Step 4: build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i][0];
        }

        return result;
    }
}