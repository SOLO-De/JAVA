package Client;

import Modele.Graphe;
import Modele.LectureGraphe;

import java.io.File;

public class ClientGraphe {
    public static void main(String[] args) {
        File [] listegrph=new File("petits_graphes").listFiles();

        for(File fichier :listegrph) {
            Graphe G1 = LectureGraphe.lecture(fichier);
            System.out.println(G1.toString());
        }
    }
}
