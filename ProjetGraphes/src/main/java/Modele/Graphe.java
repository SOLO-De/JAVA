package Modele;

import java.util.Map;
import java.util.Set;
import org.javatuples.Pair;

public class Graphe {
    private String chnomfic;
    private Map<Integer, Set<Integer>> matrice_adjacent;

    public Graphe(String parnom, Map ensgraph){
        chnomfic=parnom;
        matrice_adjacent=ensgraph;
    }
    public String toString(){
        String Caracteristic="Fichier "+chnomfic+"\n"+" Ordre : "+this.ordre()+" Taille : "+this.Taille();
        for(int i=0;i< matrice_adjacent.size();i++){
            Caracteristic =Caracteristic + "\n"+"* sommet "+ i +" -  degré "+this.degre(i)+", voisins : "+matrice_adjacent.get(i);
        }
        Caracteristic= Caracteristic +"\n"+" Degré min : "+this.degreMinDegreMax().getValue0()+" Degré max : "+this.degreMinDegreMax().getValue1();
        return Caracteristic;
    }

    public int ordre(){
        return matrice_adjacent.size();
    }
    public int degre(int parsommet){
        return matrice_adjacent.get(parsommet).size();
    }
    public int Taille(){
        int Tail=0;
        for(int i=0;i< matrice_adjacent.size();i++){
            Tail+=matrice_adjacent.get(i).size();
        }
        Tail=Tail/2;
        return Tail;
    }
    public Pair degreMinDegreMax(){
        int min=degre(0);
        int max=degre(0);
        for(int i=1;i< matrice_adjacent.size();i++){
            if (degre(i)>degre(min)){
                min=i;
            }
            if (degre(i)<degre(max)){
                max=i;
            }
        }
        return new Pair(min,max);
    }
    public  static Graphe grapheComplet(int n){
        Map<Integer,Set<Integer>> ens_somm= new Map<>();
        for (int i=0;i<n;i++){
            Set <Integer> voisin=new Set<>();
            for (int j=0;j<n;j++){
                if (i!=j){
                    voisin.add(j);
                }
            }
        ens_somm.put(i,voisin)
        }
    }
}

