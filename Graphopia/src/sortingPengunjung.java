public class sortingPengunjung {
    private Node<Passenger> head;

    public int size(){
        int hitung = 0;
        Node<Passenger> current = head;
        while(current != null){
            hitung++;
            current = current.next;
        }
        return hitung;
    }
    public Node<Passenger> urutanNode(int index){
        int i = 0;
        Node<Passenger> current = head;
        while (current != null) {
            if (i == index) {
                return current;
            }
            current = current.next;
            i++;
        }
        return null;
    }

    public void swap(int index1, int index2) {
        if (index1 == index2){
            return;
        } 

        Node<Passenger> node1 = urutanNode(index1);
        Node<Passenger> node2 = urutanNode(index2);

        if (node1 != null && node2 != null) {
            Passenger temp = node1.data;
            node1.data = node2.data;
            node2.data = temp;
        }
    }

    public void jenisTiket() {
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Node<Passenger> current = urutanNode(j);
                Node<Passenger> next = urutanNode(j + 1);
    
                if (current != null && next != null && !current.data.isVIP && next.data.isVIP) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void displayAntrian(Node <Passenger> head){
        int no = 1;
        System.out.println("\r\n" + //
                        "██╗     ██╗███████╗████████╗    ██████╗ ███████╗███╗   ██╗██╗   ██╗███╗   ███╗██████╗  █████╗ ███╗   ██╗ ██████╗ \r\n" + //
                        "██║     ██║██╔════╝╚══██╔══╝    ██╔══██╗██╔════╝████╗  ██║██║   ██║████╗ ████║██╔══██╗██╔══██╗████╗  ██║██╔════╝ \r\n" + //
                        "██║     ██║███████╗   ██║       ██████╔╝█████╗  ██╔██╗ ██║██║   ██║██╔████╔██║██████╔╝███████║██╔██╗ ██║██║  ███╗\r\n" + //
                        "██║     ██║╚════██║   ██║       ██╔═══╝ ██╔══╝  ██║╚██╗██║██║   ██║██║╚██╔╝██║██╔═══╝ ██╔══██║██║╚██╗██║██║   ██║\r\n" + //
                        "███████╗██║███████║   ██║       ██║     ███████╗██║ ╚████║╚██████╔╝██║ ╚═╝ ██║██║     ██║  ██║██║ ╚████║╚██████╔╝\r\n" + //
                        "╚══════╝╚═╝╚══════╝   ╚═╝       ╚═╝     ╚══════╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝     ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ \r\n" + //
                        "                                                                                                                 \r\n" + //
                        "");
        Node<Passenger> current = head;
        while (current != null) {
            System.out.println(no + ". " + current.data);
            current = current.next;
            no++;
        }
    }

    public Passenger searchingName(String name){
        Node<Passenger> current = head;
        while (current != null) {
            if (current.data.name.equalsIgnoreCase(name)) {
                System.out.println("Nama Ditemukan\n" + current.data);    
            }
            current = current.next;
        }
        return null;
    }
}