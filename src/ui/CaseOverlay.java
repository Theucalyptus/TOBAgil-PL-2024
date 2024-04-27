package ui;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jeu.batiments.TypesBatiments;
import jeu.peuples.TypesPeuples;
import ui.utils.ImageFactory;

public class CaseOverlay extends JPanel {

    private final JLabel pionsLbl;
    private final JLabel constructionLbl;

    private final static GridLayout layout = new GridLayout(2, 2);

    public CaseOverlay(CaseMonde parent) {
        super();
        // pour que l'overlay ne soit pas en cascade mais bien juste au dessus
        super.setAlignmentX(0);
        super.setLayout(layout);
        // marge de l'overlay par rapport au bord de la case
        super.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4)); 
    
        
        this.pionsLbl = new JLabel();
        this.pionsLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        this.pionsLbl.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.pionsLbl.setIconTextGap(2);

        this.constructionLbl = new JLabel();
        this.constructionLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        this.constructionLbl.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.constructionLbl.setIconTextGap(2);

        this.updateOverlay();


        super.add(this.pionsLbl);
        super.add(this.constructionLbl);
        super.setOpaque(false);
    }


    /**
     * Met à jour l'overlay d'une case en fonction des caractéristiques de la case sous-jacante.
     */
    public void updateOverlay() {

        // @TODO à changer par un truc qui récup les infos depuis la case
        int numberPions = new Random().nextInt(15);
        
        // si il y a des pions sur la case
        if(numberPions > 0) {
            TypesPeuples peupleType = (numberPions%2 == 0 ? TypesPeuples.AMAZONES : TypesPeuples.ELFES);
            Boolean enDeclin = (new Random().nextInt(999) % 2) == 0;
             
            ImageIcon icon;
            icon = new ImageIcon(ImageFactory.peupleTroupeImage(peupleType, enDeclin));
            this.pionsLbl.setIcon(icon);
            this.pionsLbl.setText(Integer.toString(numberPions));
        } else {
            this.pionsLbl.setText("");
            this.pionsLbl.setIcon(null);
        }

        // TODO : à connecter au modèle !
        int temp = TypesBatiments.values().length;
        TypesBatiments batT = TypesBatiments.values()[new Random().nextInt(temp)];
        if(batT != TypesBatiments.AUCUN) {
            int nbBatiments = new Random().nextInt(2) + 1;
            ImageIcon icon = new ImageIcon(ImageFactory.batimentsImage(batT));
            this.constructionLbl.setIcon(icon);
            this.constructionLbl.setText(Integer.toString(nbBatiments));
        } else {
            this.constructionLbl.setText((""));
            this.constructionLbl.setIcon(null);
        }

    }

    
}
