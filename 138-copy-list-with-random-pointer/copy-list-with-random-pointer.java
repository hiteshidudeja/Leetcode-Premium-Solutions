/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        if(head == null) return head;
        map.put(head, new Node(head.val));

        Node temp = head;
        while(temp != null){

            Node current = map.get(temp);

            if(temp.next != null){
                if(map.containsKey(temp.next)){
                    current.next = map.get(temp.next);
                }
                else {
                     Node created = new Node(temp.next.val);
                    map.put(temp.next, created);
                    current.next = created;
                }
            
            }
            
            if(temp.random != null){
                if (map.containsKey(temp.random)){
                    current.random = map.get(temp.random);
                } else {

                    Node random = new Node(temp.random.val);
                    map.put(temp.random, random);
                    current.random = random;
                }
            } 

            temp = temp.next;
        }

        return map.get(head);
    }
}