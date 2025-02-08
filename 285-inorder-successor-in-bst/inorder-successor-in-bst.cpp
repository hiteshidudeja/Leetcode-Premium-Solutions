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
    void inorderTraversal(TreeNode* root, vector<TreeNode*>&v){
        if(root == nullptr) return;
        inorderTraversal(root->left, v);
        v.push_back(root);
        inorderTraversal(root->right, v);
    }
public:
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        // inorder traversal

        vector<TreeNode*>v;
        inorderTraversal(root, v);
        for(int i = 0; i < v.size() - 1; i++){
            if(v[i] == p) return v[i + 1];
        }

        return nullptr;
    }
};