package client.modele;

public class Reservation {

    private DateCalendrier chDateCalendrier;
    private PlageHoraire chPlaHoraire;
    private String chtitre;

    public Reservation(DateCalendrier DAT,PlageHoraire PL,String titre ){
        chDateCalendrier=DAT;
        chPlaHoraire=PL;
        chtitre=titre;

    }
    public String toString(){
        return chtitre+","+chDateCalendrier.toString()+","+chPlaHoraire.toString();
    }
    public int CompareTo(Reservation Resev1) {
        if ( this.chDateCalendrier.compareto(Resev1.chDateCalendrier ) > 0) {
            ;
            return 5;
        }
        if (this.chDateCalendrier.compareto(Resev1.chDateCalendrier) < 0) {
            ;
            return -5;
        } else {
            if ( this.chPlaHoraire.compareto(Resev1.chPlaHoraire) > 0 ) {
                return 1;
            }
            if ( this.chPlaHoraire.compareto(Resev1.chPlaHoraire) < 0 ) {
                return -1;
            } else {
                return 0;
            }
        }

    }
    public DateCalendrier getDate(){
        return chDateCalendrier;
    }
    public boolean EstValide(){
        if (this.chDateCalendrier.estvalide()){
            if (this.chPlaHoraire.estvalide()){
                return true;
            }
        }
        return false;
    }
    public String gettitre(){
        return chtitre;
    }
}
