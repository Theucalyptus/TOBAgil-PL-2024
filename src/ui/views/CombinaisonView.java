package ui.views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

    public CombinaisonView() {
        super();
        super.add(this.peuple);
        super.add(this.pouvoir);
        super.add(this.enDeclin);
    }

    public void setCombinaison(Combinaison comb) {
        
        if(comb.estEnDeclin()) {
            super.setBackground(Color.GRAY);
        } else {
            super.setBackground(Color.WHITE);
        }

        System.out.println("TODO : CombinaisonView : setCombinaison doit utiliser la Combinaison");
        this.peuple.setIcon(new ImageIcon(ImageFactory.peupleLogoImage(JoueurDebug.peuple.getTypePeuple())));
        this.peuple.setText(JoueurDebug.peuple.getNom() + " : " + JoueurDebug.peuple.getDescription());
        this.pouvoir.setIcon(new ImageIcon(ImageFactory.pouvoirLogoImage(JoueurDebug.pouvoir.getTypePouvoir())));
        this.pouvoir.setText(JoueurDebug.pouvoir.getNom() + " : " + JoueurDebug.pouvoir.getDescription());
        this.peuple.setForeground(Color.WHITE);
        this.pouvoir.setForeground(Color.WHITE);
    }

}
