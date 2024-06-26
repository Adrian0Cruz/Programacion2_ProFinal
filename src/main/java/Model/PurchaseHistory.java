package Model;
//@author Jesús Hernández
public class PurchaseHistory {
    ItemNode head;
    private int contadorId; // Contador para los IDs de los ítems

    public PurchaseHistory() {
        this.head = null;
        this.contadorId = 0;
    }

    public void addPurchase(Item item) {
        item.setId(++contadorId); // Asigna un nuevo ID al ítem
        ItemNode newNode = new ItemNode(item);
        if (head == null) {
            head = newNode;
            head.Sig = head; // Apunta a sí mismo para formar un círculo
            head.Ant = head; // Apunta a sí mismo para formar un círculo
        } else {
            // Enlazar el nuevo nodo con el head y el último nodo
            newNode.Sig = head;
            newNode.Ant = head.Ant;
            head.Ant.Sig = newNode;
            head.Ant = newNode;
        }
    }

    public void printPurchaseHistory() {
        if (head != null) {
            ItemNode current = head;
            do {
                System.out.println(current.getItem());
                current = (ItemNode) current.Sig;
            } while (current != head); // Continúa hasta que se regrese al head
        }
    }
}