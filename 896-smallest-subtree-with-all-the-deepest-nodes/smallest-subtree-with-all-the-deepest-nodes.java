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


 // 0
 // 1 3
 // null 2
 
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // leaves & its parent -> if there are 2 leaves
        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        q.offer(root);
        parent.put(root, null);

        List<TreeNode> last = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size(); last.clear();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                last.add(node);

                if(node.left!=null){
                    q.offer(node.left);
                    parent.put(node.left, node);
                }

                if(node.right!= null){
                    q.offer(node.right); parent.put(node.right, node);
                }
            }
        }

        Set<TreeNode> deepest = new HashSet<>(last);

        while(deepest.size() > 1){
            Set<TreeNode> next = new HashSet<>();
            for(TreeNode node : deepest){
                next.add(parent.get(node));
            }

            deepest = next;
        }

        return deepest.iterator().next();
    }
}