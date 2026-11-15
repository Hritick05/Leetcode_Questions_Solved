class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();

        vector<bool> visited(n,false);

        int provinces = 0;

        for(int i =0; i<n; i++){
            if(!visited[i]){
                provinces++;


                queue<int> q;
                q.push(i);
                visited[i] = true;

                while(!q.empty()){
                    int currentCity = q.front();
                    q.pop();

                    for(int neighbour = 0; neighbour < n; neighbour++){
                        if(isConnected[currentCity][neighbour]==1 && !visited[neighbour]){
                            q.push(neighbour);
                            visited[neighbour] = true;
                        }
                    }
                }
            }


        }
        return provinces;
    }
};