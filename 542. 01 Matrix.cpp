#include <vector>
#include <queue>
#include <climits>

using namespace std;

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        
        // Initialize the distance matrix with INT_MAX to represent unvisited cells
        vector<vector<int>> dist(m, vector<int>(n, INT_MAX));
        queue<pair<int, int>> q;
        
        // Step 1 & 2: Push all 0s into the queue and set their distance to 0
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.push({i, j});
                }
            }
        }
        
        // Directions for moving: Up, Down, Left, Right
        int dirX[] = {-1, 1, 0, 0};
        int dirY[] = {0, 0, -1, 1};
        
        // Step 3: Multi-source BFS
        while (!q.empty()) {
            auto [r, c] = q.front();
            q.pop();
            
            // Check all 4 adjacent neighbors
            for (int i = 0; i < 4; ++i) {
                int newR = r + dirX[i];
                int newC = c + dirY[i];
                
                // Ensure the neighbor is within the matrix bounds
                if (newR >= 0 && newR < m && newC >= 0 && newC < n) {
                    // If we found a strictly shorter path to this neighbor
                    if (dist[newR][newC] > dist[r][c] + 1) {
                        dist[newR][newC] = dist[r][c] + 1;
                        q.push({newR, newC}); // Add to queue for further exploration
                    }
                }
            }
        }
        
        return dist;
    }
};