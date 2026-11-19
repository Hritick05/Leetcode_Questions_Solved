
class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {

        int n = graph.size();

        vector<vector<int>> adj(n);

        vector<int> outdegree(n, 0);

        queue<int> q;

        // Step 1: Build reverse graph
        for(int i = 0; i < n; i++) {

            outdegree[i] = graph[i].size();

            for(int neighbour : graph[i]) {
                adj[neighbour].push_back(i);
            }
        }

        // Step 2: Push terminal nodes into queue
        for(int i = 0; i < n; i++) {

            if(outdegree[i] == 0) {
                q.push(i);
            }
        }

        // Step 3: BFS
        vector<int> safe;

        while(!q.empty()) {

            int node = q.front();
            q.pop();

            safe.push_back(node);

            for(int neighbour : adj[node]) {

                outdegree[neighbour]--;

                if(outdegree[neighbour] == 0) {
                    q.push(neighbour);
                }
            }
        }

        // Step 4: Sort safe nodes
        sort(safe.begin(), safe.end());

        return safe;
    }
};
