#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        queue<pair<int, int>> q;
        
        // Step 1: Add all boundary '1's to the queue and change them to '0'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we are on the edge of the grid
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (grid[i][j] == 1) {
                        q.push({i, j});
                        grid[i][j] = 0; // Mark as visited by turning to water
                    }
                }
            }
        }
        
        // Direction arrays to easily move up, down, left, and right
        int deltaRow[] = {-1, 1, 0, 0};
        int deltaCol[] = {0, 0, -1, 1};
        
        // Step 2: BFS traversal to "sink" all connected land
        while (!q.empty()) {
            int row = q.front().first;
            int col = q.front().second;
            q.pop();
            
            // Check all 4 adjacent directions
            for (int i = 0; i < 4; i++) {
                int nRow = row + deltaRow[i];
                int nCol = col + deltaCol[i];
                
                // If the neighbor is within grid limits and is a land cell
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1) {
                    q.push({nRow, nCol});
                    grid[nRow][nCol] = 0; // Sink it
                }
            }
        }
        
        // Step 3: Count the completely enclosed enclaves
        int enclavesCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    enclavesCount++;
                }
            }
        }
        
        return enclavesCount;
    }
};