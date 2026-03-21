class LRUCache {
     
     // hashmap for O(1) access
     // how to store info of the least recently used (ts)
     // putting and getting both are considered as used 

    class Node{
        int key, value;
        Node prev; Node next;

        Node(int k, int v){
            key = k; value = v;
        }
    }

    private int capacity;
    HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0); tail = new Node(0, 0);
        head.next = tail; tail.prev = head; 
    }

    private void moveToFront(Node node){
        remove(node); addToFront(node);
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    
    public int get(int key) {
        // 
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToFront(node); return node.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // update the map
            // update the dll
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            if(map.size() == capacity){
                // remove from tail (lru);
                Node lru = tail.prev; remove(lru);
                map.remove(lru.key);
            }

            // create new entry
            Node node = new Node(key, value);
            map.put(key, node);
            addToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */