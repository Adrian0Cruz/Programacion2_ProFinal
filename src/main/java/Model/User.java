package Model;
//@author Jesús Hernández
//import org.apache.commons.codec.digest.DigestUtils;
public class User extends Node {
    ShoppingList shoppingList;
    FavoriteList FavoriteList;
    private String Name;
    private String PassWord;

    public User (  ) { super(); }

    public String getName (  ) { return Name; }
    public void setName ( String Name ) { this.Name = Name; }
    public String getPassWord (  ) { return PassWord; }
    public void setPassWord ( String PassWord ) { this.PassWord = PassWord; }
    
    public void addItemToShoppingList(String name, double price, int Cant) {
        Item newItem = new Item(name, price, Cant);
        shoppingList.addItem(newItem);
    }
    public void printUserShoppingList() { shoppingList.printShoppingList(); }
    public ShoppingList getShoppingList() { return shoppingList; }
    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
    
    public void addItemToFavoriteList(String name, double price, int Cant) {
        Item newItem = new Item(name, price, Cant);
        FavoriteList.addItem(newItem);
    }
    public void printUserFavoriteList() { FavoriteList.printShoppingList(); }
    public FavoriteList getFavoriteList() { return FavoriteList; }
    public void setFavoriteList(FavoriteList FavoriteList) {
        this.FavoriteList = FavoriteList;
    }
    
    public User(String Name, String PassWord ) {
        super();
        this.Name = Name;
        this.PassWord = PassWord;
        this.shoppingList = new ShoppingList();
        this.FavoriteList = new FavoriteList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(Name).append(", Contraseña: ").append(PassWord);
        // Agregar la información de la lista de compras
        if (shoppingList.head != null) {
            ItemNode current = shoppingList.head;
            do {
                Item item = current.getItem();
                sb.append("\n\tItem ID: ").append(item.getId())
                        .append(", Nombre: ").append(item.getName())
                        .append(", Precio: ").append(item.getPrice())
                        .append(", Cantidad: ").append(item.GetCant())
                        .append(", Total: ").append(item.GetTotal());
                current = (ItemNode) current.Sig;
            } while (current != shoppingList.head);
        }
        return sb.toString();
    }
}