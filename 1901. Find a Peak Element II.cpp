class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int midCol = low + (high - low) / 2;

            // Find the row with the maximum element in midCol
            int maxRow = 0;
            for (int r = 1; r < m; r++) {
                if (mat[r][midCol] > mat[maxRow][midCol]) {
                    maxRow = r;
                }
            }

            // Get left and right neighbors (-1 if out of bounds)
            int leftVal = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int rightVal = (midCol + 1 < n) ? mat[maxRow][midCol + 1] : -1;

            // Check if current element is a peak
            if (mat[maxRow][midCol] > leftVal && mat[maxRow][midCol] > rightVal) {
                return {maxRow, midCol};
            } else if (leftVal > mat[maxRow][midCol]) {
                // Move to the left half of columns
                high = midCol - 1;
            } else {
                // Move to the right half of columns
                low = midCol + 1;
            }
        }

        return {-1, -1}; // Problem guarantees a peak always exists
    }
};