
//import java.util.*;

import java.time.LocalDate;

public class Location {
    int id_location;
    LocalDate date_debut;
    int duree;
    Client clt;
    Scooter scoot;
    Retour ret;
    static int compteur = 0;
    
    public Location(LocalDate date_debut, int duree, Client c, Scooter s) {
    	this.id_location = ++compteur;
        this.date_debut = date_debut;
      	this.duree=duree;
      	this.clt=c;
      	this.scoot=s;
      	c.ajoutLoc(this);
      	s.ajoutLoc(this);
    }
    
    // associe un retour à la location
    public void ajouterRetour (Retour r) {
    	this.ret= r;
    }
     

     
    public boolean isOkay(LocalDate date, int d) {

        LocalDate newStart = date;
        LocalDate newEnd = date.plusDays(d - 1);
        

        LocalDate start = this.date_debut;
        LocalDate end = this.date_debut.plusDays(this.duree - 1);
        
        if (newEnd.isBefore(start) || newStart.isAfter(end)) {
            return true; 
        } else {
             return false; 
        }
    }
    
}   
 