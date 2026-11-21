class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from the linked list
    private void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add a node immediately after head
    private void addToFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Move a node to the front
    private void moveToFront(Node node) {

        removeNode(node);
        addToFront(node);
    }

    // Remove the least recently used node
    private Node removeLRU() {

        Node node = tail.prev;

        removeNode(node);

        return node;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        moveToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            moveToFront(node);
        }
        else {

            Node node = new Node(key, value);

            map.put(key, node);

            addToFront(node);

            if (map.size() > capacity) {

                Node removed = removeLRU();

                map.remove(removed.key);
            }
        }
    }
}