package Modele;

import java.util.Map;
import java.util.Set;

public class GrapheOriente {
    private String nomfic;
    private Map<Integer, Set<Integer>> ensem;

    public GrapheOriente(String a,Map<Integer, Set<Integer>> parens){
        nomfic = a;
        ensem= parens;
    }
    public String toString(){
        return "nom du fichier : "+nomfic +"  le dictionnaire des voisins : "+ensem;
    }


}
