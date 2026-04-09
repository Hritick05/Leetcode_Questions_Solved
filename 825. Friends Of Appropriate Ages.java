class Solution {
    public int numFriendRequests(int[] ages) {
       int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }

        // prefix[i] = number of people with age <= i
        int[] prefix = new int[121];
        for (int i = 1; i <= 120; i++) {
            prefix[i] = prefix[i - 1] + count[i];
        }

        int requests = 0;

        for (int x = 1; x <= 120; x++) {
            if (count[x] == 0) continue;

            int minAge = (int)(0.5 * x + 7); // y must be strictly greater than this
            // valid y range: (minAge, x] i.e. minAge+1 to x

            if (minAge >= x) continue; // no valid y exists (e.g. age 14 -> min=14, no room)

            // number of people with age in [minAge+1, x]
            int validY = prefix[x] - prefix[minAge];

            // subtract 1 to exclude sending to themselves
            requests += count[x] * (validY - 1);
        }

        return requests;
    }
}