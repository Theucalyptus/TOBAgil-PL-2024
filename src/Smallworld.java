import ui.ActionsFenetre;
import ui.MainJoueurFenetre;
import ui.MainMondeFenetre;

import ui.PiocheFenetre;
import jeu.Combinaison;
import jeu.JeuReel;
import jeu.Joueur;
import jeu.peuples.Amazones;
import jeu.peuples.Elfes;
import jeu.pouvoirs.Alchimistes;
import jeu.pouvoirs.Volants;

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
        Joueur j1 = new Joueur("Fraise", 0);
        j1.setCombinaison(new Combinaison(new Amazones(), new Alchimistes()));
        Joueur j2 = new Joueur("Framboise", 0);
        j2.setCombinaison(new Combinaison(new Elfes(), new Alchimistes()));
        Joueur j3 = new Joueur("Pomme", 0);
        j3.setCombinaison(new Combinaison(new Amazones(), new Volants()));
        jeu.ajouterJoueur(j1);
        jeu.ajouterJoueur(j2);
        jeu.ajouterJoueur(j3);
                
        // VUES
        PiocheFenetre piocheF = new PiocheFenetre();
        MainMondeFenetre mondeF = new MainMondeFenetre(jeu);
        MainJoueurFenetre joueurF = new MainJoueurFenetre(jeu);
        ActionsFenetre actionsF = new ActionsFenetre(jeu);
        mondeF.update();


        // MAIN
        jeu.jouerPartie();


    }
}
