class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if (root == nullptr) {
            return {};
        }
        
        vector<vector<int>> result;
        queue<Node*> q;
        q.push(root);
        
        while (!q.empty()) {
            int levelSize = q.size();
            vector<int> currentLevel;
            
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node* currentNode = q.front();
                q.pop();
                
                currentLevel.push_back(currentNode->val);
                
                // Enqueue all children for the next level
                for (Node* child : currentNode->children) {
                    if (child != nullptr) {
                        q.push(child);
                    }
                }
            }
            
            // Add the current level's values to the final result
            result.push_back(currentLevel);
        }
        
        return result;
    }
};