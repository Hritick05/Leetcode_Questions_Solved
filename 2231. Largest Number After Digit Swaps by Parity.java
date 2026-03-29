class Solution {
    public int largestInteger(int num) {
        
      // Max heaps
        PriorityQueue<Integer> even = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);

        // Step 1: Put digits into heaps
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit % 2 == 0) {
                even.offer(digit);
            } else {
                odd.offer(digit);
            }
            temp /= 10;
        }

        // Step 2: Rebuild number
        String s = String.valueOf(num);
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (digit % 2 == 0) {
                result.append(even.poll()); // largest even
            } else {
                result.append(odd.poll());  // largest odd
            }
        }

        return Integer.parseInt(result.toString());
    }
}