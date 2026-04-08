package Modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * La méthode lecture construit puis renvoie un graphe à partir de données contenues dans le fichier reçu en paramètre.
 */
public class LectureGraphe {

    /**
     * La méthode lecture construit puis renvoie un graphe à partir de données contenues dans le fichier reçu en paramètre
     * @param file : le fichier contenant les informations pour construire le graphe
     * @return le graphe construit
     */
    public static Graphe lecture(File file) {
        Map<Integer, Set<Integer>> lesVoisins = new TreeMap<>();

        // Utilisation de try-with-resources pour fermer les scanners automatiquement
        try (Scanner scannerLigne = new Scanner(file)) {
            String ligne;

            while (scannerLigne.hasNext()) {
                ligne = scannerLigne.nextLine();

                // Traitement de la ligne si elle commence par "V" (indique l'intervalle des sommets)
                if (ligne.startsWith("V")) {
                    try (Scanner scannerToken = new Scanner(ligne)) {
                        scannerToken.next(); // Ignore "V"
                        String intervalle = scannerToken.next();
                        String[] minEtMax = intervalle.split("[.\\[\\]]+");
                        int min = Integer.parseInt(minEtMax[1]);
                        int max = Integer.parseInt(minEtMax[2]);

                        // Ajout des sommets dans le graphe
                        for (int i = min; i <= max; i++) {
                            lesVoisins.putIfAbsent(i, new TreeSet<>());
                        }
                    }
                }

                // Traitement des arêtes si la ligne commence par "E"
                if (ligne.startsWith("E")) {
                    try (Scanner scannerToken = new Scanner(ligne)) {
                        scannerToken.next(); // Ignore "E"
                        int numSommetDepart = scannerToken.nextInt();
                        int numSommetArrivee = scannerToken.nextInt();

                        // Ajout de l'arête entre les sommets
                        lesVoisins.get(numSommetDepart).add(numSommetArrivee);
                        lesVoisins.get(numSommetArrivee).add(numSommetDepart);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé : " + e.getMessage());
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return new Graphe(file.getName(), lesVoisins);
    }
}