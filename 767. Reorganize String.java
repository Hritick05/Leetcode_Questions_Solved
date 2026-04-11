class Solution {
    public String reorganizeString(String s) {
        // Step 1: Count character frequencies
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Max Heap — sorts by highest frequency first
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]  // Compare by frequency descending
        );

        // Step 3: Add all characters with their frequencies to the heap
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]}); // [charIndex, frequency]
            }
        }

        StringBuilder result = new StringBuilder();
        
        // Step 4: Build the result
        while (!maxHeap.isEmpty()) {
            // Always pick the most frequent character
            int[] first = maxHeap.poll();

            // If result is empty OR last char is NOT the same as current
            if (result.length() == 0 || 
                result.charAt(result.length() - 1) != (char)(first[0] + 'a')) {
                
                result.append((char)(first[0] + 'a'));
                first[1]--;  // Decrease frequency
                
                if (first[1] > 0) maxHeap.offer(first); // Re-add if still has count
                
            } else {
                // Last char == most frequent char, pick the 2nd most frequent
                if (maxHeap.isEmpty()) return ""; // No valid char available → impossible
                
                int[] second = maxHeap.poll();
                result.append((char)(second[0] + 'a'));
                second[1]--;
                
                if (second[1] > 0) maxHeap.offer(second);
                maxHeap.offer(first); // Put 'first' back
            }
        }

        return result.toString();
    }
}