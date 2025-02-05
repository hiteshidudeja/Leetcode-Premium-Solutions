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
private:
    bool solve(Node* root, Node* p, Node* q){
        if(root == NULL) return false;

        bool left = solve(root->left, p, q);
        bool right = solve(root->right, p, q);
        bool mid = root == p || root == q ? true : false;

        if(mid + left + right == 2)
            ans = root;
        
        return mid + left + right > 0;

    }
public:
    Node* ans;
    Node* lowestCommonAncestor(Node* p, Node * q) {
        // move to root
        Node* root = p;
        while(root->parent != NULL)
            root = root->parent;

        solve(root, p, q);
        return ans;
    }
};