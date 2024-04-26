package ui.views;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Joueur;

public class MainJoueurView extends JPanel {
 
    private JLabel nom = new JLabel();
    //private List<CombinaisonView> combViews;

    public MainJoueurView() {
        super();
        super.add(this.nom);
    }


    public void setJoueur(Joueur joueur) {
        
    }

}
