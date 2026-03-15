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
    private StringBuilder sb;
    private void process(TreeNode root){
        if(root == null) return;
        sb.append(Integer.toString(root.val));
        if(root.left != null){
            sb.append('(');
            process(root.left); sb.append(')');
        }

        if(root.right != null){
            if(root.left == null){
                sb.append("()");
            }
            sb.append('(');
            process(root.right); sb.append(')');

        }

    }

    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        process(root);

        return sb.toString();
    }
}