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

    private JLabel peuple = new JLabel();
    private JLabel pouvoir = new JLabel();
    private JLabel enDeclin = new JLabel();

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

        this.peuple.setIcon(new ImageIcon(ImageFactory.peupleLogoImage(peupleC.getType())));
        this.peuple.setText(peupleC.getNom() + " : " + peupleC.getDescription());
        this.pouvoir.setIcon(new ImageIcon(ImageFactory.pouvoirLogoImage(pouvoirC.getType())));
        this.pouvoir.setText(pouvoirC.getNom() + " : " + pouvoirC.getDescription());
        this.peuple.setForeground(Color.WHITE);
        this.pouvoir.setForeground(Color.WHITE);

        super.add(this.peuple);
        super.add(this.pouvoir);
        super.add(this.enDeclin);
    }
}
