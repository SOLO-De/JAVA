package client;

import modele.Horaire;
import modele.PlageHoraire;

public class ClientPlageHoraire {
    public static void main(){
    Horaire H1= new Horaire(10,00);
    Horaire H2= new Horaire(11,30);
    PlageHoraire PL1 = new PlageHoraire(H1,H2);

    System.out.println(PL1.toString());

    }
}
