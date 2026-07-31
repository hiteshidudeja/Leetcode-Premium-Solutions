class LRUCache {

    class Node{
        int key; int val; Node prev; Node next;

        Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }

    int capacity; 
    Map<Integer, Node> map; Node head; Node tail; int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        size = 0;
        head.next = tail; tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        removeNode(node); 
        addBeforeHead(node);
        return node.val;
    }

    public void removeNode(Node node){
        Node previous = node.prev; Node next = node.next;

        previous.next = next; next.prev = previous;
    }


    public void addBeforeHead(Node node){
        Node currentRecent = head.next;

        
        head.next = node;
        node.prev = head;
        currentRecent.prev = node;
        node.next = currentRecent;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node= map.get(key);
            node.val = value;

            removeNode(node);
            addBeforeHead(node);
            return;
        }

        size++;
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addBeforeHead(newNode);

        if(size > capacity) {
            Node lruNode = tail.prev;
            removeNode(lruNode);
            map.remove(lruNode.key); size--;
        }
       
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */