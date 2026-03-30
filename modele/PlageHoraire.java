package client.modele;

public class PlageHoraire {
    private final static int  chduree=60;
    private Horaire heuredeb;
    private Horaire heurefin;

    public PlageHoraire(Horaire hordeb,Horaire horfin){
        heuredeb=hordeb;
        heurefin=horfin;
    }
    public String toString(){
        return heuredeb.toString()+"-"+heurefin.toString()+" durée :" + this.duree();
    }
    public boolean estvalide(){
        if (heurefin.toMinutes()-heuredeb.toMinutes()<chduree){
            return true;
        }
        return false;

    }
    public String duree(){
        return (this.heurefin.toMinutes()-this.heuredeb.toMinutes())/60 +"h"+(this.heurefin.toMinutes()-this.heuredeb.toMinutes())%60;
    }
    public  int compareto(PlageHoraire PL){
        if (this.heurefin.toMinutes()<= PL.heuredeb.toMinutes()){
            return -1 ;
        }
        if (PL.heurefin.toMinutes() <= this.heuredeb.toMinutes()){
            return 1 ;
        }
        else return 0 ;
    }

}
