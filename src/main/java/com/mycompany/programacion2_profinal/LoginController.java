package com.mycompany.programacion2_profinal;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Register");
    }
}