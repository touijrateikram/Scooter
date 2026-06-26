import java.awt.event.*;

public class AjouterRetournerListener implements ActionListener {

    Parc parc;

    public AjouterRetournerListener(Parc p) {
        this.parc = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        VueRetourScooter vue = new VueRetourScooter(parc);
 
        vue.setVisible(true);
        vue.pack();
     
    }
}    