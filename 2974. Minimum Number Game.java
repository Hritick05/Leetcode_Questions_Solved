class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.offer(num);
        }

        int [] arr = new int[nums.length];
        int i = 0;

        while(!minHeap.isEmpty()){
            int a = minHeap.poll();
            int b = minHeap.poll();

            arr[i++] = b;
            arr[i++] = a;
        }
        return arr;
    }

}