package Model;
//@author Jesús Hernández
public class Item {
    private int Id;
    private String name;
    private double price;
    private int Cant;
    private double Total;
    public Item(){ }
    public Item(String name, double price, int Cant) {
        this.name = name;
        this.price = price;
        this.Cant = Cant;
        this.Total = price * Cant;
    }
    // Getters y setters
    public void setId ( int Id ) { this.Id = Id; }
    public int getId (  ) { return Id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int GetCant() { return Cant; }
    public void setCant(int Cant) { this.Cant = Cant; }
    public double GetTotal (  ) { return Total; }
    public void setTotal ( double total ) { this.Total = total; }

    @Override
    public String toString() {
        return "Item{" + "Id=" + Id + ", name=" + name + ", price=" + price +
                ", Cant=" + Cant + ", Total=" + Total + '}';
    } 
}