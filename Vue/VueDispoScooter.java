import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.time.LocalDate;

public class VueDispoScooter extends JFrame {

    JTextField idScooter, idClient, date, duree;
    JButton louer;
    Parc parc;

    public VueDispoScooter(Parc p) {
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

        JMenuItem ajouterLocation = new JMenuItem("Ajouter Location");
        menuLocation.add(ajouterLocation);
//ajouterLocation.addActionListener(new AjouterLocationListener(parc));


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

        JMenuItem retourner= new JMenuItem("Retourner Scooter");
        scooter.add(retourner);
        retourner.addActionListener(new AjouterRetournerListener(parc));

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
        
        
        this.setTitle("Louer Scooter");

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   
        date = new JTextField(); 
        duree = new JTextField();
        JButton rechercher;
        
   
        JList<Scooter> listeScooters;
        DefaultListModel<Scooter> modelListe;

        
        
        Dimension taille = new Dimension(250, 30);
        date.setMaximumSize(taille);
        date.setPreferredSize(taille);

        duree.setMaximumSize(taille);
        duree.setPreferredSize(taille);

     
        JPanel card = new JPanel(new BorderLayout(15,15));
        card.setPreferredSize(new Dimension(700, 450));
        card.setBackground(Color.LIGHT_GRAY);
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


     
        JPanel panelGauche = new JPanel();
        panelGauche.setBackground(new Color(210, 180, 140));
        panelGauche.setPreferredSize(new Dimension(250, 300));
        panelGauche.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));

        JLabel titre = new JLabel("Louer Scooter");
        JLabel emojis = new JLabel("🛵");

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

        JLabel l3 = new JLabel("Date début");
        JLabel l4 = new JLabel("Durée (jours)");

 
        l3.setFont(font);
        l4.setFont(font);


        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);

  
        date.setMaximumSize(new Dimension(250, 30));
        duree.setMaximumSize(new Dimension(250, 30));


        date.setAlignmentX(Component.CENTER_ALIGNMENT);
        duree.setAlignmentX(Component.CENTER_ALIGNMENT);


        date.setBackground(new Color(200, 200, 200));
        duree.setBackground(new Color(200, 200, 200));



        panelDroite.add(Box.createVerticalGlue());
        panelDroite.add(l3);
        panelDroite.add(date);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l4);
        panelDroite.add(duree);
        panelDroite.add(Box.createVerticalStrut(20));

       
        modelListe = new DefaultListModel<>();
     
        listeScooters = new JList<>(modelListe);
        listeScooters.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

       
        listeScooters.setBackground(new Color(210, 180, 140));
        
        listeScooters.setSelectionBackground(new Color(210, 180, 140));
        listeScooters.setSelectionForeground(Color.BLACK);

        JScrollPane scroll = new JScrollPane(listeScooters);

        scroll.setMaximumSize(new Dimension(300, 120));
        scroll.setPreferredSize(new Dimension(300, 120));

        scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        

        ajouterLocation.addActionListener(e -> {
            Scooter s =
                    listeScooters.getSelectedValue();

            if (s == null) {

                JOptionPane.showMessageDialog(
                        null,
                        "Choisis un scooter !"
                );

                return;
            }

            try {
                LocalDate d =
                        LocalDate.parse(date.getText());

                int du =
                       Integer.parseInt(
                                duree.getText()
                        );
                new VueLocation(
                        parc,
                        s,
                        d,
                        du
                );
            }

            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                       "Erreur !"
                );
            }
        });

        panelDroite.add(scroll);
        panelDroite.add(Box.createVerticalStrut(10));

       
        louer = new JButton("Louer");

        louer.setMaximumSize(new Dimension(200, 30));
        louer.setPreferredSize(new Dimension(200, 30));

        louer.setFont(new Font("Segoe UI", Font.BOLD, 14));
        louer.setForeground(Color.BLACK);
        louer.setBackground(new Color(140, 180, 200));
        louer.setFocusPainted(false);
        louer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        louer.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        
 
        rechercher = new JButton("Rechercher");
        rechercher.setFont(new Font("Segoe UI", Font.BOLD, 14));
        rechercher.setForeground(Color.BLACK);
        rechercher.setBackground(new Color(140, 180, 200));
        rechercher.setFocusPainted(false);
        rechercher.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        //louer.setAlignmentX(Component.CENTER_ALIGNMENT);

        rechercher.setMaximumSize(new Dimension(200, 30));
        rechercher.setAlignmentX(Component.CENTER_ALIGNMENT);
        rechercher.setPreferredSize(new Dimension(200, 30));
        panelDroite.add(rechercher);
        panelDroite.add(Box.createVerticalStrut(10));


        panelDroite.add(Box.createVerticalStrut(10));
        panelDroite.add(louer);
        panelDroite.add(Box.createVerticalGlue());
      
        louer.addActionListener(
        	    new ContLouerScooter(parc, listeScooters, date, duree)
        	);
        
        rechercher.addActionListener(
        		new ContRechercheScooter(parc, date, duree, modelListe)
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