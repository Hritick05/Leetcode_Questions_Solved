class Solution {
    public int findLUSlength(String[] strs) {
        int result = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean isUncommon = true;

            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                // If strs[i] is a subsequence of any other string,
                // it cannot be an uncommon subsequence.
                if (isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }

            if (isUncommon) {
                result = Math.max(result, strs[i].length());
            }
        }

        return result;
    }

    // Returns true if `a` is a subsequence of `b`.
    private boolean isSubsequence(String a, String b) {
        int i = 0; // pointer into a
        for (int j = 0; i < a.length() && j < b.length(); j++) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
        }
        return i == a.length();
    }
}