class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
         // Min-heap ordered by fraction value arr[i]/arr[j]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Double.compare((double) arr[a[0]] / arr[a[1]], 
                                     (double) arr[b[0]] / arr[b[1]])
        );

        // Seed heap: for each i, the smallest fraction is arr[i]/arr[n-1]
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            minHeap.offer(new int[]{i, n - 1});
        }

        // Pop k-1 times to reach the kth smallest
        int[] result = new int[]{};
        for (int count = 0; count < k; count++) {
            int[] top = minHeap.poll();
            int i = top[0], j = top[1];
            result = new int[]{arr[i], arr[j]};

            // Push next fraction with same numerator, smaller denominator
            if (j - 1 > i) {
                minHeap.offer(new int[]{i, j - 1});
            }
        }

        return result;
    }
}