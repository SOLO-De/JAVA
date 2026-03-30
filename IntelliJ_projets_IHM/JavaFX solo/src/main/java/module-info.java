module com.example.javafxsolo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.javafxsolo to javafx.fxml;
    exports com.example.javafxsolo;
}