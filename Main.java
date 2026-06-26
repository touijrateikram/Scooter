import java.time.LocalDate;

 public class Main {
 public static void main(String[] args) {
	 
	 Parc p = new Parc("ScooterSky", 0, "actif");
	 
	 Scooter c1 = new Scooter("Enhypen", 1, 1000, "disponible", 15, p, "bleu.jpg");
	 Scooter c2 = new Scooter("Jungwon", 2, 2000, "disponible", 20, p, "noir.jpg");
	 Scooter c3 = new Scooter("Heesung", 3, 3000, "disponible", 25, p, "rouge.jpg");

	 Scooter c4 = new Scooter("Jaeyun", 4, 1500, "disponible", 15, p, "vert.jpg");
	 Scooter c5 = new Scooter("Sunghoon", 5, 2500, "disponible", 20, p, "dore.jpg");
	 Scooter c6 = new Scooter("Nishimura", 6, 3500, "disponible", 25, p, "violet.jpg");

	 Scooter c7 = new Scooter("Jongseong", 7, 2000, "disponible", 15, p, "lightvert.jpg");
	 Scooter c8 = new Scooter("Sunoo", 8, 2000, "disponible", 20, p, "marron.jpg");
	 Scooter c9 = new Scooter("Engene", 9, 3000, "disponible", 25, p, "rose.jpg");
  

     Client cl1 = new Client(1, "Yaya", "Kim", "aya@gmail.com", p);
     Client cl2 = new Client(2, "Chamchouna", "Park", "chimie@gmail.com", p);


     Location loc1 = new Location( LocalDate.parse("2026-06-16"), 20, cl1, c1);
     Location loc2 = new Location( LocalDate.parse("2026-04-24"),5,cl2,c4);
     Location loc3 = new Location( LocalDate.parse("2026-06-14"), 16, cl1, c8);
     Retour r1 = new Retour( 1200, "bon", loc2);
     
    new VueParc(p);
     
      
      
     
} }