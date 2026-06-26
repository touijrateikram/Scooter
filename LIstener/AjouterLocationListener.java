import java.awt.event.*;

public class AjouterLocationListener implements ActionListener {

    Parc parc;

    public AjouterLocationListener(Parc p) {
        this.parc = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        VueLocation vue = new VueLocation(parc, null, null, 0);
  
        vue.setVisible(true);
        vue.pack();

    
    } 
} 
 
