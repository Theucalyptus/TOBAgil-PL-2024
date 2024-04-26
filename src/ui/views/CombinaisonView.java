package ui.views;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Combinaison;
import jeu.Joueur;
import jeu.peuples.*;
import jeu.pouvoirs.*;
import ui.utils.ImageFactory;

public class CombinaisonView extends JPanel {

    private JLabel peupleLbl = new JLabel();
    private JLabel pouvoirLbl = new JLabel();

    public CombinaisonView(Combinaison comb) {
        super();
        super.setLayout(new FlowLayout());

        if(comb.getDeclin()) {
            super.setBackground(Color.GRAY);
        } else {
            super.setBackground(Color.WHITE);
        }

        Peuple peupleC = comb.getPeuple();
        Pouvoir pouvoirC = comb.getPouvoir();

        this.peupleLbl.setIcon(new ImageIcon(ImageFactory.peupleLogoImage(peupleC.getType())));
        this.peupleLbl.setText(peupleC.getNom());
        this.pouvoirLbl.setIcon(new ImageIcon(ImageFactory.pouvoirLogoImage(pouvoirC.getType())));
        this.pouvoirLbl.setText(pouvoirC.getNom());

        super.add(this.peupleLbl);
        super.add(this.pouvoirLbl);
    }
}
