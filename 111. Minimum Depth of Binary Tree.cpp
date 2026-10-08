class Solution {
public:
    int minDepth(TreeNode* root) {
        if (root == nullptr) return 0;

        queue<TreeNode*> q;
        q.push(root);
        int depth = 1;

        while (!q.empty()) {
            int size = q.size();              // nodes on this level

            for (int i = 0; i < size; i++) {
                TreeNode* node = q.front();
                q.pop();

                // first leaf found = shortest path
                if (node->left == nullptr && node->right == nullptr) {
                    return depth;
                }

                if (node->left)  q.push(node->left);
                if (node->right) q.push(node->right);
            }
            depth++;                          // go one level deeper
        }
        return depth;                         // never reached for a valid tree
    }
};