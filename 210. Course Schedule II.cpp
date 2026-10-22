class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(numCourses);
       vector<int> indegree(numCourses, 0);

       for(const auto& pre : prerequisites ){
        int course = pre[0];
        int prereq = pre[1];
        graph[prereq].push_back(course);
        indegree[course]++;
       }

       queue<int>q;
       for(int i  =0; i<numCourses; i++){
         if(indegree[i] == 0){
            q.push(i);
         }
       }
       vector<int> ans;

       int completedCourses = 0;

       while(!q.empty()){
        int current = q.front();
        q.pop();
        ans.push_back(current); // Course taken

        for(int neighbors : graph[current]){
            indegree[neighbors]--;
            if(indegree[neighbors]==0){
                q.push(neighbors);
            }
        }
       }
      if (ans.size() == numCourses) {
            return ans;
        }
        return {};
    }
};