class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long MOD = 1_000_000_007;
        long[] count = new long[101];
        for (int a : arr) count[a]++;

        long ans = 0;
        for (int x = 0; x <= 100; x++) {
            for (int y = x; y <= 100; y++) {
                int z = target - x - y;
                if (z < y || z > 100) continue;   // keep x <= y <= z, valid range

                if (x == y && y == z) {
                    // C(count[x], 3)
                    ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                } else if (x == y) {
                    // C(count[x], 2) * count[z]
                    ans += count[x] * (count[x] - 1) / 2 * count[z];
                } else if (y == z) {
                    // count[x] * C(count[y], 2)
                    ans += count[x] * count[y] * (count[y] - 1) / 2;
                } else {
                    // all distinct
                    ans += count[x] * count[y] * count[z];
                }
                ans %= MOD;
            }
        }
        return (int) ans;
    }
}