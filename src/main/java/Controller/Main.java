package Controller;
import Logic.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.layout.*;
//JavaFX Main Jesus Hernandez
public class Main extends Application {
private static Scene scene;
    @Override
    public void start ( Stage stage ) throws IOException {
        BorderPane bp = new BorderPane();
        userList.ImportUsers();
        final double[] xOffset = {0};
        final double[] yOffset = {0};
        bp.setOnMousePressed(event -> {
            xOffset[0] = event.getSceneX();
            yOffset[0] = event.getSceneY();
        });
        bp.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset[0]);
            stage.setY(event.getScreenY() - yOffset[0]);
        });
        
        scene = new Scene ( loadFXML ( "Register" ), 900, 600 );
        stage.setScene ( scene );
        stage.initStyle ( StageStyle.UNDECORATED );
        stage.show (  );
    }
    static void setRoot ( String fxml ) throws IOException {
        scene.setRoot ( loadFXML ( fxml ) );
    }
    private static Parent loadFXML ( String fxml ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader ( Main.class.getResource ( fxml + ".fxml" ) );
        return fxmlLoader.load (  );
    }
    private UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private List_User userList = userListSingleton.getUserList();
    public static void main ( String[] args ) { launch(); }
}