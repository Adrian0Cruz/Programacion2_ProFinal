package Controller;
import Model.*;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.fxml.FXML;
import javafx.scene.control.*;
//@author Jesús Hernández
public class IndexController {
    @FXML
    private void initialize() {
        // Recuperar el nombre de usuario de las preferencias
        Preferences userPrefs = Preferences.userRoot().node ( LoginController.class.getName() );
        String loggedInUser = userPrefs.get( "loggedInUser", "Usuario" );
        // Establecer el nombre de usuario en el Label
        UserNa.setText ( loggedInUser );
    }
    private final UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private final List_User userList = userListSingleton.getUserList();
    @FXML
    private Label UserNa;
    
    @FXML
    private void Exit() throws IOException { System.exit(0); }
    @FXML
    private void Close (  ) throws IOException { Main.setRoot ( "Login" ); }
    @FXML
    private void AddProduct (  ) {
        User CurrentUser = userList.searchByName ( UserNa.getText () );
        Item item = new Item("poto" , 5, 5);
        CurrentUser.getShoppingList().addItem(item);
        
        Item item2 = new Item("suka" , 3, 50);
        CurrentUser.getFavoriteList().addItem(item2);
        
        Item item3 = new Item("monda" , 4, 20);
        CurrentUser.getPurchaseHistory().addPurchase(item3);
        CurrentUser.completePurchase();
        userList.saveToTxt();
    }
}