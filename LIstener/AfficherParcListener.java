import java.awt.event.*;


public class AfficherParcListener implements ActionListener {

    Parc parc;

    public AfficherParcListener(Parc p) {
        this.parc = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new VueParc(parc);

    }
}   
