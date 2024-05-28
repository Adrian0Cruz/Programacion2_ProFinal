package com.mycompany.programacion2_profinal;

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
    
    /*Alert alert = new Alert ( Alert.AlertType.INFORMATION );
    alert.setTitle ( "Información" );
    alert.setHeaderText ( null );*/
    
    @FXML
    private void Exit (  ) throws IOException { System.exit ( 0 ); }
    @FXML
    private void ChangeLogin (  ) throws IOException { App.setRoot ( "Login" ); }
    @FXML
    private void CrearCuenta (  ) throws IOException {
        if (  User.getText().isBlank()  ) {
            System.out.println("crees que so bobo?");
            return;
        }
        if (  Word.getText().isBlank()  ) {
            System.out.println("crees que so bobo pol 2?");
            return;
        }
        String U = User.getText (  );
        String Pw = Word.getText (  );
        userList.add ( U, Pw );
        App.setRoot ( "Login" );
    }
}