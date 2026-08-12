class Solution {
    public List<Integer> partitionLabels(String s) {
        // Step 1: record last index of each character
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0; // start index of current piece
        int end = 0;   // farthest reach of current piece

        // Step 2: walk through and cut when i reaches end
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1); // length of this piece
                start = i + 1;               // next piece starts after
            }
        }

        return result;
    }
}