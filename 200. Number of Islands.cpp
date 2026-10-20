class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
      
        if (grid.empty()) {
            return 0;
        }
        
        int islandCount = 0;
        int rows = grid.size();
        int cols = grid[0].size();
        
        // Direction arrays to easily check Up, Down, Left, and Right
        int dRow[] = {-1, 1, 0, 0};
        int dCol[] = {0, 0, -1, 1};
        
        // Scan every cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                
                // When we find a '1', we've found a new island
                if (grid[r][c] == '1') {
                    islandCount++;
                    
                    // Start BFS to explore and sink the entire island
                    queue<pair<int, int>> q;
                    q.push({r, c});
                    grid[r][c] = '0'; // Sink it immediately so it isn't added to queue twice
                    
                    // Process the queue until the whole island is explored
                    while (!q.empty()) {
                        int curr_r = q.front().first;
                        int curr_c = q.front().second;
                        q.pop();
                        
                        // Check all 4 adjacent directions
                        for (int i = 0; i < 4; i++) {
                            int new_r = curr_r + dRow[i];
                            int new_c = curr_c + dCol[i];
                            
                            // If neighbor is within bounds and is land ('1')
                            if (new_r >= 0 && new_r < rows && new_c >= 0 && new_c < cols && grid[new_r][new_c] == '1') {
                                q.push({new_r, new_c});
                                grid[new_r][new_c] = '0'; // Sink it immediately
                            }
                        }
                    }
                }
            }
        }
        
        return islandCount;
        }
    };