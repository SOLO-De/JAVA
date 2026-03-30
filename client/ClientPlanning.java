package client;

import modele.Planning;

import java.io.File;
import java.util.Scanner;

public class ClientPlanning {
    public static void main(String[] args){
        try{
            Planning planning =new Planning(5);
            Scanner scanner = new Scanner(new File("Date"+ File.separator+"panning.txt"));
            scanner.useDelimiter(",");

            while (scanner.hasNext()) {
                String intitule=scanner.next();
                int jour=scanner.nextInt();
                int mois=scanner.nextInt();
                int annee=scanner.nextInt();






            }

        }
    }



}
