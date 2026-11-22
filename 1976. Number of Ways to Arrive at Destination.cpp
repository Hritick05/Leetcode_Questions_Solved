class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        const int MOD = 1e9 + 7;
        
        // 1. Build the adjacency list: adj[u] = list of {neighbor, travel_time}
        vector<vector<pair<int, int>>> adj(n);
        for (auto& road : roads) {
            int u = road[0], v = road[1], time = road[2];
            adj[u].push_back({v, time});
            adj[v].push_back({u, time});
        }
        
        // 2. Track shortest time (dist) and number of shortest paths (ways)
        vector<long long> dist(n, LLONG_MAX);
        vector<int> ways(n, 0);
        
        // Min-heap storing {current_time, node}
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;
        
        // 3. Initialize starting intersection 0
        dist[0] = 0;
        ways[0] = 1;
        pq.push({0, 0});
        
        // 4. Run Dijkstra's Algorithm
        while (!pq.empty()) {
            auto [currTime, u] = pq.top();
            pq.pop();
            
            // Skip outdated entries in the priority queue
            if (currTime > dist[u]) continue;
            
            for (auto& [v, travelTime] : adj[u]) {
                long long newTime = currTime + travelTime;
                
                // Case A: Found a strictly shorter path to v
                if (newTime < dist[v]) {
                    dist[v] = newTime;
                    ways[v] = ways[u];
                    pq.push({newTime, v});
                }
                // Case B: Found another path to v with the exact same shortest time
                else if (newTime == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        
        // 5. Return the total number of shortest ways to reach n - 1
        return ways[n - 1];
    }
};