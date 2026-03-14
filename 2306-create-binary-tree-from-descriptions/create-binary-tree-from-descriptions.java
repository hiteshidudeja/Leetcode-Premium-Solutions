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
    public TreeNode createBinaryTree(int[][] descriptions) {
        // figure out the root 
        // create hash of all nodes based on values 
        Map<Integer, TreeNode> map = new HashMap<>();

        Set<Integer> children = new HashSet<>();

        for(int[] description : descriptions){
            int parent = description[0]; boolean isLeft = description[2] == 1; int kid = description[1];
            TreeNode node, child;
            if(!map.containsKey(parent)){
                 map.put(parent, new TreeNode(parent));
            }

            if(!map.containsKey(kid)){
                map.put(kid, new TreeNode(kid));
            }


            
            node = map.get(parent);
            child = map.get(kid);
            
            if(isLeft){
                node.left = child;
            } else {
                node.right = child;
            }

            children.add(kid);


        }



        for(TreeNode node : map.values()){
            if(!children.contains(node.val)) return node;
        }

        return null;


    }
}