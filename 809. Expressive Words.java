class Solution {
    public int expressiveWords(String s, String[] words) {
        int[][] sGroups = getGroups(s); // sGroups[i] = {charAsInt, count}
        int count = 0;
        
        for (String word : words) {
            if (isStretchy(sGroups, word)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isStretchy(int[][] sGroups, String word) {
        int n = word.length();
        int i = 0;
        int groupIdx = 0;
        
        while (i < n) {
            char c = word.charAt(i);
            int j = i;
            while (j < n && word.charAt(j) == c) {
                j++;
            }
            int wl = j - i; // length of this group in word
            
            // must have a corresponding group in s
            if (groupIdx >= sGroups.length) return false;
            
            char sc = (char) sGroups[groupIdx][0];
            int sl = sGroups[groupIdx][1];
            
            if (sc != c) return false; // letter mismatch
            
            if (wl == sl) {
                // fine
            } else if (wl < sl) {
                if (sl < 3) return false; // can't stretch to less than 3
            } else {
                return false; // word group longer than s group -> impossible
            }
            
            groupIdx++;
            i = j;
        }
        
        // all groups in s must be consumed too
        return groupIdx == sGroups.length;
    }
    
    private int[][] getGroups(String s) {
        int n = s.length();
        java.util.List<int[]> groups = new java.util.ArrayList<>();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            int j = i;
            while (j < n && s.charAt(j) == c) {
                j++;
            }
            groups.add(new int[]{c, j - i});
            i = j;
        }
        return groups.toArray(new int[0][]);
    }
}