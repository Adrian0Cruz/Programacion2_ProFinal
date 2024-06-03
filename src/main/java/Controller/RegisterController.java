package Controller;

import Model.*;
import java.io.IOException;
import java.util.logging.*;
import java.util.prefs.Preferences;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class RegisterController {

    private final UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private final List_User userList = userListSingleton.getUserList();
    Alert alert;

    @FXML
    private TextField User;
    @FXML
    private TextField Word;
    @FXML
    private Pane pane;

    @FXML
    private void Exit() throws IOException { System.exit(0); }

    @FXML
    private void ChangeLogin() throws IOException {
        // Asegúrate de que el panel esté al frente antes de iniciar la transición
        pane.toFront();

        // Crea la transición para mover el panel
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), pane);
        transition.setToX(-450); // Ajusta este valor para que el panel se mueva completamente fuera de la vista
        transition.setOnFinished(event -> {
            try {
                Main.setRoot("Login");
            } catch (IOException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        transition.play();
    }

    @FXML
    private void CrearCuenta() throws IOException {
        String U = User.getText();
        String Pw = Word.getText();

        if (U.isBlank() || Pw.isBlank()) {
            // Mostrar un mensaje de error si los campos están vacíos
            alert = new Alert(Alert.AlertType.ERROR, "Por favor, completa todos los campos.");
            alert.showAndWait();
            return;
        }

        // Intenta agregar el usuario a la lista
        boolean isAdded = userList.AddUser(U, Pw);

        // Si el usuario ya existe, la función add devolverá false y no se continuará con la transición
        if ( !isAdded ) { return; }

        // Guardar preferencias del usuario
        Preferences userPrefs = Preferences.userRoot().node(this.getClass().getName());
        userPrefs.putBoolean("isNewAccount", true);
        userPrefs.put("lastRegisteredUser", U);
        userPrefs.put("lastRegisteredPassword", Pw);

        pane.toFront();
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), pane);
        transition.setToX(-450); // Mover el panel hacia la izquierda
        transition.setOnFinished(event -> {
            // Después de la animación, cambiar a la vista de inicio de sesión
            try {
                Main.setRoot("Login");
            } catch (IOException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        transition.play();
    }
}