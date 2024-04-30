package ui.views;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

import jeu.Monde;
import jeu.TypesRegions;
import ui.views.CaseView;

public class MainMondeView extends JPanel {

    public final int NbLignes;
    public final int NbColonnes;

    private GridLayout layout;
    private List<CaseView> cases;

    public MainMondeView(Monde monde) {
        super();
        this.NbColonnes = monde.getDimX();
        this.NbLignes = monde.getDimY();
        this.layout = new GridLayout(NbLignes, NbColonnes);
        super.setLayout(this.layout);


        this.cases = new ArrayList<CaseView>();
        for(int i=0;i<NbLignes;i++) {
            for(int j=0;j<NbColonnes; j++) {
                CaseView temp = new CaseView(monde.getCase(i, j));
                cases.add(temp);
                super.add(temp);
            }
        }

    }


}
