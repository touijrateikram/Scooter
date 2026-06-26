import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

public class VueLocation extends JFrame {

    Parc parc;
    Scooter scooter;
    JTextField date, duree, prix;
    JList<Client> listeClients;
    DefaultListModel<Client> modelClients;
    JButton valider;

    public VueLocation(Parc p, Scooter s, LocalDate d, int du) {

        this.parc = p;
        this.scooter = s;
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
        JMenu menuscooter= new JMenu("Scooter");
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
        menuscooter.add(dispo);
        dispo.addActionListener(new AjouterDispoListener(parc));

        JMenuItem retourner= new JMenuItem("Retourner Scooter");
        menuscooter.add(retourner);
        retourner.addActionListener(new AjouterRetournerListener(parc));
        
        JMenuItem ajouterLocation = new JMenuItem("Ajouter Location");
        menuLocation.add(ajouterLocation);
        ajouterLocation.addActionListener(new AjouterLocationListener(parc));
        
        Font police = new Font("Comic Sans MS", Font.BOLD, 20);
        Font ipolice = new Font("Arial", Font.BOLD, 15);
 
        menuParc.setFont(police);
        menuscooter.setFont(police);
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
        String scootText = (scooter == null) ? "" : scooter.toString();
        JTextField scooterField = new JTextField(scootText);
        scooterField.setEditable(false);

        String dateText = (d == null) ? "" : d.toString();
        date = new JTextField(dateText);
        date.setEditable(false);

        String dureeText = (du == 0) ? "" : String.valueOf(du);
        duree = new JTextField(dureeText);
        duree.setEditable(false);

        String prixText = (scooter == null) ? "" :
                String.valueOf(scooter.getPrixJour() * du);

        prix = new JTextField(prixText);
        prix.setEditable(false);

      
        JPanel card = new JPanel(new BorderLayout(15,15));
        card.setPreferredSize(new Dimension(700, 450));
        card.setBackground(Color.LIGHT_GRAY);
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

       
        JPanel panelGauche = new JPanel();
        panelGauche.setBackground(new Color(210, 180, 140));
        panelGauche.setPreferredSize(new Dimension(250, 300));
        panelGauche.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));

        JLabel titre = new JLabel("Valider Location");
        JLabel emojis = new JLabel("📋");

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

        JLabel l1 = new JLabel("Scooter");
        JLabel l2 = new JLabel("Date");
        JLabel l3 = new JLabel("Durée");
        JLabel l4 = new JLabel("Prix total");
        JLabel l5 = new JLabel("Client");

        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);

        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
        l5.setAlignmentX(Component.CENTER_ALIGNMENT);

       

        Dimension taille = new Dimension(250,30);

        scooterField.setMaximumSize(taille);
        date.setMaximumSize(taille);
        duree.setMaximumSize(taille);
        prix.setMaximumSize(taille);

        scooterField.setAlignmentX(Component.CENTER_ALIGNMENT);
        date.setAlignmentX(Component.CENTER_ALIGNMENT);
        duree.setAlignmentX(Component.CENTER_ALIGNMENT);
        prix.setAlignmentX(Component.CENTER_ALIGNMENT);

        scooterField.setBackground(new Color(200,200,200));
        date.setBackground(new Color(200,200,200));
        duree.setBackground(new Color(200,200,200));
        prix.setBackground(new Color(200,200,200));

      
        modelClients = new DefaultListModel<>();

        for(Client c : parc.listClient){
        
            modelClients.addElement(c);
        }

        listeClients = new JList<>(modelClients);
        listeClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listeClients.setBackground(new Color(210,180,140));

        JScrollPane scroll = new JScrollPane(listeClients);
        scroll.setMaximumSize(new Dimension(300,120));
        scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

   
        panelDroite.add(Box.createVerticalGlue());

        panelDroite.add(l1);
        panelDroite.add(scooterField);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l2);
        panelDroite.add(date);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l3);
        panelDroite.add(duree);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l4);
        panelDroite.add(prix);
        panelDroite.add(Box.createVerticalStrut(10));

        panelDroite.add(l5);
        panelDroite.add(scroll);
        panelDroite.add(Box.createVerticalStrut(20));

      
        valider = new JButton("Valider");

        valider.setMaximumSize(new Dimension(200,30));
        valider.setFont(new Font("Segoe UI", Font.BOLD, 14));
        valider.setBackground(new Color(140,180,200));
        valider.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        valider.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDroite.add(valider);

        panelDroite.add(Box.createVerticalGlue());

        valider.addActionListener(
        	    new ContLocation(
        	        parc,
        	        listeClients,
        	        scooter,
        	        date,
        	        duree
        	    )
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
        mb.add(menuscooter);
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