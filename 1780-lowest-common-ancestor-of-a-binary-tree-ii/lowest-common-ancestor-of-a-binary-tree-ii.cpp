/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
private:
    bool solve(TreeNode* root, TreeNode* p, TreeNode* q){
        if(root == NULL) return false;
        bool left = solve(root->left, p, q);
        bool right = solve(root->right, p, q);
        bool mid = root == p || root == q ? true : false;

        if(mid + left + right == 2)
            ans = root;
        
        return mid + left + right;
    }
public:
    TreeNode* ans = NULL; bool left; bool right; bool mid;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
         solve(root,  p, q);
         return ans;
    }
};