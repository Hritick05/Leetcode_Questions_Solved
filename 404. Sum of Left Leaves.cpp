class Solution {
public:
    int sumOfLeftLeaves(TreeNode* root) {
        if (root == nullptr) return 0;

        queue<TreeNode*> q;
        q.push(root);
        int sum = 0;

        while (!q.empty()) {
            TreeNode* node = q.front();
            q.pop();

            if (node->left) {
                // is the left child a leaf?
                if (node->left->left == nullptr && node->left->right == nullptr)
                    sum += node->left->val;
                else
                    q.push(node->left);
            }

            if (node->right) q.push(node->right);
        }

        return sum;
    }
};