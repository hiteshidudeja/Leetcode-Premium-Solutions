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
    long MOD = 1000000007L;
    long ans = 0;

    private long dfs(TreeNode node){
        if(node == null) return 0;

        node.val += dfs(node.left) + dfs(node.right);

        return node.val;
    }

    public int maxProduct(TreeNode root) {
        long total = dfs(root);
        Queue<TreeNode> queue = new LinkedList<>(); queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            long subTreeSum = node.val;
            ans = Math.max(ans, (total - subTreeSum) * subTreeSum);

            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        
        return (int) (ans % MOD);

        


    }
}