package jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une partie de jeu.
 */
public class JeuReel implements Jeu {

    private List<Joueur> joueurs;
    private Monde monde;              // Le plateau du monde

    // Indique si la partie est encore (pas commencée ou pas finies).
    private Boolean enCours = false;

    public JeuReel() {
        this.joueurs = new ArrayList<>();
        this.monde = new Monde();
    }

    public void ajouterJoueur(Joueur joueur) {
        this.joueurs.add(joueur);
    }

    public Monde getMonde() {
        return this.monde;
    }

}
