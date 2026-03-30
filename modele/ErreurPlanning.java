package client.modele;

public enum ErreurPlanning {

    RESERVATION_NON_VALIDE, PLANNING_PLEIN, CHEVAUCHEMENT_RESERVATION;

    public String toString() {
        switch (this) {
            case RESERVATION_NON_VALIDE:
                return "La réservation entrée n'est pas valide";
            case PLANNING_PLEIN:
                return "Le planning est plein";
            case CHEVAUCHEMENT_RESERVATION:
                return "La réservation ne peut être ajoutée car elle se chevauche avec une autre réservation du planning";
            default:
                return "Réservation ajoutée avec succès";
        }
    }

}


