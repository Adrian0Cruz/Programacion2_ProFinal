package Controller;
import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import java.io.IOException;
import static javafx.application.Application.launch;
//JavaFX Main Jesus Hernandez
public class Main extends Application {
    private static double xOffset = 0;
    private static double yOffset = 0;
    private static Scene scene;
    @Override
    public void start ( Stage stage ) throws IOException {
        userList.ImportFromTxt();
        // Cargar la vista inicial
        Parent root = loadFXML("Register");
        // Crear una nueva escena con la vista cargada
        scene = new Scene(root); //el tamaño es 900, 600. se puedo poner como parametro
        
        scene.setOnMousePressed ( event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        } );
        scene.setOnMouseDragged ( event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        } );

        // Establecer la escena en el escenario y mostrar
        stage.setScene ( scene );
        stage.initStyle ( StageStyle.UNDECORATED );
        stage.show();
    }
    static void setRoot ( String fxml ) throws IOException {
        Parent root = loadFXML ( fxml );
        // Aplicar eventos de arrastre a la nueva vista cargada
        root.setOnMousePressed( event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        } );
        root.setOnMouseDragged ( event -> {
            Stage stage = ( Stage ) scene.getWindow();
            stage.setX ( event.getScreenX() - xOffset );
            stage.setY ( event.getScreenY() - yOffset );
        } );
        scene.setRoot ( root );
    }
    private static Parent loadFXML ( String fxml ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader ( Main.class.getResource ( fxml + ".fxml" ) );
        return fxmlLoader.load();
    }
    private final UserListSingleton userListSingleton = UserListSingleton.getInstance();
    private final List_User userList = userListSingleton.getUserList();
    public static void main ( String[] args ) { launch(); }
}