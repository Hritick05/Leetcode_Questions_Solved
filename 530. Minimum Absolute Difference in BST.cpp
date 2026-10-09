class Solution {
public:
    int getMinimumDifference(TreeNode* root) {
        vector<int> vals;
        queue<TreeNode*> q;
        q.push(root);

        // BFS: collect every node's value
        while (!q.empty()) {
            TreeNode* node = q.front();
            q.pop();
            vals.push_back(node->val);
            if (node->left)  q.push(node->left);
            if (node->right) q.push(node->right);
        }

        // Sort, then the answer is the smallest gap between neighbours
        sort(vals.begin(), vals.end());
        int ans = INT_MAX;
        for (int i = 1; i < vals.size(); i++)
            ans = min(ans, vals[i] - vals[i - 1]);

        return ans;
    }
};