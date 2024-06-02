package Controller;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.fxml.FXML;
import javafx.scene.control.*;
//@author Jesús Hernández
public class IndexController {
    @FXML
    private Label UserNa;
    
    @FXML
    private void Exit() throws IOException { System.exit(0); }
    @FXML
    private void Close (  ) throws IOException { Main.setRoot ( "Login" ); }
    @FXML
    private void initialize() {
        // Recuperar el nombre de usuario de las preferencias
        Preferences userPrefs = Preferences.userRoot().node(LoginController.class.getName());
        String loggedInUser = userPrefs.get("loggedInUser", "Usuario");
        
        // Establecer el nombre de usuario en el Label
        UserNa.setText(loggedInUser);
    }
}