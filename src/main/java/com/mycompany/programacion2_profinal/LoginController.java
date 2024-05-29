package com.mycompany.programacion2_profinal;

import Logic.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private List_User userList = userListSingleton.getUserList();
    
    @FXML
    private TextField User;
    @FXML
    private PasswordField Word;
    
    @FXML
    private void Exit (  ) throws IOException { System.exit ( 0 ); }
    @FXML
    private void ChangeRegister (  ) throws IOException { App.setRoot ( "Register" ); }
    @FXML
    private void Cheack (  ) throws IOException {
        String U = User.getText (  );
        String Pw = Word.getText (  );
        if ( userList.Cheak ( U, Pw ) ) { App.setRoot ( "Index" ); }
    }
    @FXML
    private void Forget (  ) throws IOException {
        
    }
}