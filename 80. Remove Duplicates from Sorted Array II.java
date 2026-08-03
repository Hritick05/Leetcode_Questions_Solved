class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;                       // write pointer
        for (int i = 0; i < nums.length; i++) {
            // Keep the first two elements unconditionally (k < 2),
            // otherwise keep only if it's not a 3rd duplicate.
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k] = nums[i];       // write the kept element
                k++;                     // advance write pointer
            }
            // else: skip nums[i] (it's a 3rd+ duplicate)
        }
        return k;
    }
}