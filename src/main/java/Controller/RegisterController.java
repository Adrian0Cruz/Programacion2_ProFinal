package Controller;

import Model.*;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
public class RegisterController {
    private final UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private final List_User userList = userListSingleton.getUserList (  );
    Alert alert;
    
    @FXML
    private TextField User;
    @FXML
    private TextField Word;
    
    @FXML
    private void Exit (  ) throws IOException { System.exit ( 0 ); }
    @FXML
    private void ChangeLogin (  ) throws IOException { Main.setRoot ( "Login" ); }
    @FXML
    private void CrearCuenta (  ) throws IOException {
        if (  User.getText().isBlank()  ) {
            alert = new Alert ( Alert.AlertType.ERROR, "El Campo Para El Usuario Esta Vacio");
            alert.showAndWait();
            return;
        }
        if (  Word.getText().isBlank()  ) {
            alert = new Alert ( Alert.AlertType.ERROR, "El Campo Para La Contraseña Esta Vacio");
            alert.showAndWait();
            return;
        }
        String U = User.getText (  );
        String Pw = Word.getText (  );
        userList.add ( U, Pw );
        
        Preferences userPrefs = Preferences.userRoot().node(this.getClass().getName());
        userPrefs.putBoolean("isNewAccount", true);
        userPrefs.put("lastRegisteredUser", U);
        userPrefs.put("lastRegisteredPassword", Pw);
        
        Main.setRoot ( "Login" );
    }
}