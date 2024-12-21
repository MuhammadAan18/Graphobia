import java.util.Scanner;

class IceCreamNode {
    String flavor;
    IceCreamNode next;

    IceCreamNode(String flavor) {
        this.flavor = flavor;
        this.next = null;
    }
}

class FlavorList {
    private IceCreamNode head;

    FlavorList() {
        this.head = null;
    }

    public void addFlavor(String flavor) {
        IceCreamNode newNode = new IceCreamNode(flavor);
        if (head == null) {
            head = newNode;
        } else {
            IceCreamNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayFlavors() {
        if (head == null) {
            System.out.println("Tidak ada rasa tersedia.");
            return;
        }
        IceCreamNode current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.flavor);
            current = current.next;
            index++;
        }
    }

    public String getFlavor(int index) {
        IceCreamNode current = head;
        int count = 1;
        while (current != null) {
            if (count == index) {
                return current.flavor;
            }
            current = current.next;
            count++;
        }
        return null;
    }
}

class IceCreamStack {
    private IceCreamNode top;

    IceCreamStack() {
        this.top = null;
    }

    public void push(String flavor) {
        IceCreamNode newNode = new IceCreamNode(flavor);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println(flavor + " udah, mau rasa apa lagi kak?");
    }

    public String pop() {
        if (top == null) {
            System.out.println("Gak ada apa-apa, cuma cone doang nih. Mau dibuang juga?");
            return null;
        }
        String flavor = top.flavor;
        top = top.next;
        System.out.println("Okeyy, varian rasa " + flavor + " udah saya buang ya kak");
        return flavor;
    }

    public void peek() {
        if (top == null) {
            System.out.println("Kakaknya kan belum kasih tau mau rasa apa, jadi saya masih pegangin cone nih daritadi");
        } else {
            System.out.println("Rasa paling atas " + top.flavor + " ya kak");
        }
    }

    public void displayStack() {
        if (top == null) {
            System.out.println("Kakaknya kan belum kasih tau mau rasa apa, jadi saya masih pegangin cone nih daritadi");
            return;
        }
        System.out.println("Ini ya kak ice creamnya, varian rasanya ada:");
        IceCreamNode current = top;
        while (current != null) {
            System.out.println("- " + current.flavor);
            current = current.next;
        }
    }
}

public class IceCreamShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IceCreamStack stack = new IceCreamStack();
        FlavorList flavorList = new FlavorList();

        // Add predefined flavors to the linked list
        flavorList.addFlavor("Vanilla");
        flavorList.addFlavor("Chocolate");
        flavorList.addFlavor("Strawberry");
        flavorList.addFlavor("Mint");
        flavorList.addFlavor("Cookies and Cream");
        flavorList.addFlavor("Mango");
        flavorList.addFlavor("Pistachio");
        flavorList.addFlavor("Rocky Road");
        flavorList.addFlavor("Matcha");
        flavorList.addFlavor("Caramel");

        System.out.println("Selamat datang di Ice Cream Shop!");
        boolean running = true;

        while (running) {
            System.out.println("\nPilih menu:");
            System.out.println("1. Lihat daftar rasa");
            System.out.println("2. Tambah rasa ke cone");
            System.out.println("3. Hapus rasa dari cone");
            System.out.println("4. Lihat rasa paling atas");
            System.out.println("5. Tampilkan semua rasa di cone");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Daftar rasa yang tersedia:");
                    flavorList.displayFlavors();
                    break;
                case 2:
                    System.out.println("Pilih rasa yang ingin ditambahkan (masukkan nomor rasa):");
                    int flavorChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    String selectedFlavor = flavorList.getFlavor(flavorChoice);
                    if (selectedFlavor != null) {
                        stack.push(selectedFlavor);
                    } else {
                        System.out.println("Pilihan tidak valid!");
                    }
                    break;
                case 3:
                    stack.pop();
                    break;
                case 4:
                    stack.peek();
                    break;
                case 5:
                    stack.displayStack();
                    break;
                case 6:
                    System.out.println("Terima kasih sudah mampir di Ice Cream Shop. Sampai jumpa!");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi!");
            }
        }

        scanner.close();
    }
}
