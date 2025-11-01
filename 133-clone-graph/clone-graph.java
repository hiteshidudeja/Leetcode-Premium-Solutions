/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();

        Node clone = new Node(node.val);
        map.put(node, clone);
        queue.add(node);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            for(Node neighbor : temp.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                map.get(temp).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);



    }
}