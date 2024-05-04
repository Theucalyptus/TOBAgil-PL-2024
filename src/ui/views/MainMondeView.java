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

    public final int nombreLignes;
    public final int nombreColonnes;

    private GridLayout layout;
    private List<CaseView> cases;
    
    private Selecteur<CaseView> selecteurCase;

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
    
    //Mouse Listener pour gérer la sélection des cases
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
