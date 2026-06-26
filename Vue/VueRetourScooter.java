import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class VueRetourScooter extends JFrame {

    JTextField idScooter, km, etat;
    JButton retourner;
    Parc parc;

    public VueRetourScooter(Parc p) {
        this.parc = p;
        
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

        JMenuItem afficherParc= new JMenuItem("Afficher Parc");
        menuParc.add(afficherParc);

        afficherParc.addActionListener(new AfficherParcListener(parc));

        JMenuItem ajouterScooter= new JMenuItem("Ajouter Scooter");
        menuParc.add(ajouterScooter);
        ajouterScooter.addActionListener(new AjouterScooterListener(parc));

        JMenuItem dispo= new JMenuItem("Disponible ?");
        scooter.add(dispo);
        dispo.addActionListener(new AjouterDispoListener(parc));

        JMenuItem rretourner= new JMenuItem("Retourner Scooter");
        scooter.add(rretourner);
        rretourner.addActionListener(new AjouterRetournerListener(parc));
        
        JMenuItem ajouterLocation = new JMenuItem("Ajouter Location");
        menuLocation.add(ajouterLocation);
        ajouterLocation.addActionListener(new AjouterLocationListener(parc));

        Font police = new Font("Comic Sans MS", Font.BOLD, 20);
        Font ipolice = new Font("Arial", Font.BOLD, 15);

        menuParc.setFont(police);
        scooter.setFont(police);
        menuClient.setFont(police);
        menuLocation.setFont(police);

        afficherParc.setFont(ipolice);
        ajouterScooter.setFont(ipolice);
        dispo.setFont(ipolice);
        rretourner.setFont(ipolice);
        ajouterClient.setFont(ipolice);
        ajouterLocation.setFont(ipolice);

        ImageIcon icon = new ImageIcon("logo.jpg");
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel logo = new JLabel("🌼Scootersky", icon, JLabel.CENTER);
        logo.setIconTextGap(10);
        logo.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        logo.setForeground(new Color(101, 67, 33));

        mb.setBorder(new LineBorder(Color.BLACK, 2));
        mb.setPreferredSize(new Dimension(70, 200));

        JButton boutonConnexion = new JButton("Se connecter / S'inscrire");
        
        boutonConnexion.setMaximumSize(new Dimension(200, 30));
        boutonConnexion.setMinimumSize(new Dimension(200, 30));
        boutonConnexion.setPreferredSize(new Dimension(200, 30));
        
        boutonConnexion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boutonConnexion.setForeground(new Color(0,0,0));
        boutonConnexion.setBackground(new Color(140, 180, 200));
        boutonConnexion.setFocusPainted(false);
        boutonConnexion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        this.setTitle("Retour Scooter");

        idScooter = new JTextField();
        km = new JTextField();
        etat = new JTextField();

        JPanel card = new JPanel(new BorderLayout(15,15));
        card.setPreferredSize(new Dimension(700, 450));
        card.setBackground(Color.LIGHT_GRAY);
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        JPanel panelGauche = new JPanel();
        panelGauche.setBackground(new Color(210, 180, 140));
        panelGauche.setPreferredSize(new Dimension(250, 300));
        panelGauche.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));

        JLabel titre = new JLabel("Retour Scooter");
        JLabel emojis = new JLabel("🔄");

        titre.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        emojis.setFont(new Font("Comic Sans MS", Font.BOLD, 50));

        titre.setAlignmentX(Component.CENTER_ALIGNMENT);
        emojis.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelGauche.add(Box.createVerticalGlue());
        panelGauche.add(titre);
        panelGauche.add(Box.createVerticalStrut(10));
        panelGauche.add(emojis);
        panelGauche.add(Box.createVerticalGlue());
        
        JPanel panelDroite = new JPanel();
        panelDroite.setLayout(new BoxLayout(panelDroite, BoxLayout.Y_AXIS));
        panelDroite.setBackground(Color.LIGHT_GRAY);

        Font font = new Font("Comic Sans MS", Font.BOLD, 18);

        JLabel l1 = new JLabel("ID Scooter");
        JLabel l2 = new JLabel("Kilométrage");
        JLabel l3 = new JLabel("Etat");

        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);

        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);

    
        Dimension taille = new Dimension(250,30);

        idScooter.setMaximumSize(taille);
        idScooter.setPreferredSize(taille);

        km.setMaximumSize(taille);
        km.setPreferredSize(taille);

        etat.setMaximumSize(taille);
        etat.setPreferredSize(taille);

        idScooter.setAlignmentX(Component.CENTER_ALIGNMENT);
        km.setAlignmentX(Component.CENTER_ALIGNMENT);
        etat.setAlignmentX(Component.CENTER_ALIGNMENT);

        idScooter.setBackground(new Color(200,200,200));
        km.setBackground(new Color(200,200,200));
        etat.setBackground(new Color(200,200,200));

        panelDroite.add(Box.createVerticalGlue()); 
        
        panelDroite.add(l1);
        panelDroite.add(idScooter);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l2);
        panelDroite.add(km);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l3);
        panelDroite.add(etat);
        panelDroite.add(Box.createVerticalStrut(20));
        
        retourner = new JButton("Valider retour");

        retourner.setMaximumSize(new Dimension(200, 30));
        retourner.setMinimumSize(new Dimension(200, 30));
        retourner.setPreferredSize(new Dimension(200, 30));

        retourner.setFont(new Font("Segoe UI", Font.BOLD, 14));
        retourner.setBackground(new Color(140, 180, 200));
        retourner.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        retourner.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDroite.add(retourner);
        panelDroite.add(Box.createVerticalGlue()); 
        
        retourner.addActionListener(
        	    new ContRetourScooter(parc, idScooter, km, etat)
        	);
        
        card.add(panelGauche, BorderLayout.WEST);
        card.add(panelDroite, BorderLayout.CENTER);

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        JPanel GrandPanel = new JPanel(new GridBagLayout());
        GrandPanel.setBackground(Color.LIGHT_GRAY);
        GrandPanel.add(card);

        this.add(GrandPanel, BorderLayout.CENTER);
        
        JPanel bas = new JPanel();
        bas.setBackground(new Color(210, 180, 140));
        bas.setPreferredSize(new Dimension(1400, 40));
        bas.add(new JLabel("© 2026 🌼ScooterSky"));

        this.add(bas, BorderLayout.NORTH); 

     
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
 

        this.add(bas, BorderLayout.SOUTH);
         
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }  
}