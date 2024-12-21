import java.util.Scanner;
public class Graphopia {
    public static void main(String[] args) {
        LinkedListQueue<Passenger> linkedListQueue = new LinkedListQueue<>();
        sortingPengunjung sorting = new sortingPengunjung();
        IceCreamStack iceCream = new IceCreamStack();
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        graph.addNode("Entrance");
        graph.addNode("Garden");
        graph.addNode("IceCream");
        graph.addNode("Playground");
        graph.addNode("AnimalSection");
        graph.addNode("Aquarium");
        graph.addNode("Toilet");
        graph.addNode("Exit");

        graph.addEdge("Entrance", "Garden", 10);
        graph.addEdge("Entrance", "IceCream", 5);
        graph.addEdge("Garden", "Playground", 3);
        graph.addEdge("Garden", "AnimalSection", 4);
        graph.addEdge("IceCream", "Playground", 6);
        graph.addEdge("Playground", "AnimalSection", 2);
        graph.addEdge("AnimalSection", "Aquarium", 7);
        graph.addEdge("Aquarium", "Toilet", 2);
        graph.addEdge("Toilet", "Exit", 3);
        int opsi;
        do {
            System.out.println("");
            System.out.println("====================================================================");
            System.out.println(" \r\n" + 
                                " ██████╗ ██████╗  █████╗ ██████╗ ██╗  ██╗ ██████╗ ██████╗ ██╗ █████╗     \r\n" + 
                                "██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║  ██║██╔═══██╗██╔══██╗██║██╔══██╗    \r\n" + 
                                "██║  ███╗██████╔╝███████║██████╔╝███████║██║   ██║██████╔╝██║███████║    \r\n" + 
                                "██║   ██║██╔══██╗██╔══██║██╔═══╝ ██╔══██║██║   ██║██╔═══╝ ██║██╔══██║    \r\n" + 
                                "╚██████╔╝██║  ██║██║  ██║██║     ██║  ██║╚██████╔╝██║     ██║██║  ██║    \r\n" + 
                                " ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝    \r\n" + 
                                "                                                                         \r\n" + 
                                "");
            System.out.println("====================================================================");
            System.out.println("|             *** WELCOME TO GRAPHOPIA THEME PARK ***              |");
            System.out.println("====================================================================");
            System.out.println("1. Tambahkan Pengunjung");
            System.out.println("2. Hapus Pengunjung");
            System.out.println("3. Tampilkan Daftar Pengunjung");
            System.out.println("4. Cari Nama Pengunjung ");
            System.out.println("5. Menentukan Rute");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            opsi = scanner.nextInt();
            scanner.nextLine();
        
            switch (opsi) {
                case 1: {
                    System.out.print("Masukan Nama Pengunjung : ");
                    String name = scanner.nextLine();
                    boolean isVIP = false;
                    while (true) {
                        System.out.print("Masukan Jenis Tiket (VIP/Regular) : ");
                        String vipInput = scanner.nextLine().toLowerCase();
                        if (vipInput.equalsIgnoreCase("VIP")) {
                            isVIP = true;
                            break;
                        } else if (vipInput.equalsIgnoreCase("Regular")) {
                            isVIP = false;
                            break;
                        } else {
                            System.out.println("Input tidak valid. Harap masukkan 'VIP' atau 'Regular'.");
                        }
                    }
        
                    Passenger pengunjungBaru = new Passenger(name, isVIP);
                    linkedListQueue.add(pengunjungBaru);
                    System.out.println("Pengunjung '" + name + "'' berhasil ditambahkan sebagai " + (isVIP ? "VIP" : "Regular") + "!");
                    break;
                }
                case 2: {
                    if (linkedListQueue.isEmpty()) {
                        System.out.println("Belum ada pengunjung.");
                    } else {
                        System.out.print("Masukan Nama Pengunjung yang ingin dihapus : ");
                        String nama = scanner.nextLine(); 
                        boolean found = false;
                        int size = 0;

                        Node<Passenger> current = linkedListQueue.getHead();
                        while (current != null) {
                        size++;
                        current = current.next;
                        }
                        for (int i = 0; i < size; i++) {
                            Passenger passenger = linkedListQueue.dequeue(); // Ambil elemen dari antrean
                            if (passenger.name.equalsIgnoreCase(nama) && !found) {
                                found = true;
                                System.out.println("Pengunjung dengan nama '" + nama + "' berhasil dihapus dari antrean.");
                            } else {
                                linkedListQueue.enqueue(passenger);
                            }
                        }
                        if (!found) {
                            System.out.println("Pengunjung dengan nama '" + nama + "' tidak ditemukan di antrean.");
                        }
                    }
                    break;
                }
                case 3: {
                    if (linkedListQueue.isEmpty()) {
                        System.out.println("Belum ada pengunjung.");
                    }else {
                        sorting.jenisTiket(linkedListQueue.getHead());
                        sorting.displayAntrian(linkedListQueue.getHead());
                    }
                    break;
                }
                case 4: {
                    System.out.print("Masukan Nama Pengunjung yang ingin dicari: ");
                    String nama = scanner.nextLine();
                    Node<Passenger> current = linkedListQueue.getHead();
                    boolean found = false;

                    while (current != null) {
                        if (current.data.name.equalsIgnoreCase(nama)) {
                            System.out.println("Nama ditemukan : "+ current.data.name + ", Status tiket : " + (current.data.isVIP ? "VIP" : "Regular"));
                            found = true;
                            break;
                        }
                        current = current.next;
                    }
                    if (!found) {
                        System.out.println("Pengunjung dengan nama '" + nama + "' tidak ditemukan.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("====================================================================");
                    System.out.println("|                *** RUTE GRAPHOPIA THEME PARK ***                 |");
                    System.out.println("====================================================================");
                    graph.printGraph();
                    System.out.println("====================================================================");
                    System.out.print("Enter the starting location: ");
                    String startLocation = scanner.nextLine();
                    System.out.print("Enter the destination location: ");
                    String endLocation = scanner.nextLine();

                    Graph.Node startNode = graph.findNode(startLocation);
                    boolean passesIceCream = false;
                    if (startNode != null) {
                        Graph.Edge edge = startNode.edges;
                        System.out.println("Start node ditemukan: " + startNode.name);
                        while (edge != null) {
                        if (edge.target.name.equalsIgnoreCase("IceCream")) {
                            System.out.println("Start node ditemukan: " + edge.target.name);
                        passesIceCream = true;
                        break;
                        }
                        edge = edge.next;
                        }
                    }
                    if (passesIceCream) {
                        System.out.println("\nStop!! Kita sudah sampai di Toko Ice Cream!");
                        while (true) {
                            System.out.println("\nPilih opsi:");
                            System.out.println("1. Tambah rasa");
                            System.out.println("2. Hapus rasa paling atas");
                            System.out.println("3. Lihat rasa paling atas");
                            System.out.println("4. Tampilkan semua rasa");
                            System.out.println("5. Kembali ke menu utama");
                            System.out.print("Masukkan pilihanmu: ");
                            int choice = scanner.nextInt();
                            scanner.nextLine();
                        
                            switch (choice) {
                                case 1:
                                    System.out.print("Baik, kak. Mau ice cream rasa apa? ");
                                    String flavor = scanner.nextLine();
                                    iceCream.push(flavor);
                                    break;
                                case 2:
                                    iceCream.pop();
                                    break;
                                case 3:
                                    iceCream.peek();
                                    break;
                                case 4:
                                    iceCream.displayStack();
                                    break;
                                case 5:
                                    System.out.println("Kembali ke menu utama.");
                                    break;
                                default:
                                    System.out.println("Kakak mungkin pusing ya setelah naik wahana? Tolong kasih perintah yang benar ya kak^^");
                            }
                            if (choice == 5){
                                break; // Keluar dari submenu Ice Cream
                            } else {
                                System.out.println("Opsi yang kakak berikan invalid :("); 
                            }
                        }    
                    }
                    graph.dijkstra(startLocation, endLocation);
                    break;
                }
                case 6: {
                    System.out.println("Terima kasih telah mengunjungi Graphopia Theme Park!");
                    break;
                }
                default:
                    System.out.println("Pilihan yang dimasukkan tidak valid, silakan coba lagi!");
            }
        } while (opsi != 6); 
    }        
}