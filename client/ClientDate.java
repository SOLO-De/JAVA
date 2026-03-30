package client;

import modele.Date;

public class ClientDate {

    public void main( String [] args){
        Date aujourd = new Date(16, 2, 2026);
        Date premier =new Date(2026);

        System.out.println(aujourd.toString());
        System.out.println(premier.toString());

        System.out.println(aujourd.Bissextile());
        System.out.println(premier.Bissextile());

        System.out.println(aujourd.dernierjoudumois());
        System.out.println(premier.dernierjoudumois());

        System.out.println(aujourd.estvalide());
        System.out.println(premier.estvalide());

        System.out.println(aujourd.compareto(premier));

        System.out.println(aujourd.dateDuLendemain());
        System.out.println(aujourd.dateDeLaVeille());
    }
}
