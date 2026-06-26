import java.util.Vector;

public class Client {
    int id_client;
    String nom;
    String prenom;
    String adresse_mail;
    Parc parc;
    Vector<Location> listLoc =new Vector<Location>();
   

    public Client(int idClt, String nom, String prenom, String adresse_mail, Parc p) {
        this.id_client = idClt;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse_mail = adresse_mail;
        this.parc= p;
        p.ajouterClient(this);
       
    }
 
    public void ajoutLoc(Location l){
    	listLoc.add(l);
    	}
  
    public Vector<Location> getLocations() {
        return new Vector<>(listLoc);
    }
    
     
   

    @Override
    public String toString() {
        return nom + " " + prenom;
    }  
}  