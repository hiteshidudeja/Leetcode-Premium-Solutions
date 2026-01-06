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
    public int maxLevelSum(TreeNode root) {
        // bfs traversal 
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = Integer.MIN_VALUE; int level = 0; int maxLevel = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size(); int temp = 0; level += 1;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll(); temp += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);                
            }
            if(temp > sum) {
                sum = temp; maxLevel = level;
            }
        }

        return maxLevel;

    }
}