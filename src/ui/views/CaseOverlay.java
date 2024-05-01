package ui.views;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jeu.Case;
import jeu.TypesSymboles;
import jeu.batiments.TypesBatiments;
import jeu.peuples.Peuple;
import jeu.peuples.TypesPeuples;
import ui.utils.ImageFactory;

public class CaseOverlay extends JPanel {

    private final static GridLayout layout = new GridLayout(2, 2);

    private final JLabel pionsLbl;
    private final JLabel constructionLbl;
    private final JLabel symboleLbl;

    public CaseOverlay(CaseView parent) {
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

        this.symboleLbl = new JLabel();
        this.symboleLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        this.symboleLbl.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.symboleLbl.setIconTextGap(2);

        super.add(this.pionsLbl);
        super.add(this.constructionLbl);
        super.add(this.symboleLbl);
        super.setOpaque(false);

    }


    /**
     * Met à jour l'overlay d'une case en fonction des caractéristiques de la case sous-jacante.
     */
    public void updateOverlay(Case maCase) {


        // Affichages des pions
        int numberPions = maCase.getNombrepions();
        if(numberPions > 0) {
            Peuple peuple = maCase.getPeuple();
            Boolean enDeclin = false;

            ImageIcon icon;
            icon = new ImageIcon(ImageFactory.peupleTroupeImage(peuple.getType(), enDeclin));
            this.pionsLbl.setIcon(icon);
            this.pionsLbl.setText(Integer.toString(numberPions));
        } else {
            this.pionsLbl.setText("");
            this.pionsLbl.setIcon(null);
        }


        // Affichages des batiments
        TypesBatiments batT = TypesBatiments.AUCUN;
        if(batT != TypesBatiments.AUCUN) {
            int nbBatiments = new Random().nextInt(2) + 1;
            ImageIcon icon = new ImageIcon(ImageFactory.batimentsImage(batT));
            this.constructionLbl.setIcon(icon);
            this.constructionLbl.setText(Integer.toString(nbBatiments));
        } else {
            this.constructionLbl.setText((""));
            this.constructionLbl.setIcon(null);
        }


        // Affichages des ressources
        TypesSymboles symT = maCase.getTypeRessource();
        if(symT != TypesSymboles.AUCUN) {
            this.symboleLbl.setIcon(new ImageIcon(ImageFactory.symboleImage(symT)));
        } else {
            this.symboleLbl.setIcon(null);
        }

    }


}
