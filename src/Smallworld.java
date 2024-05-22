import ui.ActionsFenetre;
import ui.MainJoueurFenetre;
import ui.MainMondeFenetre;

import ui.PiocheFenetre;
import ui.menu.LanceurSmallworld;
import ui.selecteur.Selecteur;
import ui.views.CaseView;
import jeu.Combinaison;
import jeu.JeuReel;
import jeu.Joueur;
import jeu.Monde;

/**Classe principale de l'application.*/
@SuppressWarnings("deprecation")
public final class Smallworld {


    /**Supprimer le Constructeur par défaut. */
     private Smallworld() {
        // ne rien faire.
    }


    /**Lancer le menu de l'application.
     * @param args Les paramètre de la ligne de commandes, ils ne
     * sont pas utilisés dans notre application.
     */
    public static void main(String[] args) {
    	
    	LanceurSmallworld menuJeu = new LanceurSmallworld();

    }
}
