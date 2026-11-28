class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {

        // Step 1: Create queue and parent map
        queue<TreeNode*> que;
        unordered_map<TreeNode*, TreeNode*> parent;

        parent[root] = NULL;
        que.push(root);

        // Step 2: BFS traversal
        while(!que.empty() &&
              (parent.find(p) == parent.end() ||
               parent.find(q) == parent.end())) {

            TreeNode* curr = que.front();
            que.pop();

            // Visit left child
            if(curr->left) {
                parent[curr->left] = curr;
                que.push(curr->left);
            }

            // Visit right child
            if(curr->right) {
                parent[curr->right] = curr;
                que.push(curr->right);
            }
        }

        // Step 3: Store all ancestors of p
        unordered_set<TreeNode*> ancestors;

        while(p != NULL) {
            ancestors.insert(p);
            p = parent[p];
        }

        // Step 4: Find first common ancestor of q
        while(q != NULL) {

            if(ancestors.find(q) != ancestors.end()) {
                return q;
            }

            q = parent[q];
        }

        return NULL;
    }
};
