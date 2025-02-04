/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        map<int, vector<int>>map;
        vector<vector<int>>result;
        //
        if(root == NULL) return result;
        queue<pair<int, TreeNode*>>q;
        q.push({0, root});
        while(!q.empty()){
            auto [index, node] = q.front(); q.pop();
            map[index].push_back(node->val);
            if(node->left) q.push({index - 1, node->left});
            if(node->right) q.push({index + 1, node->right});
        }

        
        for(auto entry : map){
            result.push_back(entry.second);
        }

        return result;

    }
};