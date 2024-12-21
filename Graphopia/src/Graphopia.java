import java.util.Scanner;
public class Graphopia {
    public static void main(String[] args) {
        LinkedListQueue<Passenger> linkedListQueue = new LinkedListQueue<>();
        sortingPengunjung sorting = new sortingPengunjung();
        IceCreamStack iceCream = new IceCreamStack();
        FlavorList flavor = new FlavorList();
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        flavor.addFlavor("Vanilla");
        flavor.addFlavor("Chocolate");
        flavor.addFlavor("Strawberry");
        flavor.addFlavor("Mint");
        flavor.addFlavor("Cookies and Cream");
        flavor.addFlavor("Mango");
        flavor.addFlavor("Pistachio");
        flavor.addFlavor("Rocky Road");
        flavor.addFlavor("Matcha");
        flavor.addFlavor("Caramel");

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
                    Graph.Node endNode = graph.findNode(endLocation);
                    boolean passesIceCream = false;

                    if (startNode != null) {
                        Graph.Edge edge = startNode.edges;
                        Graph.Edge edge2 = endNode.edges;
                        while (edge != null) {
                            if (edge.target.name.equals("IceCream")|| edge2.target.name.equals("IceCream")) {
                                passesIceCream = true;
                                break;
                            }
                            edge = edge.next;
                            edge2 = edge2.next;
                        }
                    }
                    
                    if (passesIceCream) {
                        boolean validInput = false;

                        while (!validInput) {
                            System.out.println("\nAnda Menemukan Sebuah Toko Ice Cream!\nApakah Anda Ingin Membeli Ice Cream Terlebih Dahulu ?\n1. Ya\n2. Tidak");
                            System.out.print("Pilihan : ");
                            int pilih = scanner.nextInt();

                            if (pilih == 1) {
                                validInput = true;
                                boolean running = true;
                                while (running) {
                                    System.out.println("\nPilih opsi:");
                                    System.out.println("1. Lihat daftar rasa");
                                    System.out.println("2. Tambah rasa ke cone");
                                    System.out.println("3. Hapus rasa dari cone");
                                    System.out.println("4. Lihat rasa paling atas");
                                    System.out.println("5. Tampilkan semua rasa di cone");
                                    System.out.println("6. Keluar");
                                    System.out.print("Pilihan: ");
                        
                                    int choice = scanner.nextInt();
                                    scanner.nextLine();
                        
                                    switch (choice) {
                                        case 1:
                                            System.out.println("\nDaftar rasa yang tersedia:");
                                            flavor.displayFlavors();
                                            break;
                                        case 2:
                                            System.out.print("Pilih rasa yang ingin ditambahkan (masukkan nomor rasa):");
                                            int flavorChoice = scanner.nextInt();                                            
                                            scanner.nextLine();
                                            String selectedFlavor = flavor.getFlavor(flavorChoice);
                                            if (selectedFlavor != null) {
                                                iceCream.push(selectedFlavor);
                                            } else {
                                                System.out.println("Pilihan tidak valid!");
                                            }
                                            break;
                                        case 3:
                                            iceCream.pop();
                                            break;
                                        case 4:
                                            iceCream.peek();;
                                            break;
                                        case 5:
                                            iceCream.displayStack();
                                            break;
                                        case 6:
                                            System.out.println("Terima kasih sudah mampir di Ice Cream Shop. Sampai jumpa!");
                                            running = false;
                                            break;
                                        default:
                                            System.out.println("Pilihan tidak valid, coba lagi!");
                                    }
                                }
                            } else if (pilih == 2) {
                                validInput = true;
                            } else {
                                System.out.println("Pilihan yang anda berikan salah, harap masukan Pilihan '1' atau '2'. ");
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
        
        }while (opsi != 6); 
        scanner.close();
    }        
}
