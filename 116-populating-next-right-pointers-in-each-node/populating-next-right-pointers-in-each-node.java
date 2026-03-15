/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return root;
        if(root.left != null) queue.offer(root.left); if(root.right != null) queue.offer(root.right);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size - 1; i++){
                Node temp = queue.poll(); Node tempNext = queue.peek();
                temp.next = tempNext;
                if(temp.left != null) queue.offer(temp.left); if(temp.right != null) queue.offer(temp.right);
            }

            Node last = queue.poll();
            if(last.left != null) queue.offer(last.left); if(last.right != null) queue.offer(last.right);
        }

        return root;
    }
}