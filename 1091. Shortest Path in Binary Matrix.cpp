class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        
        // 1. Edge case: start or end is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        
        // 2. 8 possible directions
        int dirs[8][2] = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        
        // 3. Queue stores {row, col, current_path_length}
        queue<array<int, 3>> q;
        q.push({0, 0, 1});
        grid[0][0] = 1;  // Mark start as visited
        
        // 4. BFS loop
        while (!q.empty()) {
            auto [r, c, length] = q.front();
            q.pop();
            
            // Reached the bottom-right corner
            if (r == n - 1 && c == n - 1) {
                return length;
            }
            
            // Explore all 8 neighbors
            for (auto& d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                // Check bounds and if the cell is an unvisited 0
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;  // Mark visited immediately
                    q.push({nr, nc, length + 1});
                }
            }
        }
        
        return -1;
    }
};