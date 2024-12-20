import java.util.Scanner;
public class Graphopia {
    public static void main(String[] args) {
        LinkedListQueue<Passenger> linkedListQueue = new LinkedListQueue<>();
        sortingPengunjung sorting = new sortingPengunjung();
        IceCreamStack iceCream = new IceCreamStack();
        Scanner scanner = new Scanner(System.in);


        
        while (true) {
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
            System.out.println("2. Tampilkan Daftar Pengunjung");
            System.out.println("3. Cari Nama Pengunjung ");
            System.out.println("4. Membuat Ice Cream");
            System.out.println("5. Menentukan Rute");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");

            int opsi = scanner.nextInt();
            scanner.nextLine();

            switch (opsi) {
                case 1:{
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
                case 2:{
                    if (linkedListQueue.isEmpty()) {
                        System.out.println("Belum ada pengunjung. ");
                    }else {
                        sorting.jenisTiket();
                        sorting.displayAntrian(linkedListQueue.getHead());
                    }
                    break;
                }
                case 3: {
                    System.out.print("Masukan Nama Pengunjung yang Ingin dicari :");
                    String nama = scanner.nextLine();
                    Passenger pencarian = sorting.searchingName(nama);
                    if (pencarian == null) {
                        System.out.println("Pengunjung dengan nama '"+ nama +"' tidak ditemukan");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Selamat datang di Ice Cream Graphobia. Ada yang bisa saya bantu?");
                    while (true) {
                        System.out.println("\nPilih opsi:");
                        System.out.println("1. Tambah rasa");
                        System.out.println("2. Hapus rasa paling atas");
                        System.out.println("3. Lihat rasa paling atas");
                        System.out.println("4. Tampilkan semua rasa");
                        System.out.println("5. Keluar");
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
                                System.out.println("Terima kasih sudah membeli, silakan datang kembali!");
                                scanner.close();
                                return;
                            default:
                                System.out.println("Kakak mungkin pusing ya setelah naik wahana? Tolong kasi perintah yang benar ya kak^^");
                        }
                    }
                }
                default:
                    System.out.println("Pilihan yang dimasukan tidak valid, silahkan coba lagi!");
            }
        }
    }
}
