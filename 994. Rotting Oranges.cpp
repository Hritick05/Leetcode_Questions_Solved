class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        queue<pair<int, int>> q;
        int fresh_count = 0;
        
        // 1. Scan grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.push({i, j});
                } else if (grid[i][j] == 1) {
                    fresh_count++;
                }
            }
        }
        
        if (fresh_count == 0) return 0;
        
        int minutes = 0;
        
        // Using your preferred direction arrays
        int deltaRow[] = {-1, 1, 0, 0};
        int deltaCol[] = {0, 0, -1, 1};
        
        // 2. BFS traversal (Level by Level)
        while (!q.empty() && fresh_count > 0) {
            int current_size = q.size(); // MUST take size to track minutes
            
            for (int i = 0; i < current_size; i++) {
                // Using your preferred pair extraction
                int row = q.front().first;
                int col = q.front().second;
                q.pop();
                
                // Check all 4 directions
                for (int d = 0; d < 4; d++) {
                    int newRow = row + deltaRow[d];
                    int newCol = col + deltaCol[d];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        fresh_count--;
                        q.push({newRow, newCol});
                    }
                }
            }
            minutes++; // 1 minute passed after processing the current batch
        }
        
        return fresh_count == 0 ? minutes : -1;
    }
};