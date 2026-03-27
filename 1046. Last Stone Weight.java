class Solution {
    public int lastStoneWeight(int[] stones) {

      // Max Heap (largest element first)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b - a
        );
        
        // Add all stones
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        
        // Smash stones
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // largest
            int x = maxHeap.poll(); // second largest
            
            if (x != y) {
                maxHeap.add(y - x);
            }
        }
        
        // If empty return 0 else remaining stone
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();

    }
}