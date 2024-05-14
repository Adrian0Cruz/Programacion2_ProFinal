package com.mycompany.programacion2_profinal;

import java.io.IOException;
import javafx.fxml.FXML;

public class RegisterController {
    @FXML
    private void Exit() throws IOException {
        System.exit ( 0 );
    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("Login");
    }
}
