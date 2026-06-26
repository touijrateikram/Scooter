//import java.util.ArrayList;
//import java.util.List;
import java.time.LocalDate;
import java.util.Vector;

public class Parc {
     String nom;
     float prix;
     String etat;
     
     Vector<Client> listClient=new Vector<Client>();
     Vector<Scooter> listScoot=new Vector<Scooter>();

    public Parc(String nom, float prx, String etat) {
    this.nom = nom;
	this.prix=prx;
	this.etat=etat;
}
public void ajouterScooter(Scooter s) {
	listScoot.add(s);
}

public void ajouterClient(Client c) {
	listClient.add(c);
	
	
}
//filtre scooter dispo  
public Vector<Scooter> scootersDisponibles(LocalDate date, int duree) {
    Vector<Scooter> dispo = new Vector<>();

    for (Scooter s : listScoot) {
        if (s.isFree(date, duree)) {
            dispo.add(s);
        }
    }
    return dispo;
}

public Vector<Scooter> getScooters() {
    return new Vector<>(listScoot);
}

 

public Vector<Client> getClients() {
    return new Vector<>(listClient);
} 
}  