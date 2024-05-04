package ui.views;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import jeu.Monde;

public class MainMondeView extends JPanel {

    public final int nombreLignes;
    public final int nombreColonnes;

    private GridLayout layout;
    private List<CaseView> cases;

    public MainMondeView(Monde monde) {
        super();
        this.nombreColonnes = monde.getDimX();
        this.nombreLignes = monde.getDimY();
        this.layout = new GridLayout(nombreLignes, nombreColonnes);
        super.setLayout(this.layout);


        this.cases = new ArrayList<CaseView>();
        for (int i = 0; i < nombreLignes; i++) {
            for (int j = 0; j < nombreColonnes; j++) {
                CaseView temp = new CaseView(monde.getCase(i, j));
                cases.add(temp);
                super.add(temp);
            }
        }

    }


}
