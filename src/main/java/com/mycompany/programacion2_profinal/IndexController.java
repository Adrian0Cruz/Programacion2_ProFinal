package com.mycompany.programacion2_profinal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//@author Jesús Hernández
public class IndexController implements Initializable {
    @FXML
    private void Exit() throws IOException { System.exit(0); }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void Close (  ) throws IOException { App.setRoot ( "Login" ); }
}