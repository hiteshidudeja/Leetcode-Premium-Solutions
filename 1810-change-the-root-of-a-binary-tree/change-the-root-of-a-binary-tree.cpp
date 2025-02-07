/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* parent;
};
*/

class Solution {
public:
    Node* flipBinaryTree(Node* root, Node * leaf) {
        auto parent = leaf->parent;
        leaf->parent = nullptr;
        if(root == leaf) return root;
        if(leaf->left){
            leaf->right = leaf->left;
        }

        leaf->left = parent;
        if(parent){
            if(parent->left == leaf){
                parent->left = nullptr;
            }else{
                parent->right = nullptr;
            }
            flipBinaryTree(root, parent);
            parent->parent = leaf;
        }

        return leaf;
    }
};