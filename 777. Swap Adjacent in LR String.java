class Solution {
    public boolean canTransform(String start, String result) {
        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            // Skip X's in both strings
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && result.charAt(j) == 'X') j++;

            // If one finished and the other didn't -> mismatch
            if (i == n || j == n) break;

            // The k-th real char must be the same in both
            if (start.charAt(i) != result.charAt(j)) return false;

            char c = start.charAt(i);

            // L can only move LEFT: start pos must be >= target pos
            if (c == 'L' && i < j) return false;

            // R can only move RIGHT: start pos must be <= target pos
            if (c == 'R' && i > j) return false;

            i++;
            j++;
        }

        // Both must have consumed all real characters (only X's left)
        while (i < n && start.charAt(i) == 'X') i++;
        while (j < n && result.charAt(j) == 'X') j++;

        return i == n && j == n;
    }
}