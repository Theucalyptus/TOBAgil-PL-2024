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
    
    /**Lancer le jeu Smallworld à partir du nombre de joueurs.
     * @param nbJoueurs Le nombre de joueurs jouant au jeu.
     */
    public static void lancerSmallworld(int nbJoueurs) {
    	
        // MODELE
        JeuReel jeu = new JeuReel();
        
        for(int i = 1; i <= nbJoueurs; i++) {
        	Joueur joueur = new Joueur("Joueur " + i, 0);
        	jeu.ajouterJoueur(joueur);
        }
        
        jeu.setMonde(new Monde(nbJoueurs));

        //SELECTEUR
        Selecteur<CaseView> selecteurCase = new Selecteur<CaseView>();
        Selecteur<Combinaison> selecteurCombinaison = new Selecteur<Combinaison>();

        // VUES
        PiocheFenetre piocheF = new PiocheFenetre(selecteurCombinaison, jeu);
        jeu.getPioche().addObserver(piocheF);
        MainMondeFenetre mondeF = new MainMondeFenetre(jeu, selecteurCase);
        MainJoueurFenetre joueurF = new MainJoueurFenetre(jeu);
        ActionsFenetre actionsF = new ActionsFenetre(jeu, selecteurCase,
            selecteurCombinaison);
    }
}
