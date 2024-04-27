import ui.MainJoueurFenetre;
import ui.MainMondeFenetre;

import ui.PiocheFenetre;
import jeu.Combinaison;
import jeu.JeuReel;
import jeu.Joueur;
import jeu.peuples.Amazones;
import jeu.pouvoirs.Alchimistes;

/**Classe principale de l'application.*/
public class Smallworld {

    /**Lancer l'application.
     * @param args Les paramètre de la ligne de commandes, ils ne
     * sont pas utilisés dans notre application.
     */
    public static void main(String[] args) {

        // MODELE
        int nb_joueurs = 3; //nombre arbitraire pour l'instant en attendant un moyen d'obtenir le vrai nombre de joueurs
        JeuReel jeu = new JeuReel(nb_joueurs);
        jeu.ajouterJoueur(new Joueur("Xavier", 0));
        jeu.jouerPartie();
        jeu.getJoueurCourant().setCombinaison(new Combinaison(new Amazones(), new Alchimistes()));
        
        // CONTROLLEURS
        
        // VUES
        PiocheFenetre piocheF = new PiocheFenetre();
        MainMondeFenetre mondeF = new MainMondeFenetre(jeu);
        MainJoueurFenetre joueurF = new MainJoueurFenetre(jeu);
        joueurF.update();
        mondeF.update();



    }
}
