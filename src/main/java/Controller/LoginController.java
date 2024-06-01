package Controller;

import Model.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {
private UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private List_User userList = userListSingleton.getUserList();
    Alert alert;
    
    @FXML
    private TextField User;
    @FXML
    private PasswordField Word;
    
    @FXML
    private void Exit (  ) throws IOException { System.exit ( 0 ); }
    @FXML
    private void ChangeRegister (  ) throws IOException { Main.setRoot ( "Register" ); }
    @FXML
    private void Cheack (  ) throws IOException {
        String U = User.getText (  );
        String Pw = Word.getText (  );
        if ( U.isBlank() ) {
            alert = new Alert ( Alert.AlertType.ERROR, "El Campo Usuario Esta Vacio");
            alert.showAndWait();
            return;
        }
        if ( Pw.isBlank() ) {
            alert = new Alert ( Alert.AlertType.ERROR, "El Campo Contraseña Esta Vacio");
            alert.showAndWait();
            return;
        }
        if ( userList.Cheak ( U, Pw ) ) { Main.setRoot ( "Index" ); }
    }
    @FXML
    private void Forget (  ) throws IOException {
        
    }
}