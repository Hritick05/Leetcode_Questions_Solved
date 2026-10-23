class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
      // Base case: If there is only 1 node, it's the root itself.
        if (n == 1) return {0};
        
        // Build the graph and track the degree of each node
        vector<vector<int>> adj(n);
        vector<int> degree(n, 0);
        
        for (const auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
            degree[u]++;
            degree[v]++;
        }
        
        // Initialize the queue with the first layer of leaves (degree == 1)
        queue<int> leaves;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.push(i);
            }
        }
        
        int remaining_nodes = n;
        
        // Run BFS to peel off leaves layer by layer
        while (remaining_nodes > 2) {
            int leaves_count = leaves.size();
            remaining_nodes -= leaves_count; // Remove current layer size from total nodes
            
            // Process all leaves in the current layer
            for (int i = 0; i < leaves_count; i++) {
                int leaf = leaves.front();
                leaves.pop();
                
                // For each neighbor of the leaf, "remove" the edge
                for (int neighbor : adj[leaf]) {
                    degree[neighbor]--;
                    
                    // If the neighbor becomes a leaf, add it to the queue for the next layer
                    if (degree[neighbor] == 1) {
                        leaves.push(neighbor);
                    }
                }
            }
        }
        
        // The remaining nodes in the queue are the center nodes (MHT roots)
        vector<int> result;
        while (!leaves.empty()) {
            result.push_back(leaves.front());
            leaves.pop();
        }
        
        return result;
    }
};