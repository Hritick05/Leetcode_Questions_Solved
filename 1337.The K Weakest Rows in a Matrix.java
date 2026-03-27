class Solution {

     private int countSoldiers(int[] row) {
        int count = 0;
        for (int num : row) {
            if (num == 1) count++;
            else break; // since 1s are always before 0s
        }
        return count;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        

          // Min Heap: sort by soldiers, then index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1]; // smaller index first
                }
                return a[0] - b[0]; // fewer soldiers first
            }
        );

        // Step 1: Count soldiers and add to heap
        for (int i = 0; i < mat.length; i++) {
            int soldiers = countSoldiers(mat[i]);
            minHeap.offer(new int[]{soldiers, i});
        }

        // Step 2: Extract k weakest rows
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[1];
        }

        return result;
    }
}