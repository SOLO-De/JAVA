package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.Date;

public class VBoxRoot extends VBox {
    public VBoxRoot(){
        CalendrierDuMois mars= new CalendrierDuMois(03,2026);
        Label lblmars=new Label(mars.getMois()+"/"+ mars.getAnnee());
        for (int i = 0; i<mars.getDates().size();i++);{
            Label ldate= new Label(mars.getDates(i))

        }
        this.getChildren().addAll(lblmars);
    }
}
