import ui.ActionsFenetre;
import ui.MainJoueurFenetre;
import ui.MainMondeFenetre;

import ui.PiocheFenetre;
import ui.selecteur.Selecteur;
import ui.views.CaseView;
import jeu.Combinaison;
import jeu.JeuReel;
import jeu.Joueur;
import jeu.Monde;
import jeu.batiments.TypesBatiments;
import jeu.peuples.*;
import jeu.pouvoirs.*;

/**Classe principale de l'application.*/
public final class Smallworld {


    /**Supprimer le Constructeur par défaut. */
     private Smallworld() {
        // ne rien faire.
    }


    /**Lancer l'application.
     * @param args Les paramètre de la ligne de commandes, ils ne
     * sont pas utilisés dans notre application.
     */
    public static void main(String[] args) {

        // MODELE
        JeuReel jeu = new JeuReel();
        Joueur j1 = new Joueur("Fraise", 0);
        Joueur j2 = new Joueur("Framboise", 0);
        Joueur j3 = new Joueur("Pomme", 0);
        jeu.ajouterJoueur(j1);
        jeu.ajouterJoueur(j2);
        jeu.ajouterJoueur(j3);
        jeu.setMonde(new Monde(jeu.getNombreJoueur()));

        //SELECTEUR
        Selecteur<CaseView> selecteurCase = new Selecteur<CaseView>();
        Selecteur<Combinaison> selecteurCombinaison = new Selecteur<Combinaison>();

        // VUES
        PiocheFenetre piocheF = new PiocheFenetre(selecteurCombinaison, jeu);
        MainMondeFenetre mondeF = new MainMondeFenetre(jeu, selecteurCase);
        MainJoueurFenetre joueurF = new MainJoueurFenetre(jeu);
        ActionsFenetre actionsF = new ActionsFenetre(jeu, selecteurCase, selecteurCombinaison);

    }
}
