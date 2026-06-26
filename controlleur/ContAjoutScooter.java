import java.awt.event.*;
import javax.swing.*;

public class ContAjoutScooter implements ActionListener {

    Parc parc;
    JTextField modele, id, km, etat, prix;
    JRadioButton imageOui, imageNon;

    public ContAjoutScooter(Parc p, JTextField m, JTextField i,
                           JTextField k, JTextField e,
                           JTextField pr,JRadioButton oui, JRadioButton non) {

        parc = p;
        modele = m;
        id = i;
        km = k;
        etat = e;
        prix = pr;
        imageOui = oui;
        imageNon = non;
        
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
    	// recupère les valeurs
        try {
            String m = modele.getText();
            int idVal = Integer.parseInt(id.getText());
            int kmVal = Integer.parseInt(km.getText());
            String et = etat.getText();
            float pr = Float.parseFloat(prix.getText());
            String img;

            if (imageOui.isSelected()) {
                img = "oui";
            } else {
                img = "non";
            }
// pour les utliser ici, stocké dans l objet et afficher dans la vue parc 
            new Scooter(m, idVal, kmVal, et, pr, parc, img);
 
            JOptionPane.showMessageDialog(null, "Scooter ajouté !");
        }
         catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur dans les champs !");
        }
    } 
    
} 