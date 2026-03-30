package modele;

import java.util.Scanner;
import java.util.Calendar;

public abstract class Date {
    protected int jour;
    protected int mois;
    protected int annee;

    public Date(int jo,int mo ,int ans ){
        jour =jo;
        mois=mo;
        annee=ans;
    }
    public  Date(int ans){
        jour = 1;
        mois = 1;
        annee = ans;
    }
    public String toString(){
        return jour +"-"+mois+"-"+annee;
    }
    public boolean Bissextile(){
        if (this.annee/400==0 ||this.annee/4==0 && this.annee/100!=0){
            return true;
        }
        else return false;
    }
    public int dernierjoudumois(){
        if (this.mois==2){
            if (this.Bissextile()){
                return 29;
            }
            else return 28;
        }
        if (this.mois==1|| this.mois==3||this.mois==5|| this.mois==7||this.mois==8||this.mois==10||this.mois==12){
            return 31;
        }
        else return 30;
    }
    public boolean estvalide(){
        if (this.jour>this.dernierjoudumois()){
            return false;
        }
        if (this.annee<1583){
            return false;
        }
        else return true;
    }
    public static Date lireDate (){
        Scanner scanner = new Scanner(System.in);
        int jour = scanner.nextInt() ;
        int mois = scanner.nextInt() ;
        int annee = scanner.nextInt() ;
        return new Date(jour,mois,annee);
    }
    public int compareto(Date pardat){
        if (this.annee<pardat.annee){
            return -10;
        }
        if (this.annee>pardat.annee){
            return 10;
        }
        else{
            if (this.mois<pardat.mois){
                return -5;
            }
            if (this.mois>pardat.mois){
                return 5;
            }
            else{
                if (this.jour<pardat.jour){
                    return -1;
                }
                if (this.jour>pardat.jour){
                    return 1;
                }
                else return 0;
            }
        }
    }
    public Date dateDuLendemain(){
        if( this.jour==this.dernierjoudumois()){
            if (this.mois==12){
                return new Date(this.annee+1);
            }
            else return new Date(1,this.mois+1,this.annee);
        }
        else return (new Date(this.jour+1,this.mois,this.annee));
    }
    public Date dateDeLaVeille (){
        if( this.jour==1){
            if (this.mois==1){
                return new Date(30,12,this.annee-1);
            }
            else return new Date(1,this.mois-1,this.annee);
        }
        else return (new Date(this.jour-1,this.mois,this.annee));
    }

    public abstract int DateDuLendemain();
}


