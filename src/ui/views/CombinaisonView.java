package ui.views;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Combinaison;
import jeu.peuples.*;
import jeu.pouvoirs.*;
import ui.utils.ImageFactory;

public class CombinaisonView extends JPanel {

    /** Label affichant le peuple de la combinaison. */
    private JLabel peupleLbl = new JLabel();
    /** Label affichant le pouvoir de la combinaison. */
    private JLabel pouvoirLbl = new JLabel();

    /**
     * Construit la vue d'une combinaison.
     * @param comb la combinaison à afficher
     */
    public CombinaisonView(Combinaison comb) {
        super();
        super.setLayout(new FlowLayout());

        if (comb.getDeclin()) {
            super.setBackground(Color.GRAY);
        } else {
            super.setBackground(Color.WHITE);
        }

        Peuple peupleC = comb.getPeuple();
        Pouvoir pouvoirC = comb.getPouvoir();

        this.peupleLbl.setIcon(new ImageIcon(
            ImageFactory.peupleLogoImage(peupleC.getType())));

        this.peupleLbl.setText(peupleC.getNom());
        this.pouvoirLbl.setIcon(new ImageIcon(
            ImageFactory.pouvoirLogoImage(pouvoirC.getType())));

        this.pouvoirLbl.setText(pouvoirC.getNom());

        super.add(this.peupleLbl);
        super.add(this.pouvoirLbl);
    }
}
