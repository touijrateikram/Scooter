import java.awt.event.*;

public class AjouterScooterListener implements ActionListener {
    Parc parc;

    public AjouterScooterListener(Parc p) {
        this.parc = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	

        VueAjouterScooter vue = new VueAjouterScooter(parc);

        vue.setVisible(true);
         vue.pack();

    } 
}  