class LinkedListQueue<T> {
    private Node<T> head;
    private Node<T> tail;

    public Node<T> getHead() {
        return head;
    }
    
    void enqueue(T data) { // Standard enqueue for queue
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    T dequeue() { // Standard dequeue for queue
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    void add(T data) {
        enqueue(data); // Reuse enqueue logic for adding
    }

    void addAtIndex(int index, T data) {
        if (index == 0) {
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            Node<T> current = head;
            int count = 0;
            while (current != null && count < index - 1) {
                current = current.next;
                count++;
            }
            if (current != null) {
                Node<T> newNode = new Node<>(data);
                newNode.next = current.next;
                current.next = newNode;
                if (newNode.next == null) {
                    tail = newNode;
                }
            }
        }
    }
    void swapNodes(int index1, int index2) {
        if (index1 == index2) return;

        Node<T> prev1 = null, prev2 = null, node1 = head, node2 = head;
        int count = 0;

        while (node1 != null && count < index1) {
            prev1 = node1;
            node1 = node1.next;
            count++;
        }

        count = 0;
        while (node2 != null && count < index2) {
            prev2 = node2;
            node2 = node2.next;
            count++;
        }

        if (node1 == null || node2 == null) return;

        if (prev1 != null) {
            prev1.next = node2;
        } else {
            head = node2;
        }

        if (prev2 != null) {
            prev2.next = node1;
        } else {
            head = node1;
        }

        Node<T> temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
    }
    int indexOf(T data) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Not found
    }
    boolean isEmpty() {
        return head == null;
    }

    void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}