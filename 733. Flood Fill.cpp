#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        
        // If the starting pixel is already the target color, do nothing to avoid an infinite loop
        if (oldColor == color) {
            return image;
        }
        
        int m = image.size();
        int n = image[0].size();
        
        // Queue to store the coordinates (row, col) of pixels to process
        queue<pair<int, int>> q;
        
        // Start by pushing the initial pixel and changing its color immediately
        q.push({sr, sc});
        image[sr][sc] = color;
        
        // Arrays to help easily traverse the 4 directions (Up, Down, Left, Right)
        int delRow[] = {-1, 1, 0, 0};
        int delCol[] = {0, 0, -1, 1};
        
        while (!q.empty()) {
            int r = q.front().first;
            int c = q.front().second;
            q.pop();
            
            // Check all 4 neighbors
            for (int i = 0; i < 4; i++) {
                int newRow = r + delRow[i];
                int newCol = c + delCol[i];
                
                // If the neighbor is within grid bounds AND matches the original color
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && image[newRow][newCol] == oldColor) {
                    // Change its color (this also acts as marking it "visited")
                    image[newRow][newCol] = color;
                    // Push it into the queue to check its neighbors later
                    q.push({newRow, newCol});
                }
            }
        }
        
        return image;
    }
};