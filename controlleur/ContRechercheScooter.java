import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ContRechercheScooter implements ActionListener {

    Parc parc;
    JTextField date, duree;
    DefaultListModel<Scooter> modelListe;

    public ContRechercheScooter(Parc p, JTextField d, JTextField du, DefaultListModel<Scooter> m) {
        parc = p;
        date = d;
        duree = du;
        modelListe = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            LocalDate d = LocalDate.parse(date.getText());
            int du = Integer.parseInt(duree.getText());

           modelListe.clear(); // vider ancienne liste

            for (Scooter s : parc.listScoot) {
                if (s.isFree(d, du)) {
                    modelListe.addElement(s);
                }
            }

            if (modelListe.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Aucun scooter disponible");
            }
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur de saisie !");
        }
    } 
}  