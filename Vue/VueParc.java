import javax.swing.*; 
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.*;

public class VueParc extends JFrame {
Parc parc;
JPanel grille; 
public VueParc(Parc s){
this.parc=s;


try {
    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
} catch (Exception e) {
    e.printStackTrace();
}

this.setLayout(new BorderLayout());

this.setPreferredSize(new Dimension(1470,900));


JMenuBar mb= new JMenuBar();
mb.setBackground(new Color(210, 180, 140));
this.setJMenuBar(mb);


JMenu menuParc= new JMenu("Parc");
JMenu scooter= new JMenu("Scooter");
JMenu menuClient = new JMenu("Client");
JMenu menuLocation = new JMenu("Location");


JMenuItem ajouterClient = new JMenuItem("Ajouter Client");
menuClient.add(ajouterClient);

ajouterClient.addActionListener(new AjouterClientListener(parc));



JMenuItem ajouterLocation = new JMenuItem("Ajouter Location");
menuLocation.add(ajouterLocation);
ajouterLocation.addActionListener(new AjouterLocationListener(parc));

JMenuItem afficherParc= new JMenuItem("Afficher Parc");
menuParc.add(afficherParc);

afficherParc.addActionListener(new AfficherParcListener(parc));

JMenuItem ajouterScooter= new JMenuItem("Ajouter Scooter");
menuParc.add(ajouterScooter);

ajouterScooter.addActionListener(new AjouterScooterListener(parc));

JMenuItem dispo= new JMenuItem("Disponible ?");
scooter.add(dispo);
dispo.addActionListener(new AjouterDispoListener(parc));


JMenuItem retourner= new JMenuItem("Retourner Scooter");
scooter.add(retourner);
retourner.addActionListener(new AjouterRetournerListener(parc));

mb.setPreferredSize(new Dimension(70, 200));

Font police = new Font("Comic Sans MS", Font.BOLD, 20);
Font ipolice = new Font("Arial", Font.BOLD, 15);

menuParc.setFont(police);
scooter.setFont(police);
menuClient.setFont(police);
menuLocation.setFont(police);


afficherParc.setFont(ipolice);
ajouterScooter.setFont(ipolice);
dispo.setFont(ipolice);
retourner.setFont(ipolice);
ajouterClient.setFont(ipolice);
ajouterLocation.setFont(ipolice);


mb.setBackground(new Color(210, 180, 140));


ImageIcon icon = new ImageIcon("logo.jpg");

Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
icon = new ImageIcon(img);


JLabel logo = new JLabel("🌼Scootersky", icon, JLabel.CENTER);


logo.setIconTextGap(10); 


logo.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
logo.setForeground(new Color(101, 67, 33)); 

mb.setBorder(new LineBorder(Color.BLACK, 2));




JButton boutonConnexion = new JButton("Se connecter / S'inscrire");

boutonConnexion.setMaximumSize(new Dimension(200, 30));
boutonConnexion.setMinimumSize(new Dimension(200, 30));
boutonConnexion.setPreferredSize(new Dimension(200, 30));


boutonConnexion.setFont(new Font("Segoe UI", Font.BOLD, 14));
boutonConnexion.setForeground(new Color(0,0,0));
boutonConnexion.setBackground(new Color(140, 180, 200)); 
boutonConnexion.setFocusPainted(false); 
boutonConnexion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));




























JPanel contenu = new JPanel();
    contenu.setLayout(new BoxLayout(contenu, BoxLayout.Y_AXIS));

    JPanel grille = new JPanel(new GridLayout(3,3,20,20));
    for (Scooter sc : parc.listScoot) {
        grille.add(creeScooter(sc));
    }

contenu.add(grille);

//marge autour de la grille.
grille.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


















    JPanel bas = new JPanel();
    bas.setBackground(new Color(210, 180, 140));
    bas.setPreferredSize(new Dimension(1400, 40));
    bas.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

    bas.add(new JLabel("© 2026 🌼ScooterSky"));

    contenu.add(bas);

    JScrollPane scroll = new JScrollPane(contenu);
    this.add(scroll, BorderLayout.CENTER);


scroll.getViewport().setBackground(Color.LIGHT_GRAY);
contenu.setBackground(Color.LIGHT_GRAY);
contenu.setOpaque(true);
grille.setBackground(Color.LIGHT_GRAY);
grille.setOpaque(true);

mb.add(logo);   
mb.add(Box.createRigidArea(new Dimension(60, 0))); 
mb.add(menuParc);
mb.add(Box.createRigidArea(new Dimension(30, 0))); 
mb.add(scooter);
mb.add(Box.createRigidArea(new Dimension(30, 0))); 
mb.add(menuClient);
mb.add(Box.createRigidArea(new Dimension(30, 0))); 
mb.add(menuLocation);
mb.add(Box.createRigidArea(new Dimension(200, 0))); 
mb.add(boutonConnexion);


this.pack();

this.setVisible(true);

}














JPanel creeScooter(Scooter s){
	JPanel card = new JPanel();
    card.setPreferredSize(new Dimension(300, 250));
    card.setBackground(Color.LIGHT_GRAY);
    card.setLayout(new BorderLayout());

    ImageIcon icon = new ImageIcon(s.image); 
    Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
    JLabel imageLabel = new JLabel(new ImageIcon(img));

    JLabel title =
            new JLabel(
                    s.modele,
                    JLabel.CENTER
            );

    title.setFont(
            new Font(
                    "Segoe UI",
                    Font.BOLD,
                    16
            )
    );

    String etatTexte =
            s.getEtat(
                    java.time.LocalDate.now(),
                    1
            );

    JLabel etat =
            new JLabel(
                    etatTexte,
                    JLabel.CENTER
            );

    etat.setFont(
            new Font(
                    "Segoe UI",
                    Font.BOLD,
                    14
            )
    );

    if (etatTexte.equals("loué")) {

        etat.setForeground(Color.RED);

    }

    else {

        etat.setForeground(
                new Color(0,150,0)
        );
    }
    JLabel prix =
            new JLabel(
                    s.getPrixJour() + " €/Jour",
                    JLabel.CENTER
            );
//prix.setFont(
  //          new Font(
    //                "Segoe UI",
      //              Font.PLAIN,
        //            13
          //  )
    //);
    
    prix.setFont(
            new Font(
                    "Segoe UI",
                    Font.BOLD,
                    14
            )
    );
    
    JPanel infos = new JPanel();
    infos.setLayout(
            new GridLayout(3,1)
    );

    infos.setBackground(Color.LIGHT_GRAY);

    infos.add(title);

    infos.add(etat);
    infos.add(prix);

    card.add(imageLabel, BorderLayout.CENTER);

    card.add(infos, BorderLayout.SOUTH);

 
 
    return card;



}
} 