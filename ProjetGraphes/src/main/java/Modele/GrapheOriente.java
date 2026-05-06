package Modele;

import java.util.HashMap;
import java.util.Iterator;
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
        String ret="nom du fichier : "+nomfic +" le dictionnaire des voisins : "+ensem+" la Taille :"+this.Taille() +" l'ordre :"+ this.ordre();
        for(Integer i : this.ensem.keySet()){
            ret = ret + "\n"+"* sommet "+ i +" -  degré "+this.degre(i)+", voisins : "+ensem.get(i);
        }
        return ret;
    }
    public int ordre(){
        return ensem.size();
    }

    public int degre(int parsommet){
        return ensem.get(parsommet).size();

    }
    public int Taille(){
        int Tail=0;
        for(Set<Integer> voisinSommet: ensem.values()){
                Tail+= ensem.size();
        };
        return Tail;
    }
    public Map<Integer,Integer> DegreEntrant(int som){
        int degre=0;
        for(Integer i : this.ensem.keySet()){
            if (i==som){

            }
        }
    }
}
