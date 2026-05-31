class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size()-1);

        int ans = 0;
        for(int i = 1; i<arrays.size(); i++){
            List<Integer> curr = arrays.get(i);

            int currMin = curr.get(0);
            int currMax = curr.get(curr.size()-1);

            ans = Math.max(ans, currMax-globalMin);
            ans = Math.max(ans, globalMax-currMin);

            globalMin = Math.min(globalMin, currMin);
            globalMax = Math.max(globalMax, currMax);
        }

        return ans;
    }
}