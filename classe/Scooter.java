import java.util.Vector;
import java.time.LocalDate;

public class Scooter {
     String modele;
     int num_id;
     int kilometrage;
     String etat;
     float prix_jour;
     String image;
     Parc parc;
    
     Vector<Location> listLoc =new Vector<Location>();
     

    public Scooter(String modele, int num_id, int kilometrage, String etat, float prix_jour,Parc p, String image) {
        this.modele = modele;
        this.num_id = num_id;
        this.kilometrage = kilometrage;
        this.etat = etat;
        this.prix_jour = prix_jour;
        this.parc=p;
        this.image = image;
        p.ajouterScooter(this); 
      
    }
    
    public void ajoutLoc(Location l) {
    	listLoc.add(l);
    	}
    //voir ces locations
    public Vector<Location> getLocations() {
        return listLoc;
    }
    
    public boolean isFree(LocalDate date, int duree) {
        for (Location l : listLoc) {
            if (l.ret != null) continue;//scooter retourné
            if (!l.isOkay(date, duree)) {
                return false;
            }
        }

 
        return true;
    }
    
    
     
    //@Override
    public String toString() {
        return num_id + " - " + modele + " (" + prix_jour + "€/j)";
   }
       
 
    
    public String getEtat(LocalDate date, int duree) {
        return isFree(date, duree) ? "disponible" : "loué";
    } 
    
   
    public boolean louer(LocalDate date, int duree, Client c) {
        if (isFree(date, duree)) {
            new Location(date, duree, c, this);
            return true;
        }
        return false;
    }
    public boolean rendre(int km, String etat) {
        for (Location l : listLoc) {
            if (l.ret == null) {
                new Retour(km, etat, l);
                return true;
            }
        }  
        return false;
    } 
    public String getModele() { return modele; }
    public float getPrixJour() { return prix_jour; }
    public String getEtat() { return etat; }
    public String getImage() { return image; }
} 