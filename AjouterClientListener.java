import java.awt.event.*;

public class AjouterClientListener implements ActionListener {

    Parc parc;

    public AjouterClientListener(Parc p) {
        this.parc = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    	        VueAjouterClient vue =
    	                new VueAjouterClient(parc);

    	        vue.setVisible(true);

    	        vue.pack();

    } 
}  