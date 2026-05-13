package Modele;

import java.util.*;

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
    public Map<Integer,Integer> DegreEntrant(){
        Map<Integer,Integer> ens_deg = new HashMap<>();
        for(Integer i : this.ensem.keySet()){
            int degre=0;
            for (Set<Integer> voisinSommet: ensem.values()){
                if (voisinSommet.contains(i)){
                    degre+=1;
                }
            }
            ens_deg.put(i, degre);
        }
        return ens_deg;
    }
    public ArrayList<Integer> OrdreTopo(){
        ArrayList<Integer> ordreTopolo= new ArrayList<>();
        Map<Integer,Integer> degre_entr=this.DegreEntrant();
        ArrayList<Integer> ens_zero= new ArrayList<>();
        for (Integer zero:degre_entr.keySet()){
            if(degre_entr.get(zero)==0){
                ens_zero.add(zero);
            }
        }
        while(!ens_zero.isEmpty()){
            Integer S= ens_zero.getFirst();
            for (Integer voisin: ensem.get(S)){
                Integer a=degre_entr.get(voisin)-1;
                degre_entr.put(voisin,a);
                if(degre_entr.get(voisin)==0){
                    ens_zero.add(voisin);
                }
            }
            ens_zero.removeFirst();
            ordreTopolo.add(S);
        }

        return ordreTopolo;
    }
    public  ArrayList<Integer> parcoursenlongueur(){
        ArrayList<Integer> dejavue= new ArrayList<>();
        Map<Integer,Integer> degre_entr=this.DegreEntrant();
        ArrayList<Integer> ens_zero= new ArrayList<>();
        for (Integer zero:degre_entr.keySet()){
            if(degre_entr.get(zero)==0){
                ens_zero.add(zero);
            }
        }
        while(!ens_zero.isEmpty()){
            Integer avenir = ens_zero.removeFirst();
            if(dejavue.contains(avenir)){

            }
            else{
                dejavue.add(avenir);
                for (Integer voisin: ensem.get(avenir)){

                }

            }


        }
    }
}
