package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.CalendrierDuMois;

import java.io.File;

public class app extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBoxRoot();
        Scene scene =new Scene(root,300,80);
        stage.setScene(scene);
        stage.setTitle("Hello");
        stage.show();
        VBox date= new VBox();
        File css= new File("css"+File.separator+"css.css");
        scene.getStylesheets().add(css.toURI().toString());
    }


}
