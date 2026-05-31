/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 
        List<Integer> ans = new ArrayList<>();
        Map<Integer, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.left != null) {
                parent.put(node.left.val, node);
                queue.offer(node.left);
            }

            if(node.right != null){
                parent.put(node.right.val, node); queue.offer(node.right);
            }
        }


        Map<Integer, Integer> visited = new HashMap<>();
        queue.offer(target);

        while(k > 0 && !queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll(); visited.put(node.val, 1);
                if(node.left != null && !visited.containsKey(node.left.val)){
                    queue.offer(node.left);
                }

                if(node.right != null && !visited.containsKey(node.right.val)){
                    queue.offer(node.right);
                }

                if(parent.containsKey(node.val) && !visited.containsKey(parent.get(node.val).val)){
                    queue.offer(parent.get(node.val));
                }
            }

            k--;
        }

        while(!queue.isEmpty()){
            ans.add(queue.poll().val); 
        }

        return ans;
    }
}