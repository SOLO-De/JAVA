package Modele;

import java.util.*;

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
    public static Graphe grapheComplet(int n){
        Map<Integer,Set<Integer>> ens_somm= new HashMap<>();
        for (int i=0;i<n;i++){
            Set <Integer> voisin=new HashSet<>();
            for (int j=0;j<n;j++){
                if (i!=j){
                    voisin.add(j);
                }
            }
            ens_somm.put(i,voisin);
        }
        String nom= "graphe complet à "+n+"sommets";
        return (new Graphe(nom,ens_somm));
    }
    public static Graphe cycle(int n ){
        Map<Integer,Set<Integer>> ens_somm= new HashMap<>();
        for (int i=0;i<n;i++){
            Set <Integer> voisin=new HashSet<>();
            if (i==0){
                voisin.add(n-1);
                voisin.add(i+1);
            }
            else if (i==n-1) {
                voisin.add(0);
                voisin.add(i-1);

            }
            else{
                voisin.add(i-1);
                voisin.add(i+1);
            }

            ens_somm.put(i,voisin);
        }
        String nom= "Cycle à "+n+"sommets";
        return (new Graphe(nom,ens_somm));
    }
    public static Graphe bipartiComplet(int p,int q) {
        Map<Integer, Set<Integer>> ens_somm = new HashMap<>();
        for (int i = 0; i < p; i++) {
            Set<Integer> voisin = new HashSet<>();
            for (int j = 0; j < q; j++) {
                voisin.add(j+p);
            }
            ens_somm.put(i, voisin);
        }
        for (int i = p; i < q+p; i++) {
            Set<Integer> voisin = new HashSet<>();
            for (int j = 0; j < p; j++) {
                voisin.add(j);
            }
            ens_somm.put(i, voisin);
        }
        String nom = "graphe bipartie complet (" + p + "," + q + ")";
        return (new Graphe(nom, ens_somm));
    }

  //  public static Graphe grille2D(int c){
  //      Map<Integer,Set<Integer>> ens_somm =new HashMap<>();
  //      for (int i=0;i<c;i++){
  //         for
  //      }
  //  }
    public TreeMap<Integer,Pair<Integer,Integer>> parcoursEnLargeur(int a){
        ArrayList<Integer> depart= new ArrayList<>();
        TreeMap<Integer,Pair<Integer,Integer>> parcours=new TreeMap<>();
        depart.add(a);
        parcours.put(a,new Pair<>(-1,0));
        while(! depart.isEmpty()){
            int p=depart.remove(0);
            for(Integer voisin :matrice_adjacent.get(p)){
                if (! parcours.containsKey(voisin)){
                    depart.add(voisin);
                    parcours.put(voisin,new Pair(p,parcours.get(p).getValue1()+1));
                }
            }
        }
        return parcours;
    }
}
