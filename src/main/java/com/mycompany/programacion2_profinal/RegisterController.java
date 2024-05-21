package com.mycompany.programacion2_profinal;

import Logic.List_User;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterController {
    List_User L = new List_User ( );
    
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
    private void ChangeLogin (  ) throws IOException { App.setRoot("Login"); }
    @FXML
    private void CrearCuenta (  ) throws IOException {
        String U = User.getText (  );
        String Pw = Word.getText (  );
        L.add( U, Pw );
        App.setRoot("Login");
    }
}
