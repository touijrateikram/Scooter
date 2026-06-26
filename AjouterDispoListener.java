import java.awt.event.*;

public class AjouterDispoListener implements ActionListener {

    Parc parc;

    public AjouterDispoListener(Parc p) {
        this.parc = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        VueDispoScooter vue = new VueDispoScooter(parc);
        
     
        vue.setVisible(true);
        vue.pack();
    
    
    }  
}   