package modele;

import java.util.ArrayList;
import java.util.TreeSet;

public class PlanningCollection {
    private ArrayList<Reservation> chlistReservation;
    private TreeSet<Reservation> chTreereservation;

    public PlanningCollection (){
        chlistReservation = new ArrayList<>();
        chTreereservation = new TreeSet<>();
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
                chlistReservation.add(parres);
                chTreereservation.add(parres);
            }
        }
    }



    public String toString(){
        return chlistReservation.size()+""+chlistReservation+"\n"+" ";
    }
}
