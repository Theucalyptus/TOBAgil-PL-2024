package ui.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import jeu.Monde;
import ui.selecteur.Selecteur;

public class MainMondeView extends JPanel {

    /** Le nombre de ligne à afficher. */
    private final int nombreLignes;
    /** Le nombre de colonne à afficher. */
    private final int nombreColonnes;
    /** Le layout de mise en page. */
    private GridLayout layout;
    /** La liste des cases affichées. */
    private List<CaseView> cases;
    /** Le sélecteur de case. */
    private Selecteur<CaseView> selecteurCase;

    /**
     * Construit la vue affichant un monde du jeu.
     * @param monde le monde à afficher
     * @param selecteurCase le sélecteur de case
     */
    public MainMondeView(Monde monde, Selecteur<CaseView> selecteurCase) {
        super();
        this.nombreColonnes = monde.getDimX();
        this.nombreLignes = monde.getDimY();
        this.layout = new GridLayout(nombreLignes, nombreColonnes);
        super.setLayout(this.layout);

        MouseListenerCases trace = new MouseListenerCases();

        this.cases = new ArrayList<CaseView>();
        for (int i = 0; i < nombreLignes; i++) {
            for (int j = 0; j < nombreColonnes; j++) {
                CaseView temp = new CaseView(monde.getCase(i, j));
                temp.addMouseListener(trace);
                cases.add(temp);
                super.add(temp);
            }
        }

        this.selecteurCase = selecteurCase;

    }

    public class MouseListenerCases extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            CaseView entree = (CaseView) e.getSource();
            if (selecteurCase.getSelection() != entree) {
                entree.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            CaseView entree = (CaseView) e.getSource();
            if (selecteurCase.getSelection() != entree) {
                entree.setBorder(BorderFactory.createEmptyBorder());
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            CaseView entree = (CaseView) e.getSource();
            CaseView caseSelectionnee = selecteurCase.getSelection();

            if (caseSelectionnee != entree && caseSelectionnee != null) {
            	caseSelectionnee.setBorder(BorderFactory.createEmptyBorder());
            }

            entree.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
            selecteurCase.setSelection(entree);
        }
    }

}
