package jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une partie de jeu.
 */
public class SWGame {

    private List<SWJoueur> joueurs;

    // Indique si la partie est encore (pas commencée ou pas finies).
    private Boolean enCours = false;

    public SWGame() {
        this.joueurs = new ArrayList<>();
    }

    public void ajouterJoueur(SWJoueur joueur) {
        this.joueurs.add(joueur);
    }

}
