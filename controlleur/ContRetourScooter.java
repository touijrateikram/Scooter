import java.awt.event.*;
import javax.swing.*;

public class ContRetourScooter implements ActionListener {

    Parc parc;
    JTextField idScooter, km, etat;

    public ContRetourScooter(Parc p, JTextField s,
                             JTextField k, JTextField e) {

        parc = p;
        idScooter = s;
        km = k;
        etat = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int idS = Integer.parseInt(idScooter.getText());
            int kmVal = Integer.parseInt(km.getText());
            String et = etat.getText();

            Scooter scooter = null;

            //  chercher scooter a retourner 
            for (Scooter s : parc.listScoot) {
                if (s.num_id == idS) {
                    scooter = s;
                    break;
                }
            }

            if (scooter == null) {
                JOptionPane.showMessageDialog(null, "Scooter introuvable !");
                 return;
            }

      
            boolean ok = scooter.rendre(kmVal, et);

            if (ok) {
                JOptionPane.showMessageDialog(null, "Retour effectué !");
            } else {
                JOptionPane.showMessageDialog(null, "Aucune location en cours !");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur dans les champs !");
        } 
    }
}  