package client;

import modele.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class clientPlanningCollections {
    public static void main(String args[]){
        PlanningCollection planning  = new PlanningCollection();
        try {
            Scanner scanner = new Scanner(new File("data" + File.separator + "planning.txt"));
            scanner.useDelimiter(",");
            while(scanner.hasNext()){
                String intitule = scanner.next().trim();
                int jour = scanner.nextInt();
                int mois = scanner.nextInt();
                int annee = scanner.nextInt();
                int heureD = scanner.nextInt();
                int quartHeureD = scanner.nextInt();
                int heureF =  scanner.nextInt();
                int quartHeureF = scanner.nextInt();
                try{
                    planning.ajout(new Reservation(
                            new DateCalendrier(jour, mois, annee),
                            new PlageHoraire(new Horaire(heureD,quartHeureD),new Horaire(heureF,quartHeureF)),intitule))
                ;}
                catch (ExceptionPlanning e) {
                    System.out.println(e.getMessage());
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("fichier non trouvé :"+e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("entier attendu :"+e.getMessage());
        }
        catch (NoSuchElementException e){
            System.out.println(" scanner épuisé");
        }
        catch (IllegalStateException e){
            System.out.println("scanner fermé");
        }
        System.out.println(planning.toString());
    }
}
