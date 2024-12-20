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

        // Adding edges with weights
        graph.addEdge("Entrance", "Garden", 10);
        graph.addEdge("Entrance", "IceCream", 5);
        graph.addEdge("Garden", "IceCream", 2);
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
                    System.out.println("Pengunjung " + name + " berhasil ditambahkan sebagai " + (isVIP ? "VIP" : "Regular") + "!");
                    break;
                }
                case 2: {
                    System.out.print("Masukan Nama Pengunjung yang ingin dihapus : ");
                    String nama = scanner.nextLine();
                    String namaDihapus = nama;
                    if (nama.equals(namaDihapus)) {
                        linkedListQueue.dequeue();
                        break;
                    } else {
                        System.out.println("Input tidak valid. Harap masukkan nama yang benar.");
                    }
                }
                case 3: {
                    if (linkedListQueue.isEmpty()) {
                        System.out.println("Belum ada pengunjung.");
                    } else {
                        sorting.jenisTiket();
                        sorting.displayAntrian(linkedListQueue.getHead());
                    }
                    break;
                }
                case 4: {
                    System.out.print("Masukan Nama Pengunjung yang ingin dicari: ");
                    String nama = scanner.nextLine();
                    Passenger pencarian = sorting.searchingName(nama);
                    if (pencarian == null) {
                        System.out.println("Pengunjung dengan nama '" + nama + "' tidak ditemukan.");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Enter the starting location: ");
                    String startLocation = scanner.nextLine();
                    System.out.print("Enter the destination location: ");
                    String endLocation = scanner.nextLine();
                    System.out.println("");
                    System.out.println("Stop!! Kita sudah sampai di Toko Ice Cream!");
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
                        if (choice == 5) break; // Keluar dari submenu Ice Cream
                    }
                    graph.dijkstra(startLocation, endLocation);
                    graph.printGraph();
                    break;
                }
                case 6: {
                    System.out.println("Terima kasih telah mengunjungi Graphopia Theme Park!");
                    break;
                }
                default:
                    System.out.println("Pilihan yang dimasukkan tidak valid, silakan coba lagi!");
            }
        } while (opsi != 6); // Berhenti jika pengguna memilih opsi 6.
    }        
}