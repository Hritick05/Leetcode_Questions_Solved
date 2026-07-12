class Solution {
    public int[] arrayRankTransform(int[] arr) {
          int n = arr.length;
        int[] result = new int[n];
        if (n == 0) return result;
        
        // Step 1: sorted copy of the array
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        // Step 2: assign ranks to unique values in sorted order
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sorted) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }
        
        // Step 3: map original array using the rank map
        for (int i = 0; i < n; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        
        return result;
    }
}