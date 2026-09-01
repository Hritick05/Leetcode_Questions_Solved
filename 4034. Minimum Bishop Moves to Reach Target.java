class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int sr = source[0], sc = source[1];
        int tr = target[0], tc = target[1];

        // Case 1: different colors -> impossible
        if (((sr + sc) & 1) != ((tr + tc) & 1)) return -1;

        // Case 2: already on target
        if (sr == tr && sc == tc) return 0;

        // Case 3: same diagonal -> one move
        if (sr - sc == tr - tc || sr + sc == tr + tc) return 1;

        // Case 4: same color, different diagonals -> two moves
        return 2;
    }
}