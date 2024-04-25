import ui.MainJoueurFenetre;
import ui.MainMondeFenetre;

import ui.CombinaisonSelectionFenetre;


import jeu.JeuReel;

/**Classe principale de l'application.*/
public class Smallworld {

    /**Lancer l'application.
     * @param args Les paramètre de la ligne de commandes, ils ne
     * sont pas utilisés dans notre application.
     */
    public static void main(String[] args) {

        new CombinaisonSelectionFenetre();

        JeuReel jeu = new JeuReel();
        new MainMondeFenetre(jeu);
        new MainJoueurFenetre(jeu);

    }
}
