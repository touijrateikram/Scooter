import java.awt.event.*;
import javax.swing.*;

public class ContAjoutClient implements ActionListener {

    Parc parc;
    JTextField id, nom, prenom, mail;

    public ContAjoutClient(Parc p, JTextField i, JTextField n,
                           JTextField pr, JTextField m) {

        parc = p;
        id = i;
        nom = n;
        prenom = pr;
        mail = m;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
    	// recupère les valeurs
        try {
            int idVal = Integer.parseInt(id.getText());
            String n = nom.getText();
            String pr = prenom.getText();
            String m = mail.getText();
 
            new Client(idVal, n, pr, m, parc);

            JOptionPane.showMessageDialog(null, "Client ajouté !");
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur dans les champs !");
        }
    }
     
    
}  