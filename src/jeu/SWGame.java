package jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une partie de jeu.
 */
public class SWGame implements SWJeuInterface {

    private List<SWJoueur> joueurs;
    private SWMonde monde;              // Le plateau du monde

    // Indique si la partie est encore (pas commencée ou pas finies).
    private Boolean enCours = false;

    public SWGame() {
        this.joueurs = new ArrayList<>();
        this.monde = new SWMonde();
    }

    public void ajouterJoueur(SWJoueur joueur) {
        this.joueurs.add(joueur);
    }

}
