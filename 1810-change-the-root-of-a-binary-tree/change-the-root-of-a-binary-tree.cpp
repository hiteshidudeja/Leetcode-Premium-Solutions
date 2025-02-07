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

        auto ans = leaf;

        Node* last_node = nullptr;
        while(leaf != root){
            auto parent = leaf->parent;
            leaf->parent = last_node;


            if(leaf->left){
                leaf->right = leaf->left;
            }

            leaf->left = parent;

            if(parent->left == leaf) parent->left = nullptr;
            else parent->right = nullptr;

            last_node = leaf;


            leaf = parent;
        }

        root->parent = last_node;

        return ans;




        // auto parent = leaf->parent;
        // leaf->parent = nullptr;
        // if(root == leaf) return root;
        

        // leaf->left = parent;
        // if(parent){
        //     if(parent->left == leaf){
        //         parent->left = nullptr;
        //     }else{
        //         parent->right = nullptr;
        //     }
        //     flipBinaryTree(root, parent);
        //     parent->parent = leaf;
        // }

        // return leaf;
    }
};