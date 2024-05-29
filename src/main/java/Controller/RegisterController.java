package Controller;

import Logic.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterController {
private UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private List_User userList = userListSingleton.getUserList (  );
    
    @FXML
    private TextField User;
    @FXML
    private TextField Word;
    
    Alert alert = new Alert ( Alert.AlertType.INFORMATION );
    
    
    @FXML
    private void Exit (  ) throws IOException { System.exit ( 0 ); }
    @FXML
    private void ChangeLogin (  ) throws IOException { Main.setRoot ( "Login" ); }
    @FXML
    private void CrearCuenta (  ) throws IOException {
        if (  User.getText().isBlank()  ) {
            alert.setContentText("Crees que soy bobo?");
            alert.showAndWait();
            return;
        }
        if (  Word.getText().isBlank()  ) {
            alert.setContentText("Crees que soy bobo pol 2?");
            alert.showAndWait();
            return;
        }
        String U = User.getText (  );
        String Pw = Word.getText (  );
        userList.add ( U, Pw );
        Main.setRoot ( "Login" );
    }
}
