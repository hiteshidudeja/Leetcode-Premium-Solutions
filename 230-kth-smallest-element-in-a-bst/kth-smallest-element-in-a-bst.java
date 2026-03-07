/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private void inorderTraverse(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        inorderTraverse(root.left, list);
        list.add(root.val);
        inorderTraverse(root.right, list);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        // inorder traversal array arr
        // arr[k - 1]

        ArrayList<Integer> list = new ArrayList<>();
        inorderTraverse(root, list);
        return list.get(k - 1);

    }
}