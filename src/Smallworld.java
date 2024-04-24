import ui.MainJoueurFenetre;
import ui.MainMondeFenetre;

import ui.CombinaisonSelectionFenetre;


import jeu.JeuReel;

public class Smallworld {

    public static void main(String[] args) {

        new CombinaisonSelectionFenetre();
       
        JeuReel jeu = new JeuReel();
        new MainMondeFenetre(jeu);
        new MainJoueurFenetre(jeu);

    }
}