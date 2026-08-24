class Solution {
    public String pushDominoes(String dominoes) {
        // Add virtual anchors: 'L' at the far left, 'R' at the far right.
        // These never interfere with real physics but let every segment
        // between two forces be handled uniformly.
        String s = "L" + dominoes + "R";
        char[] res = s.toCharArray();

        int prev = 0; // index of the previous non-'.' character

        for (int curr = 1; curr < s.length(); curr++) {
            if (s.charAt(curr) == '.') continue; // skip dots, keep scanning

            // We found a bounded window: s[prev] ... dots ... s[curr]
            char left = s.charAt(prev);
            char right = s.charAt(curr);
            int gap = curr - prev - 1; // number of dots between them

            if (left == right) {
                // Same direction: every dot falls that way
                for (int k = prev + 1; k < curr; k++) {
                    res[k] = left;
                }
            } else if (left == 'R' && right == 'L') {
                // Falling toward each other: fill from both ends
                int lo = prev + 1, hi = curr - 1;
                while (lo < hi) {
                    res[lo] = 'R';
                    res[hi] = 'L';
                    lo++;
                    hi--;
                }
                // if lo == hi, middle domino stays '.' (balanced)
            }
            // else: left == 'L' && right == 'R' -> dots stay '.', do nothing

            prev = curr; // move window forward
        }

        // Strip the two virtual anchors we added
        return new String(res, 1, res.length - 2);
    }
}