package modele;

public class Reservation {

    public Object getDate;
    private Date chDate;
    private PlageHoraire chPlaHoraire;
    private String chtitre;

    public Reservation(Date DAT,PlageHoraire PL,String titre ){
        chDate=DAT;
        chPlaHoraire=PL;
        chtitre=titre;

    }
    public String toString(){
        return chtitre+","+chDate.toString()+","+chPlaHoraire.toString();
    }
    public int CompareTo(Reservation Resev1) {
        if ( this.chDate.compareto(Resev1.chDate ) > 0) {
            ;
            return 5;
        }
        if (this.chDate.compareto(Resev1.chDate) < 0) {
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
    public Date getDate(){
        return chDate;
    }
    public boolean EstValide(){
        if (this.chDate.estvalide()){
            if (this.chPlaHoraire.estvalide()){
                return true;
            }
        }
        return false;
    }

}
