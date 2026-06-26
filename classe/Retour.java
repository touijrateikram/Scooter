

public class Retour {
    int id_retour;
    int kilometrage_retour;
    String etat;
    Location loc;
    static int compteur = 0;

    public Retour(int kilometrage_retour, String etat,Location l) {
        this.id_retour= ++compteur;
        this.kilometrage_retour = kilometrage_retour;
        this.etat = etat;
        loc=l;
        l.ajouterRetour(this);
    }

}     