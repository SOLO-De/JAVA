package client.modele;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class  PlanningCollection {
    private ArrayList<Reservation> chlistReservation;
    private TreeSet<Reservation> chTreereservation;
    public TreeMap<Integer,TreeSet<Reservation>> chSem ;

    public PlanningCollection (){
        chlistReservation = new ArrayList<>();
        chTreereservation = new TreeSet<>();
        chSem= new TreeMap<>();
    }
    public void ajout(Reservation parres) throws ExceptionPlanning {
        if (parres.EstValide()) {
           throw new ExceptionPlanning(ErreurPlanning.RESERVATION_NON_VALIDE)  ;
        }

        for ( int i = 0; i<chlistReservation.size() ;i++){
            if(parres.CompareTo(chlistReservation.get(i))==0){
                throw new ExceptionPlanning(ErreurPlanning.CHEVAUCHEMENT_RESERVATION);
            }
            else {
                int NumSem=parres.getDate().getDayOfWeek();
                if (chSem.containsKey(NumSem)){
                    chSem.get(NumSem).add(parres);
                }
                else {
                    TreeSet arbre=new TreeSet();
                    arbre.add(parres);
                    chSem.put(NumSem,arbre);
                }
                chlistReservation.add(parres);
                chTreereservation.add(parres);
            }
        }
    }

    public TreeSet<Reservation> getReservation(String str) {
        TreeSet<Reservation> listfinal= new TreeSet<>();
        for (int i = 0;i <chlistReservation.size();i++){
            if (chlistReservation.get(i).gettitre()==str){
                listfinal.add(chlistReservation.get(i));
            }
        }
        return listfinal ;
    }
    public TreeSet<Reservation>  getReservation(Date pardate){
        TreeSet<Reservation> listfinal= new TreeSet<>();
        for (int i = 0;i <chlistReservation.size();i++){
            if (chlistReservation.get(i).getDate()==pardate){
                listfinal.add(chlistReservation.get(i));
            }
        }
        return listfinal ;
    }

    public String toString(){
        return chlistReservation.size()+""+chlistReservation+"\n"+" ";
    }
}
