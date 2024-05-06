import ui.ActionsFenetre;
import ui.MainJoueurFenetre;
import ui.MainMondeFenetre;

import ui.PiocheFenetre;
import ui.selecteur.Selecteur;
import ui.views.CaseView;
import jeu.Combinaison;
import jeu.EnsemblePions;
import jeu.JeuReel;
import jeu.Joueur;
import jeu.Monde;
import jeu.batiments.TypesBatiments;
import jeu.peuples.Amazones;
import jeu.peuples.Elfes;
import jeu.pouvoirs.Alchimistes;
import jeu.pouvoirs.Volants;

/**Classe principale de l'application.*/
public /*final*/ class Smallworld {

    /*
     /**Supprimer le Constructeur par défaut. *\/
     private Smallworld() {
        // ne rien faire.
    }
    */

    /**Lancer l'application.
     * @param args Les paramètre de la ligne de commandes, ils ne
     * sont pas utilisés dans notre application.
     */
    public static void main(String[] args) {

        // MODELE
        JeuReel jeu = new JeuReel();
        Joueur j1 = new Joueur("Fraise", 0);
        j1.setCombinaison(new Combinaison(new Amazones(), new Alchimistes()));
        Joueur j2 = new Joueur("Framboise", 0);
        j2.setCombinaison(new Combinaison(new Elfes(), new Alchimistes()));
        Joueur j3 = new Joueur("Pomme", 0);
        j3.setCombinaison(new Combinaison(new Amazones(), new Volants()));
        jeu.ajouterJoueur(j1);
        jeu.ajouterJoueur(j2);
        jeu.ajouterJoueur(j3);
        jeu.setMonde(new Monde(jeu.getNombreJoueur()));

        //SELECTEUR
        Selecteur<CaseView> selecteurCase = new Selecteur<CaseView>();

        // VUES
        PiocheFenetre piocheF = new PiocheFenetre();
        MainMondeFenetre mondeF = new MainMondeFenetre(jeu, selecteurCase);
        MainJoueurFenetre joueurF = new MainJoueurFenetre(jeu);
        ActionsFenetre actionsF = new ActionsFenetre(jeu, selecteurCase);

        jeu.getMonde().getCase(2, 2).setNewpions(new EnsemblePions(new Amazones(), 4));
        jeu.getMonde().getCase(3, 3).setTypeBatiment(TypesBatiments.ANTRE_DE_TROLL, 1);
        jeu.getMonde().getCase(3, 1).setTypeBatiment(TypesBatiments.CAMPEMENT, 2);
        jeu.getMonde().getCase(3, 2).setTypeBatiment(TypesBatiments.FORTERESSE, 3);
        //jeu.getMonde().getCase(2, 1)
    }
}
