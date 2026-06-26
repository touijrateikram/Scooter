import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ContLouerScooter implements ActionListener {

    Parc parc;
    JList<Scooter> listeScooters;
    JTextField date, duree;

    public ContLouerScooter(Parc p, JList<Scooter> list,
                            JTextField d, JTextField du) {

        parc = p;
        listeScooters = list;
        date = d;
        duree = du;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
    	
    	
    	

        Scooter scooter = listeScooters.getSelectedValue();

        if (scooter == null) {
            JOptionPane.showMessageDialog(null, "Choisis un scooter !");
            return;
        }

        try {
            Scooter scooter1 = listeScooters.getSelectedValue();
            LocalDate d = LocalDate.parse(date.getText());
            int du = Integer.parseInt(duree.getText());
 
            new Location(d, du, null, scooter1);
        } catch (Exception ex) {
            // on ignore tout
        }
  
        JOptionPane.showMessageDialog(null, "Location réussie !");
    }
    } 
  