package Model;
//@author Jesús Hernández
public class ItemNode extends Node {
    private Item item;

    public ItemNode(Item item) {
        super(); // Llama al constructor de Node
        this.item = item;
        this.Sig = this; // Inicializa Sig a sí mismo para la lista circular
        this.Ant = this; // Inicializa Ant a sí mismo para la lista circular
    }
    
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    @Override
    public String toString() { return "item=" + item; }
}