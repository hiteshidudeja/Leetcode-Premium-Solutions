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
    private void serialise(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("null"); return;
        }

        sb.append("#" + root.val);
        serialise(root.left, sb); serialise(root.right, sb);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder sb = new StringBuilder();
        serialise(root, sb);
        String tree = sb.toString();

        sb = new StringBuilder();
        serialise(subRoot, sb);
        String subTree = sb.toString();

        return tree.indexOf(subTree) >= 0;
    }
}