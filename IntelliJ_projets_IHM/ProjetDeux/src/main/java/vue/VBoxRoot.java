package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.Date;
import modele.DateCalendrier;

import java.io.File;

public class VBoxRoot extends VBox {
    public VBoxRoot(){


        CalendrierDuMois mars= new CalendrierDuMois(3,2026);
        Label lblmars=new Label(mars.getMois()+"/"+ mars.getAnnee());
        lblmars.setId("Today");
        VBoxRoot.setMargin(lblmars,new Insets(14));

        this.getChildren().addAll(lblmars);
        VBox box=new VBox();
        CalendrierDuMois Cala= new CalendrierDuMois(mars.getMois(), mars.getAnnee());
        for (DateCalendrier date :Cala.getDates()){
            Label lbldat = new Label(date.toString());
            box.getChildren().addAll(lbldat);
        }
        StackPane monthStackPane= new StackPane();

        this.getChildren().addAll(box);
    }
}
