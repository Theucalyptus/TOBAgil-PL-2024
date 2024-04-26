package ui.views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Combinaison;
import jeu.Joueur;

public class MainJoueurView extends JPanel {
 
    private JLabel nom = new JLabel();
    private List<CombinaisonView> combViews;

    public MainJoueurView() {
        super();
        super.add(this.nom);
        this.combViews = new ArrayList<>();
    }


    public void setJoueur(Joueur joueur) {
        for(CombinaisonView cbv : this.combViews) {
            super.remove(cbv);
        }
        this.combViews.clear();

        //for(Combinaison comb : joueur.getCombinaisonList()) {
        Combinaison comb = joueur.getCombinaison();
        this.combViews.add(new CombinaisonView(comb));
        //}
    }

}
