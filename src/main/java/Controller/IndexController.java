package Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//@author Jesús Hernández
public class IndexController {
    @FXML
    private void Exit() throws IOException { System.exit(0); }

    
    @FXML
    private void Close (  ) throws IOException { Main.setRoot ( "Login" ); }
}