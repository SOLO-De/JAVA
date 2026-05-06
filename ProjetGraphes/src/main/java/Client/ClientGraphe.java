package Client;

import Modele.Graphe;
import Modele.GrapheOriente;
import Modele.LectureGraphe;

import java.io.File;

public class ClientGraphe {
    public static void main(String[] args) {
        File [] listegrph=new File("petits_graphes").listFiles();

        File [] listegrpheO=new File("graphes_orientes").listFiles();
//        for(File fichier :listegrph) {
//            Graphe g1 = LectureGraphe.lecture(fichier);
//            System.out.println(g1.toString());
//            System.out.println(g1.degre(1));
//        }
        for(File fichier :listegrpheO) {
            GrapheOriente g1 = LectureGraphe.lectureGO(fichier);
            System.out.println(g1.toString());
        }



        //Graphe complet1=Graphe.grapheComplet(4);
        //System.out.println(complet1.toString());

        //Graphe cycle1=Graphe.cycle(5);
        //System.out.println(cycle1.toString());

        //Graphe bipartie=Graphe.bipartiComplet(3,4);
        //System.out.println(bipartie.toString());
    }
}
