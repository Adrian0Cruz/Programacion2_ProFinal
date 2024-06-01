package Controller;

import Model.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
public class RegisterController {
private UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private List_User userList = userListSingleton.getUserList (  );
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
        Main.setRoot ( "Login" );
    }
}