class Graph {
    private Node head;

    class Node {
        String name;
        Edge edges;
        Node next;
        boolean visited;
        int distance;

        Node(String name) {
            this.name = name;
            this.edges = null;
            this.next = null;
            this.visited = false;
            this.distance = Integer.MAX_VALUE;
        }
    }

    class Edge {
        Node target;
        int weight;
        Edge next;

        Edge(Node target, int weight) {
            this.target = target;
            this.weight = weight;
            this.next = null;
        }
    }

    public Graph() {
        this.head = null;
    }

    public void addNode(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = findNode(from);
        Node toNode = findNode(to);

        if (fromNode != null && toNode != null) {
            Edge newEdge = new Edge(toNode, weight);
            if (fromNode.edges == null) {
                fromNode.edges = newEdge;
            } else {
                Edge current = fromNode.edges;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newEdge;
            }

            // Add reverse edge for undirected graph
            Edge reverseEdge = new Edge(fromNode, weight);
            if (toNode.edges == null) {
                toNode.edges = reverseEdge;
            } else {
                Edge current = toNode.edges;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = reverseEdge;
            }
        }
    }

    public Node findNode(String name) {
        Node current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void dijkstra(String startName, String endName) {
        Node startNode = findNode(startName);
        Node endNode = findNode(endName);
        resetGraph();
        if (startNode == null || endNode == null) {
            System.out.println("Start or end node not found");
            return;
        }

        startNode.distance = 0;

        while (true) {
            Node smallest = null;
            Node current = head;

            while (current != null) {
                if (!current.visited && (smallest == null || current.distance < smallest.distance)) {
                    smallest = current;
                }
                current = current.next;
            }

            if (smallest == null || smallest == endNode) break;

            smallest.visited = true;

            // Check if the current node is "IceCreamStack"
            // if (smallest.name.equals("IceCream")) {
            //     System.out.println("Anda berada di Graph IceCream! Silakan pilih rasa es krim.");
            //     IceCreamStack IceCreamStackSystem = new IceCreamStack();
            //     IceCreamStackSystem.runIceCreamStackSystem();
            // }

            Edge edge = smallest.edges;
            while (edge != null) {
                Node target = edge.target;
                if (!target.visited && smallest.distance + edge.weight < target.distance) {
                    target.distance = smallest.distance + edge.weight;
                }
                edge = edge.next;
            }
        }

        if (endNode.distance == Integer.MAX_VALUE) {
            System.out.println("No path from " + startName + " to " + endName);
        } else {
            System.out.println("\nShortest distance from " + startName + " to " + endName + " is: " + endNode.distance);
        }
    }

    public void printGraph() {
        Node current = head;
        while (current != null) {
            System.out.print(current.name + " -> ");
            Edge edge = current.edges;
            while (edge != null) {
                System.out.print(edge.target.name + "(" + edge.weight + ") ");
                edge = edge.next;
            }
            System.out.println();
            current = current.next;
        }
    }
    public void resetGraph() {
        Node current = head; // Asumsikan 'head' adalah node awal dalam daftar semua node
        while (current != null) {
            current.distance = Integer.MAX_VALUE;
            current.visited = false;
            current = current.next;
        }
    }
    
}