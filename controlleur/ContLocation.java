import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;

public class ContLocation
        implements ActionListener {

    Parc parc;

    JList<Client> listeClients;

    Scooter scooter;

    JTextField date;
    JTextField duree;

    public ContLocation(
            Parc p,
            JList<Client> list,
            Scooter s,
            JTextField d,
            JTextField du) {

        this.parc = p;

        this.listeClients = list;

        this.scooter = s;

        this.date = d;

        this.duree = du;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Client client =
                listeClients.getSelectedValue();

        if (client == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Choisis un client !"
            );

            return;
        }

        try {

            LocalDate d =
                    LocalDate.parse(
                            date.getText()
                    );

            int du =
                    Integer.parseInt(
                            duree.getText()
                    );

            new Location(
                    d,
                    du,
                    client,
                    scooter
            );

            JOptionPane.showMessageDialog(
                    null,
                    " Location validée !"
            );
        }

        catch (Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    null, 
                    "Erreur dans les champs !"
            );
        }
    } 
}  