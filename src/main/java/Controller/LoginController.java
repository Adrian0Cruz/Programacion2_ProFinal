package Controller;

import Model.*;
import java.io.IOException;
import java.util.logging.*;
import java.util.prefs.Preferences;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.*;

public class LoginController {
    @FXML
    private void initialize() {
        Preferences userPrefs = Preferences.userRoot().node(RegisterController.class.getName());
        boolean isNewAccount = userPrefs.getBoolean("isNewAccount", false);

        if (isNewAccount) {
            String lastRegisteredUser = userPrefs.get("lastRegisteredUser", "");
            String lastRegisteredPassword = userPrefs.get("lastRegisteredPassword", "");

            User.setText(lastRegisteredUser);
            Word.setText(lastRegisteredPassword);

            // Eliminar las preferencias después de su uso
            userPrefs.remove("isNewAccount");
            userPrefs.remove("lastRegisteredUser");
            userPrefs.remove("lastRegisteredPassword");
        }
    }
    private final UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private final List_User userList = userListSingleton.getUserList();
    Alert alert;

    @FXML
    private TextField User;
    @FXML
    private PasswordField Word;
    @FXML
    private Pane pane;

    @FXML
    private void Exit() throws IOException {
        System.exit(0);
    }

    @FXML
    private void ChangeRegister() throws IOException {
        pane.toFront();
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), pane);
        transition.setToX(450); // Ajusta este valor según la dirección y la distancia que quieras mover el panel
        transition.setOnFinished(event -> {
            try {
                Main.setRoot("Register");
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        transition.play();
    }

    @FXML
    private void Cheack() throws IOException {
        String U = User.getText();
        String Pw = Word.getText();
        if (U.isBlank()) {
            alert = new Alert(Alert.AlertType.ERROR, "El Campo Usuario Esta Vacio");
            alert.showAndWait();
            return;
        }
        if (Pw.isBlank()) {
            alert = new Alert(Alert.AlertType.ERROR, "El Campo Contraseña Esta Vacio");
            alert.showAndWait();
            return;
        }
        if (userList.Cheak(U, Pw)) {
            Preferences userPrefs = Preferences.userRoot().node(this.getClass().getName());
            userPrefs.put("loggedInUser", U);
            Main.setRoot("Index");
        } else {
            alert = new Alert(Alert.AlertType.INFORMATION, "Esa Cuenta No Existe");
            alert.showAndWait();
            return;
        }
    }

    @FXML
    private void Forget() throws IOException {}
}