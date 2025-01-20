package Controller;
import Model.*;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
//@author Jesús Hernández
public class IndexController {
    @FXML
    private void initialize() {
        // Recuperar el nombre de usuario de las preferencias
        Preferences userPrefs = Preferences.userRoot().node ( LoginController.class.getName() );
        String loggedInUser = userPrefs.get( "loggedInUser", "Usuario" );
        // Establecer el nombre de usuario en el Label
        UserNa.setText ( loggedInUser );
        User CurrentU = userList.searchByName(loggedInUser);
        if ( CurrentU.getIsAdmin() == false ){
            PanelAdmin.setVisible( CurrentU.getIsAdmin() );
            PaneAdmin.setVisible( CurrentU.getIsAdmin() );
            PanelMenu.setLayoutY( PanelAdmin.getLayoutY() );
            PanelMenu.toFront();
        }
    }
    private final UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private final List_User userList = userListSingleton.getUserList();
    @FXML
    private Label UserNa;
    @FXML
    private Pane PanelMenu;
    @FXML
    private Pane PanelAdmin;
    @FXML
    private AnchorPane PaneAdmin;
    @FXML
    private void Exit() throws IOException { System.exit(0); }
    @FXML
    private void Close (  ) throws IOException { Main.setRoot ( "Login" ); }
    @FXML
    private Pane dashboardViewContent;
    @FXML
    private Pane adminViewContent;
    @FXML
    private void OpenAdmin (  ) {
        adminViewContent.setVisible(true);
        adminViewContent.toFront();
    }
    @FXML
    private void OpenDashBoard (  ) {
        dashboardViewContent.setVisible(true);
        dashboardViewContent.toFront();
    }
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