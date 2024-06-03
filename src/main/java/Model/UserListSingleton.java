package Model;
//@author Jesús Hernández
public class UserListSingleton {
    private static UserListSingleton instance;
    private List_User userList;
    private ShoppingList ShopList;
    
    private UserListSingleton (  ) {
        userList = new List_User();
        ShopList = new ShoppingList();
    }

    public static UserListSingleton getInstance() {
        if ( instance == null ) { instance = new UserListSingleton(); }
        return instance;
    }

    public List_User getUserList (  ) { return userList; }
    public ShoppingList getShopList() { return ShopList; }
}