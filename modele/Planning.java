package client.modele;


public class Planning {
    private Reservation [] chRes;
    private int chTaille;

    public  Planning(int Tail){
        chTaille=Tail;
        Reservation [] res= new Reservation[Tail];
        chRes=res;
    }
    public boolean ajout(Reservation Reserve){
        if (Reserve.EstValide()){
            for(int i =0;i<chRes.length;i++){
                if (Reserve.CompareTo(chRes[i])!=0){
                    return false;
                }
            }
            if (chRes.length==chTaille){
                return false;
            }
            else {
                return true;
            }
        }
        else{
            return false;
        }

    }
    public String toString() {
        String resultat = "";

        for (int i = 0; i < chTaille; i++) {
            resultat = resultat + chRes[i].toString() + "\n";
        }

        return resultat;
    }
    public Reservation getReservation(Date parDate){
        for(int i=0; i<chRes.length;i++){
            if (((Date) chRes[i].getDate).compareto(parDate)==0){
                return chRes[i];
            }
        }
        return null;
    }
    public Reservation[] getReservations(Date parDate){
        Reservation [] tabres =new Reservation[chTaille];
        for(int i=0; i<chRes.length;i++){
            if (((Date) chRes[i].getDate).compareto(parDate)==0){
                tabres[i]=chRes[i];
            }
        }
        return tabres;
    }


}
