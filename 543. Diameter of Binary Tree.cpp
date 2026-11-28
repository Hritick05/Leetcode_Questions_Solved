class Solution {
public:
    int diameterOfBinaryTree(TreeNode* root) {
        if (root == nullptr) return 0;

        // 1. Standard BFS to collect all nodes top-to-bottom
        queue<TreeNode*> q;
        vector<TreeNode*> order;
        q.push(root);

        while (!q.empty()) {
            TreeNode* curr = q.front();
            q.pop();
            order.push_back(curr);

            if (curr->left != nullptr) q.push(curr->left);
            if (curr->right != nullptr) q.push(curr->right);
        }

        // 2. Process nodes in reverse (bottom-to-top)
        unordered_map<TreeNode*, int> height;
        int maxDiameter = 0;

        for (int i = order.size() - 1; i >= 0; i--) {
            TreeNode* node = order[i];

            int leftH = (node->left != nullptr) ? height[node->left] : 0;
            int rightH = (node->right != nullptr) ? height[node->right] : 0;

            // Longest path passing through this node
            maxDiameter = max(maxDiameter, leftH + rightH);

            // Height of this subtree for its parent
            height[node] = 1 + max(leftH, rightH);
        }

        return maxDiameter;
    }
};