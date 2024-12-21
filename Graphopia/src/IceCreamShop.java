import java.util.Scanner;

class IceCreamNode {
    String flavor;
    IceCreamNode next;

    IceCreamNode(String flavor) {
        this.flavor = flavor;
        this.next = null;
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

        String[] flavors = {
            "Vanilla", "Chocolate", "Strawberry", "Mint", "Cookies and Cream", 
            "Mango", "Pistachio", "Rocky Road", "Matcha", "Caramel"
        };

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
                    for (int i = 0; i < flavors.length; i++) {
                        System.out.println((i + 1) + ". " + flavors[i]);
                    }
                    break;
                case 2:
                    System.out.println("Pilih rasa yang ingin ditambahkan (1-10):");
                    int flavorChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (flavorChoice >= 1 && flavorChoice <= flavors.length) {
                        stack.push(flavors[flavorChoice - 1]);
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
