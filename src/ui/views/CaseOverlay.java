package ui.views;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jeu.Case;
import jeu.TypesSymboles;
import jeu.batiments.TypesBatiments;
import jeu.peuples.Peuple;
import ui.utils.ImageFactory;

public class CaseOverlay extends JPanel {

    private static final GridLayout LAYOUT = new GridLayout(2, 3);

    private final JLabel pionsLbl;
    private final List<JLabel> constructionsLbls;
    private final JLabel symboleLbl;

    public CaseOverlay(CaseView parent) {
        super();
        // pour que l'overlay ne soit pas en cascade mais bien juste au dessus
        super.setAlignmentX(0);
        super.setLayout(LAYOUT);
        // marge de l'overlay par rapport au bord de la case
        super.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));


        this.pionsLbl = new JLabel();
        this.pionsLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        this.pionsLbl.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.pionsLbl.setIconTextGap(2);

        this.constructionsLbls = new ArrayList<>();

        this.symboleLbl = new JLabel();
        this.symboleLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        this.symboleLbl.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.symboleLbl.setIconTextGap(2);

        super.add(this.pionsLbl);
        super.add(this.symboleLbl);
        super.setOpaque(false);

    }


    /**
     * Met à jour l'overlay d'une case en fonction des caractéristiques de la case
     * sous-jacante.
     * @param maCase La case dont on met à jour l'affichage.
     */
    public void updateOverlay(Case maCase) {


        // Affichages des pions
        int numberPions = maCase.getNombrepions();
        if (numberPions > 0) {
            Peuple peuple = maCase.getPeuple();
            Boolean enDeclin = false;

            ImageIcon icon;
            icon = new ImageIcon(ImageFactory.peupleTroupeImage(peuple.getType(),
                enDeclin));
            this.pionsLbl.setIcon(icon);
            this.pionsLbl.setText(Integer.toString(numberPions));
        } else {
            this.pionsLbl.setText("");
            this.pionsLbl.setIcon(null);
        }


        // Affichages des batiments
        for(JLabel construLbl : this.constructionsLbls) {
            super.remove(construLbl);
        }
        this.constructionsLbls.clear();
        for (Entry<TypesBatiments, Integer> e : maCase.getBatiment().entrySet()) {
            TypesBatiments batT = e.getKey();
            int batN = e.getValue();
            if (batT != TypesBatiments.AUCUN && batN > 0) {
                this.addBatimentType(batT, batN);
            }
        }



        // Affichages des ressources
        TypesSymboles symT = maCase.getTypeRessource();
        if (symT != TypesSymboles.AUCUN) {
            this.symboleLbl.setIcon(new ImageIcon(ImageFactory.symboleImage(symT)));
        } else {
            this.symboleLbl.setIcon(null);
        }

    }


    private void addBatimentType(TypesBatiments type, int number) {
        JLabel constructionLbl = new JLabel();
        constructionLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        constructionLbl.setVerticalTextPosition(SwingConstants.BOTTOM);
        constructionLbl.setIconTextGap(2);

        ImageIcon icon = new ImageIcon(ImageFactory.batimentsImage(type));
        constructionLbl.setIcon(icon);
        constructionLbl.setText(Integer.toString(number));

        this.constructionsLbls.add(constructionLbl);
        super.add(constructionLbl);
    }


}
