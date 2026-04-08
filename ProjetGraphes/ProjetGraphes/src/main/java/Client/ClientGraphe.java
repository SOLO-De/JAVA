package Client;

import Modele.Graphe;
import Modele.LectureGraphe;

import java.io.File;

public class ClientGraphe {
    public static void main(String[] args) {

        File dossier = new File("petits_graphes");
        File[] listegrph = dossier.listFiles();

        if (listegrph == null) {
            System.out.println("Le dossier 'petits_graphes' est introuvable ou vide.");
            return;
        }

        for(File fichier : listegrph) {
            if (fichier.isFile()) {
                try {
                    Graphe G1 = LectureGraphe.lecture(fichier);
                    System.out.println(G1);
                } catch (Exception e) {
                    System.out.println("Erreur avec le fichier : " + fichier.getName());
                }
            }
        }

        // Tests
        Graphe complet1 = Graphe.grapheComplet(4);
        System.out.println(complet1);

        Graphe cycle1 = Graphe.cycle(5);
        System.out.println(cycle1);

        Graphe biparti = Graphe.bipartiComplet(5, 6);
        System.out.println(biparti);
    }
}