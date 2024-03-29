package ui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

import jeu.Monde;
import jeu.TypesRegions;


public class MainMondeView extends JPanel {

    public final static int NbLignes = 4;
    public final static int NbColonnes = 4;

    private GridLayout layout;
    private List<CaseMonde> cases;

    public MainMondeView(Monde monde) {
        super();
        this.layout = new GridLayout(NbLignes, NbColonnes);
        super.setLayout(this.layout);


        // CODE TEMPORAIRE DE TEST
        this.cases = new ArrayList<CaseMonde>();
        Random rng = new Random();
        for(int i=0;i<NbLignes;i++) {
            for(int j=0;j<NbColonnes; j++) {
                CaseMonde temp = new CaseMonde(TypesRegions.values()[rng.nextInt(TypesRegions.values().length)], i, j);
                cases.add(temp);
                super.add(temp);
            }
        }
    }


}
