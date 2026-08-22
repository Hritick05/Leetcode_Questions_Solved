class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int longest = 0;
        int i = 1;
        while (i < n - 1) {
            // Check if i is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                // Expand left while strictly increasing
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }
                int right = i + 1;
                // Expand right while strictly decreasing
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                longest = Math.max(longest, right - left + 1);
                // Jump i to the end of this mountain (skips redundant work)
                i = right;
            } else {
                i++;
            }
        }
        return longest;
    }
}