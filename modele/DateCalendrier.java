package modele;

import java.util.Calendar;

public class DateCalendrier extends Date {
    private int chJourSemaine;

    public DateCalendrier() {
        super(0,0,0);
        Calendar today = Calendar.getInstance();

        annee = today.get(Calendar.YEAR);

// Calendar.MONTH retourne 0 pour janvier, 1 pour février...

        mois = today.get(Calendar.MONTH);
        jour = today.get(Calendar.DAY_OF_MONTH);

// Calendar.DAY_OF_WEEK retourne 1 pour dimanche, 2 pour lundi... int dayOfWeek= today.get (Calendar.DAY_OF_WEEK);

        int DayOfWeek = today.get(Calendar.DAY_OF_WEEK);

// à compléter pour attribuer la valeur souhaitée à chJourSemaine lundi 1...
        if (DayOfWeek==1){
            chJourSemaine = 7;
        }
        else {
            chJourSemaine = DayOfWeek - 1;
        }
    }
    public DateCalendrier(int parjour,int parmois,int parannee) {
        super(parjour,parmois,parannee);
        Calendar today = Calendar.getInstance();
        annee= parannee;
        mois = parmois;
        jour = parjour;
        today.set(parannee,parmois,parjour);

        int DayOfWeek = today.get(Calendar.DAY_OF_WEEK);

        if (DayOfWeek==1){
            chJourSemaine = 7;
        }
        else {
            chJourSemaine = DayOfWeek - 1;
        }
    }
    @Override
    public DateCalendrier DateDuLendemain() {
        super.dateDuLendemain(jour,mois,annee);
        return ;
    }

}
