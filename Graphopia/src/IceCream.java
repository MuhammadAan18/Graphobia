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