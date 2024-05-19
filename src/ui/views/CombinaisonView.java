package ui.views;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Image;
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
        super.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        super.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Peuple peupleC = comb.getPeuple();
        Pouvoir pouvoirC = comb.getPouvoir();

        Image image_peuple = ImageFactory.peupleLogoImage(peupleC.getType(), comb.getDeclin());

        ImageIcon imageTemp = new ImageIcon(image_peuple.getScaledInstance(256, 128,
        java.awt.Image.SCALE_SMOOTH));

        this.peupleLbl.setIcon(imageTemp);

        //this.peupleLbl.setText(peupleC.getNom());

        Image image_pouvoirs = ImageFactory.pouvoirLogoImage(pouvoirC.getType(), comb.getDeclin());

        this.pouvoirLbl.setIcon(new ImageIcon(image_pouvoirs.getScaledInstance(128, 128,
        java.awt.Image.SCALE_SMOOTH)));

        //this.pouvoirLbl.setText(pouvoirC.getNom());


        if (comb.getDeclin()) {
            super.add(this.pouvoirLbl);
            super.add(this.peupleLbl);
        } else {
            super.add(this.peupleLbl);
            super.add(this.pouvoirLbl);
        }
        
    }

    
}
