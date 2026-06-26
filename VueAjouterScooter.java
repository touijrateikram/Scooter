import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class VueAjouterScooter extends JFrame {

    JTextField modele, id, km, etat, prix;
    
    JButton ajouter;
    Parc parc;

    public VueAjouterScooter(Parc p) {
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

        JMenuItem retourner= new JMenuItem("Retourner Scooter");
        scooter.add(retourner);
        retourner.addActionListener(new AjouterRetournerListener(parc));
        
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

        
        
        
        
        
        
        
        
        
        
        
        
        
     
        modele = new JTextField();
        id = new JTextField();
        km = new JTextField();
        etat = new JTextField();
        prix = new JTextField();
        JRadioButton imageOui = new JRadioButton("Oui");
        JRadioButton imageNon = new JRadioButton("Non");

   
        ButtonGroup groupeImage = new ButtonGroup();
        groupeImage.add(imageOui);
        groupeImage.add(imageNon);

        imageOui.setBackground(Color.LIGHT_GRAY);
        imageNon.setBackground(Color.LIGHT_GRAY);

        imageOui.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageNon.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        imageNon.setSelected(true);
        
    
        JPanel card = new JPanel(new BorderLayout(15,15));
        card.setPreferredSize(new Dimension(700, 450));
        card.setBackground(Color.LIGHT_GRAY);
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        
        JPanel panelGauche = new JPanel();
        panelGauche.setBackground(new Color(210, 180, 140));
        panelGauche.setPreferredSize(new Dimension(250, 300));
        panelGauche.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));

        panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));

        
        panelGauche.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titre = new JLabel("Ajouter Scooter");
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

        JLabel l1 = new JLabel("Modèle");
        JLabel l2 = new JLabel("ID");
        JLabel l3 = new JLabel("Kilométrage");
        JLabel l4 = new JLabel("Etat");
        JLabel l5 = new JLabel("Prix / jour");
        JLabel l6 = new JLabel("image");
        

        
     
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font);

        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
        l5.setAlignmentX(Component.CENTER_ALIGNMENT);
        l6.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        modele.setMaximumSize(new Dimension(250, 30));
        id.setMaximumSize(new Dimension(250, 30));
        km.setMaximumSize(new Dimension(250, 30));
        etat.setMaximumSize(new Dimension(250, 30));
        prix.setMaximumSize(new Dimension(250, 30));
        
 
        modele.setAlignmentX(Component.CENTER_ALIGNMENT);
        modele.setBackground(new Color(200, 200, 200));
      
        id.setAlignmentX(Component.CENTER_ALIGNMENT);
        id.setBackground(new Color(200, 200, 200));
        
        km.setAlignmentX(Component.CENTER_ALIGNMENT);
        km.setBackground(new Color(200, 200, 200));
        etat.setAlignmentX(Component.CENTER_ALIGNMENT);
        etat.setBackground(new Color(200, 200, 200));
        prix.setAlignmentX(Component.CENTER_ALIGNMENT);
        prix.setBackground(new Color(200, 200, 200));
        imageOui.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageNon.setAlignmentX(Component.CENTER_ALIGNMENT);
   
       
        panelDroite.add(l1);
        panelDroite.add(modele);
        panelDroite.add(Box.createVerticalStrut(10));
      

        panelDroite.add(l2);
        panelDroite.add(id);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l3);
        panelDroite.add(km);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l4);
        panelDroite.add(etat);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l5);
        panelDroite.add(prix);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l6);
        panelDroite.add(imageOui);
        panelDroite.add(imageNon);
        panelDroite.add(Box.createVerticalStrut(20));


       
        ajouter = new JButton("Ajouter");

        ajouter.setMaximumSize(new Dimension(200, 30));
        ajouter.setMinimumSize(new Dimension(200, 30));
        ajouter.setPreferredSize(new Dimension(200, 30));

        ajouter.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ajouter.setForeground(Color.BLACK);
        ajouter.setBackground(new Color(140, 180, 200));
        ajouter.setFocusPainted(false);
        ajouter.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        ajouter.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDroite.add(ajouter);

        ajouter.addActionListener(
            new ContAjoutScooter(parc, modele, id, km, etat, prix, imageOui, imageNon)
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