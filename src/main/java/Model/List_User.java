package Model;
//@author Jesús Hernández
import java.io.BufferedReader;
import java.io.*;
import javafx.scene.control.Alert;
public class List_User {
    private User Cab;
    public List_User() { Cab = null; }

    private boolean isEmpty() { return Cab == null; }
    private int getLength() {
        if ( isEmpty() ) return 0;
        int count = 0;
        User current = Cab;
        while (current != null) {
            count++;
            current = (User) current.Sig; // Usando Sig como en tu implementación
        }
        return count;
    }
    public User searchByName(String name) {
        User current = Cab;
        while (current != null) {
            if (name.equals(current.getName())) return current;
            current = (User) current.Sig; // Usando Sig como en tu implementación
        }
        return null;
    }
    public boolean AddUser(String name, String password) {
        if (searchByName(name) != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "El usuario '" +
                    name + "' ya existe. No se agregará.");
            alert.showAndWait();
            return false;
        }
        User newUser = new User(name, password);
        if (isEmpty()) {
            Cab = newUser;
            newUser.Sig = null; // Asumiendo que el final de la lista es null
            newUser.Ant = null; // Asumiendo que el principio de la lista es null
        } else {
            User last = Cab;
            while (last.Sig != null) {
                last = (User) last.Sig;
            }
            last.Sig = newUser;
            newUser.Ant = last; // Configurando el apuntador Anterior
            newUser.Sig = null; // Asumiendo que el final de la lista es null
        }
        saveToTxt();
        return true;
    }
    public boolean AddUser(User newUser) {
        if (searchByName(newUser.getName()) != null) {
            // Mostrar un mensaje de error si el usuario ya existe
            System.out.println("El usuario '" + newUser.getName() + "' ya existe. No se agregará.");
            return false;
        }
        if (isEmpty()) {
            Cab = newUser;
            newUser.Sig = null; // Asumiendo que el final de la lista es null
            newUser.Ant = null; // Asumiendo que el principio de la lista es null
        } else {
            User last = Cab;
            while (last.Sig != null) {
                last = (User) last.Sig;
            }
            last.Sig = newUser;
            newUser.Ant = last; // Configurando el apuntador Anterior
            newUser.Sig = null; // Asumiendo que el final de la lista es null
        }
        saveToTxt(); // Guardar la lista de usuarios en el archivo
        return true;
    }

    public boolean Cheak(String user, String password) {
        User current = Cab;
        while (current != null) {
            if (password.equals(current.getPassWord()) && user.equals(current.getName())) {
                return true;
            }
            current = (User) current.Sig; // Usando Sig como en tu implementación
        }
        return false;
    }
    public boolean SearchUser ( String Input ) {
        User B = Cab;
        while ( B != null ) {
            if ( Input.equals( B.getName (  ) ) || Input.equals ( B.getPassWord() ) ) {
                System.out.println("User: " + B.getName());
                System.out.println("PassWord: " + B.getPassWord());
            }
            B = ( User ) B.Sig;
        }
        return false;
    }
    public void saveToTxt() {
        String fileName = "Users.txt";
        try (PrintWriter writer = new PrintWriter(fileName, "UTF-8")) {
            writer.println("<ListaDeUsuarios>");
            User current = Cab;
            while (current != null) {
                writer.println("\t<Usuario>");
                writer.println("\t\tNombre: " + current.getName());
                writer.println("\t\tContraseña: " + current.getPassWord());

                // Guardar la lista de compras
                if (current.getShoppingList() != null && current.getShoppingList().head != null) {
                    writer.println("\t\t<ListaDeCompras>");
                    ItemNode itemCurrent = current.getShoppingList().head;
                    do {
                        Item item = itemCurrent.getItem();
                        writer.println("\t\t\t<Item>");
                        writer.println("\t\t\t\tId: " + item.getId());
                        writer.println("\t\t\t\tNombre: " + item.getName());
                        writer.println("\t\t\t\tPrecio: " + item.getPrice());
                        writer.println("\t\t\t\tCantidad: " + item.GetCant());
                        writer.println("\t\t\t\tTotal: " + item.GetTotal());
                        writer.println("\t\t\t</Item>");
                        itemCurrent = (ItemNode) itemCurrent.Sig;
                    } while (itemCurrent != current.getShoppingList().head);
                    writer.println("\t\t</ListaDeCompras>");
                }

                // Guardar la lista de favoritos
                if (current.getFavoriteList() != null && current.getFavoriteList().head != null) {
                    writer.println("\t\t<ListaDeFavoritos>");
                    ItemNode itemCurrent = current.getFavoriteList().head;
                    do {
                        Item item = itemCurrent.getItem();
                        writer.println("\t\t\t<Item>");
                        writer.println("\t\t\t\tId: " + item.getId());
                        writer.println("\t\t\t\tNombre: " + item.getName());
                        writer.println("\t\t\t\tPrecio: " + item.getPrice());
                        writer.println("\t\t\t\tCantidad: " + item.GetCant());
                        writer.println("\t\t\t\tTotal: " + item.GetTotal());
                        writer.println("\t\t\t</Item>");
                        itemCurrent = (ItemNode) itemCurrent.Sig;
                    } while (itemCurrent != current.getFavoriteList().head);
                    writer.println("\t\t</ListaDeFavoritos>");
                }

                // Guardar el historial de compras
                if (current.getPurchaseHistory() != null && current.getPurchaseHistory().head != null) {
                    writer.println("\t\t<HistorialDeCompras>");
                    ItemNode itemCurrent = current.getPurchaseHistory().head;
                    do {
                        Item item = itemCurrent.getItem();
                        writer.println("\t\t\t<Item>");
                        writer.println("\t\t\t\tId: " + item.getId());
                        writer.println("\t\t\t\tNombre: " + item.getName());
                        writer.println("\t\t\t\tPrecio: " + item.getPrice());
                        writer.println("\t\t\t\tCantidad: " + item.GetCant());
                        writer.println("\t\t\t\tTotal: " + item.GetTotal());
                        writer.println("\t\t\t</Item>");
                        itemCurrent = (ItemNode) itemCurrent.Sig;
                    } while (itemCurrent != current.getPurchaseHistory().head);
                    writer.println("\t\t</HistorialDeCompras>");
                }

                writer.println("\t</Usuario>");
                current = (User) current.Sig;
            }
            writer.println("</ListaDeUsuarios>");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar la información: " + e.getMessage());
        }
    }

    public void ImportFromTxt() {
        String fileName = "Users.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String name = null;
            String password = null;
            ShoppingList currentShoppingList = null;
            FavoriteList currentFavoriteList = null;
            PurchaseHistory currentPurchaseHistory = null;
            Item currentItem = null;
            boolean insideShoppingList = false;
            boolean insideFavoriteList = false;
            boolean insidePurchaseHistory = false;

            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("<Usuario>")) {
                    currentShoppingList = new ShoppingList();
                    currentFavoriteList = new FavoriteList();
                    currentPurchaseHistory = new PurchaseHistory();
                } else if (line.startsWith("\t\tNombre: ")) {
                    name = line.substring("\t\tNombre: ".length()).trim();
                } else if (line.startsWith("\t\tContraseña: ")) {
                    password = line.substring("\t\tContraseña: ".length()).trim();
                } else if (line.trim().equals("<ListaDeCompras>")) {
                    insideShoppingList = true;
                } else if (line.trim().equals("</ListaDeCompras>")) {
                    insideShoppingList = false;
                } else if (line.trim().equals("<ListaDeFavoritos>")) {
                    insideFavoriteList = true;
                } else if (line.trim().equals("</ListaDeFavoritos>")) {
                    insideFavoriteList = false;
                } else if (line.trim().equals("<HistorialDeCompras>")) {
                    insidePurchaseHistory = true;
                } else if (line.trim().equals("</HistorialDeCompras>")) {
                    insidePurchaseHistory = false;
                } else if (line.trim().startsWith("<Item>")) {
                    currentItem = new Item();
                } else if (line.trim().startsWith("</Item>")) {
                    if (insideShoppingList) {
                        currentShoppingList.addItem(currentItem);
                    } else if (insideFavoriteList) {
                        currentFavoriteList.addItem(currentItem);
                    } else if (insidePurchaseHistory) {
                        currentPurchaseHistory.addPurchase(currentItem);
                    }
                } else if (line.startsWith("\t\t\t\tId: ")) {
                    int id = Integer.parseInt(line.substring("\t\t\t\tId: ".length()).trim());
                    currentItem.setId(id);
                } else if (line.startsWith("\t\t\t\tNombre: ")) {
                    String itemName = line.substring("\t\t\t\tNombre: ".length()).trim();
                    currentItem.setName(itemName);
                } else if (line.startsWith("\t\t\t\tPrecio: ")) {
                    double itemPrice = Double.parseDouble(line.substring("\t\t\t\tPrecio: ".length()).trim());
                    currentItem.setPrice(itemPrice);
                    // Asegúrate de que la cantidad ya esté establecida antes de calcular el total
                } else if (line.startsWith("\t\t\t\tCantidad: ")) {
                    int itemQuantity = Integer.parseInt(line.substring("\t\t\t\tCantidad: ".length()).trim());
                    currentItem.setCant(itemQuantity);
                    // Ahora que tienes tanto el precio como la cantidad, calcula el total
                    currentItem.setTotal(currentItem.getPrice() * currentItem.GetCant());
                } else if (line.trim().equals("</Usuario>")) {
                    if (name != null && password != null) {
                        User newUser = new User(name, password);
                        newUser.setShoppingList(currentShoppingList);
                        newUser.setFavoriteList(currentFavoriteList);
                        newUser.setPurchaseHistory(currentPurchaseHistory);
                        this.AddUser(newUser);
                        name = null;
                        password = null;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al importar la información: " + e.getMessage());
        }
    }
}