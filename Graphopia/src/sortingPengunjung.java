public class sortingPengunjung {
    private Node<Passenger> head;

    public int size(Node<Passenger> head){
        int hitung = 0;
        Node<Passenger> current = head;
        while(current != null){
            hitung++;
            current = current.next;
        }
        return hitung;
    }

    public void jenisTiket(Node <Passenger> head) {
        if (head == null) {
            return;
        }
        int n = size(head);
        for (int i = 0; i < n - 1; i++) {
            Node<Passenger> current = head;
            Node<Passenger> next = current.next;

            for (int j = 0; j < n - i - 1; j++) {
                if (current != null && next != null && !current.data.isVIP && next.data.isVIP) {
                    Passenger temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                current = current.next;
                next = next.next;
            }
        }
    }

    public void displayAntrian(Node <Passenger> head){
        int no = 1;
        System.out.println("====================================================================");
        System.out.println("|            *** LIST PENGUNJUNG GRAPHOPIA THEME PARK ***          |");
        System.out.println("====================================================================");
        Node<Passenger> current = head;
        while (current != null) {
            System.out.println(no + ". " + current.data);
            current = current.next;
            no++;
        }
    }

    public Passenger searchingName(String name, Node<Passenger> head){
        Node<Passenger> current = head;
        while (current != null) {
            if (current.data.name.equals(name)) {
                return current.data;    
            }
            current = current.next;
        }
        System.out.println("Pengunjung dengan nama '" + name +"' tidak ditemukan.");
        return null;
    }
}