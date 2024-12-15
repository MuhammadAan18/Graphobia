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
        System.out.println( "Okeyy, varian rasa " + flavor + " udah saya buang ya kak" );
        return flavor;
    }

    public void peek() {
        if (top == null) {
            System.out.println("Kakaknya kan belum kasih tau mau rasa apa, jadi saya masih pegangin cone nih daritadi");
            return;
        }else{
            System.out.println("Rasa paling atas " + top.flavor + " ya kak");
            return;
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

public class IceCream {
    public static void main(String[] args) {
        IceCreamStack iceCreamStack = new IceCreamStack();
        Scanner scanner = new Scanner(System.in);

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
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Baik, kak. Mau ice cream rasa apa? ");
                    String flavor = scanner.nextLine();
                    iceCreamStack.push(flavor); 
                    break;
                case 2:
                    iceCreamStack.pop();
                    break;
                case 3:
                    iceCreamStack.peek();
                    break;
                case 4:
                    iceCreamStack.displayStack();
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
}
