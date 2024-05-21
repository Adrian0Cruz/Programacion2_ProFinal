module com.mycompany.programacion2_profinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.programacion2_profinal to javafx.fxml;
    exports com.mycompany.programacion2_profinal;
}
