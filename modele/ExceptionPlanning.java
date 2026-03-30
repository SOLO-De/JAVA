package client.modele;



public class ExceptionPlanning extends Exception {
    private ErreurPlanning typeErreur;

    public ExceptionPlanning(ErreurPlanning typeErreur) {
        this.typeErreur = typeErreur;
    }

    public ErreurPlanning getTypeError() {
        return typeErreur;
    }
}
