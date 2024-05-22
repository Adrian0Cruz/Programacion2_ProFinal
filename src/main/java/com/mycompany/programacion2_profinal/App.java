package com.mycompany.programacion2_profinal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;
//JavaFX App Jesus Hernandez
public class App extends Application {
    private static Scene scene;
    @Override
    public void start ( Stage stage ) throws IOException {
        BorderPane bp = new BorderPane();

        /*final double[] xOffset = {0};
        final double[] yOffset = {0};
        bp.setOnMousePressed(event -> {
            xOffset[0] = event.getSceneX();
            yOffset[0] = event.getSceneY();
        });
        bp.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset[0]);
            stage.setY(event.getScreenY() - yOffset[0]);
        });*/
        
        scene = new Scene ( loadFXML ( "Register" ), 900, 600 );
        stage.setScene ( scene );
        stage.initStyle ( StageStyle.UNDECORATED );
        stage.show (  );
    }
    static void setRoot ( String fxml ) throws IOException {
        scene.setRoot ( loadFXML ( fxml ) );
    }
    private static Parent loadFXML ( String fxml ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader ( App.class.getResource ( fxml + ".fxml" ) );
        return fxmlLoader.load (  );
    }
    public static void main(String[] args) { launch(); }
}