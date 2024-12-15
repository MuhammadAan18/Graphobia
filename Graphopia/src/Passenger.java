class Passenger {
    String name;
    boolean isVIP;

    Passenger(String name, boolean isVIP) {
        this.name = name;
        this.isVIP = isVIP;
    }

    @Override
    public String toString() {
        return name + (isVIP ? " (VIP)" : " (Regular)");
    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}
