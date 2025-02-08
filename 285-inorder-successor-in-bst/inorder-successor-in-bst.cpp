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
public:
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        // binary search tree // iterative
        TreeNode* successor = nullptr;

        // case 1 
        if(p->right){
            successor = p->right;
            while(successor->left){
                successor = successor->left;
            }

            return successor;
        }

        // case 2
        while(root){
            if(root->val > p->val){
                successor = root;
                root = root->left;
            } else if(root->val < p->val){
                root = root->right;
            }else break;
        }

        return successor;


    }
};