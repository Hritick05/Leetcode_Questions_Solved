class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);       // odd-length centers
            count += expand(s, i, i + 1);   // even-length centers
        }
        return count;
    }

    private int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;        // found a palindrome
            left--;         // widen the window
            right++;
        }
        return count;
    }
}