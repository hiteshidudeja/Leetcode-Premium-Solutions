class LFUCache {
    // least frequently used cache
    class Node{
        int key, value, freq;
        Node prev, next;
        Node(int k, int v){
            key = k; value = v; freq = 1; // initial frequency
        }
    }


    class DoublyLL{
        Node head, tail;
        int size;
        DoublyLL(){
            head = new Node(0, 0); tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        void addToFront(Node node){
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node; size++;
        }


        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev; size--;
        }

        Node removeLast(){
            if(size > 0){
                Node node = tail.prev;
                remove(node); return node;
            }

            return null;
        }
    }



    private HashMap<Integer, Node> keyToNode;
    private HashMap<Integer, DoublyLL> freqToDLL;
    private int capacity;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>(); freqToDLL = new HashMap<>();
        minFreq = 0;
    }



    private void updateFreq(Node node){
        int oldFreq = node.freq;
        node.freq++;
        
        DoublyLL ll = freqToDLL.get(oldFreq);
        ll.remove(node);

        if(oldFreq == minFreq && ll.size == 0){
            minFreq++;
        }

        freqToDLL.computeIfAbsent(node.freq, k -> new DoublyLL()).addToFront(node);
    }
    
    public int get(int key) {
        if(!keyToNode.containsKey(key)) return -1;

        Node node = keyToNode.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key); node.value = value;
            updateFreq(node);
        } else {

            if(keyToNode.size() == capacity){
                // invalidate
                DoublyLL lfru = freqToDLL.get(minFreq);
                Node removed = lfru.removeLast();
                keyToNode.remove(removed.key);
            }

            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            freqToDLL.computeIfAbsent(1, k -> new DoublyLL()).addToFront(newNode); minFreq = 1;

        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */