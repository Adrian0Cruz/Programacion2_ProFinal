package com.mycompany.programacion2_profinal;

import Logic.List_User;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    List_User L2;
    
    @FXML
    private TextField User;
    @FXML
    private PasswordField Word;
    
    @FXML
    private void Exit (  ) throws IOException { System.exit ( 0 ); }
    @FXML
    private void ChangeRegister (  ) throws IOException { App.setRoot("Register"); }
    @FXML
    private void Cheack (  ) throws IOException {
        String U = User.getText (  );
        String Pw = Word.getText (  );
        if ( L2.Cheak ( U, Pw ) ) {
            System.out.println("12456");
            App.setRoot("Index");
        }
    }
}