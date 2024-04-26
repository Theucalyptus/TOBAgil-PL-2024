package ui.views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Combinaison;
import jeu.Joueur;
import jeu.peuples.*;
import jeu.pouvoirs.*;
import ui.utils.ImageFactory;

public class CombinaisonView extends JPanel {
 
    public static class JoueurDebug {
        public static final Peuple peuple = new Elfes();    
        public static final Pouvoir pouvoir = new Alchimistes(); 
    }


    private JLabel peuple = new JLabel();
    private JLabel pouvoir = new JLabel();
    private JLabel enDeclin = new JLabel();

    public CombinaisonView(Combinaison comb) {
        super();
        super.add(this.peuple);
        super.add(this.pouvoir);
        super.add(this.enDeclin);

        if(comb.getDeclin()) {
            super.setBackground(Color.GRAY);
        } else {
            super.setBackground(Color.WHITE);
        }

        Peuple peuple = comb.getPeuple();
        Pouvoir pouvoir = comb.getPouvoir();

        this.peuple.setIcon(new ImageIcon(ImageFactory.peupleLogoImage(peuple.getType())));
        this.peuple.setText(peuple.getNom() + " : " + peuple.getDescription());
        this.pouvoir.setIcon(new ImageIcon(ImageFactory.pouvoirLogoImage(pouvoir.getType())));
        this.pouvoir.setText(pouvoir.getNom() + " : " + pouvoir.getDescription());
        this.peuple.setForeground(Color.WHITE);
        this.pouvoir.setForeground(Color.WHITE);
    }
}
