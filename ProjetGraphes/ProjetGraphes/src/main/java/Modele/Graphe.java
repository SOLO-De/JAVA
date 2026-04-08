package Modele;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.javatuples.Pair;

public class Graphe {
    private String chnomfic;
    private Map<Integer, Set<Integer>> matrice_adjacent;

    public Graphe(String parnom, Map<Integer, Set<Integer>> ensgraph){
        chnomfic = parnom;
        matrice_adjacent = ensgraph;
    }

    @Override
    public String toString(){
        String Caracteristic = "Fichier " + chnomfic +
                "\n Ordre : " + this.ordre() +
                " Taille : " + this.taille();

        for(Integer i : matrice_adjacent.keySet()){
            Caracteristic += "\n* sommet " + i +
                    " - degré " + this.degre(i) +
                    ", voisins : " + matrice_adjacent.get(i);
        }

        Pair<Integer, Integer> deg = this.degreMinDegreMax();
        Caracteristic += "\n Degré min (sommet) : " + deg.getValue0() +
                " Degré max (sommet) : " + deg.getValue1();

        return Caracteristic;
    }

    public int ordre(){
        return matrice_adjacent.size();
    }

    public int degre(int parsommet){
        return matrice_adjacent.get(parsommet).size();
    }

    public int taille(){
        int tail = 0;
        for(Integer i : matrice_adjacent.keySet()){
            tail += matrice_adjacent.get(i).size();
        }
        return tail / 2; // graphe non orienté
    }

    public Pair<Integer, Integer> degreMinDegreMax(){
        int min = 0;
        int max = 0;

        for(Integer i : matrice_adjacent.keySet()){
            if (degre(i) < degre(min)){
                min = i;
            }
            if (degre(i) > degre(max)){
                max = i;
            }
        }
        return new Pair<>(min, max);
    }

    public Set<Integer> voisins(int sommet){
        return matrice_adjacent.get(sommet);
    }

    public static Graphe grapheComplet(int n){
        Map<Integer, Set<Integer>> ens_somm = new HashMap<>();

        for (int i = 0; i < n; i++){
            Set<Integer> voisin = new HashSet<>();
            for (int j = 0; j < n; j++){
                if (i != j){
                    voisin.add(j);
                }
            }
            ens_somm.put(i, voisin);
        }

        return new Graphe("Graphe complet à " + n + " sommets", ens_somm);
    }

    public static Graphe cycle(int n){
        Map<Integer, Set<Integer>> ens_somm = new HashMap<>();

        for (int i = 0; i < n; i++){
            Set<Integer> voisin = new HashSet<>();

            if (i == 0){
                voisin.add(n - 1);
                voisin.add(i + 1);
            } else if (i == n - 1){
                voisin.add(0);
                voisin.add(i - 1);
            } else {
                voisin.add(i - 1);
                voisin.add(i + 1);
            }

            ens_somm.put(i, voisin);
        }

        return new Graphe("Cycle à " + n + " sommets", ens_somm);
    }

    public static Graphe bipartiComplet(int p, int q){
        Map<Integer, Set<Integer>> ens_somm = new HashMap<>();

        // première partition
        for(int j = 0; j < p; j++){
            Set<Integer> voisin = new HashSet<>();
            for (int i = p; i < p + q; i++){
                voisin.add(i);
            }
            ens_somm.put(j, voisin);
        }

        // deuxième partition
        for(int j = p; j < p + q; j++){
            Set<Integer> voisin = new HashSet<>();
            for (int i = 0; i < p; i++){
                voisin.add(i);
            }
            ens_somm.put(j, voisin);
        }

        return new Graphe("Graphe biparti complet à " + (p + q) + " sommets", ens_somm);
    }
}