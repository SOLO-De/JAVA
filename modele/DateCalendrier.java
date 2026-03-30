
package client.modele;


import java.util.Calendar;

public class DateCalendrier extends Date implements  Comparable <Date>  {

    private int dayOfWeek;
    private int weekOfYear ;

    /** retourne la date d'aujourd'hui
     *
     */
    public DateCalendrier ()   {
        super();

        Calendar today = Calendar.getInstance();
        dayOfWeek = today.get (Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1)
            dayOfWeek = 7;
        else dayOfWeek -= 1;

        weekOfYear = today.get (Calendar.WEEK_OF_YEAR);
    }

    public DateCalendrier (int parJour, int parMois, int parAnnee)   {
        super(parJour, parMois, parAnnee);
        Calendar date = Calendar.getInstance();
        date.set(annee,mois-1,jour);
        dayOfWeek = date.get (Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1)
            dayOfWeek = 7;
        else dayOfWeek -= 1;
        weekOfYear = date.get (Calendar.WEEK_OF_YEAR);
    }





    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isToday() {
        return this.compareTo(new DateCalendrier()) == 0;
    }

    public int getWeekOfYear() {
        return weekOfYear;
    }

    @Override
    public DateCalendrier dateDuLendemain ()   {
        Date dateLendemain =  super.dateDuLendemain();
        return new DateCalendrier (dateLendemain.jour,dateLendemain.mois,dateLendemain.annee);
    }

    @Override
    public DateCalendrier dateDeLaVeille ()  {
        Date dateVeille =  super.dateDeLaVeille();
        return new DateCalendrier (dateVeille.jour,dateVeille.mois,dateVeille.annee);
    }


    public String toString () {

        return ConstantesCalendrier.Jours.values()[dayOfWeek -1] + " " + jour + " " +
                ConstantesCalendrier.Mois.values() [mois-1] ;
    }
}