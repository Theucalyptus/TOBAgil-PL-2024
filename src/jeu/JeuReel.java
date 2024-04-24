package jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une partie de jeu.
 */
public class JeuReel implements Jeu {

    /** La liste de joueurs. */
    private List<Joueur> joueurs;

    /** Le joueur courant. */
    private Joueur joueurCourant;

    /** Le nombre de tour dans la partie. */
    private int nbTours;

    /** Indicateur de fin de tour du joueur */
    private boolean finDuTour;

    /** Le plateau */
    private Monde monde;              // Le plateau du monde

    // Indique si la partie est encore (pas commencée ou pas finies).
    private Boolean enCours = false;

    public JeuReel() {
        this.joueurs = new ArrayList<>();
        this.monde = new Monde();
        this.finDuTour = true;
    }

    public void setNombreTour() {
        switch (this.getNombreJoueur()) {
            case 2:
                this.nbTours = 10;
                break;
            case 3:
                this.nbTours = 9;
            default:
                this.nbTours = 8;
        }
    }

    public void ajouterJoueur(Joueur joueur) {
        this.joueurs.add(joueur);
    }

    public Monde getMonde() {
        return this.monde;
    }

    public Joueur getJoueurCourant() {
        return this.joueurCourant;
    }

    public int getNombreTour() {
        return this.nbTours;
    }

    public int getNombreJoueur() {
        return this.joueurs.size();
    }

    public List<Joueur> getJoueurs() {
        return this.joueurs;
    }

    public void setFinDuTour() {
        this.finDuTour = true;
    }

    public boolean estFinDeTour() {
        return this.finDuTour;
    }

    // move to controller
    public void jouerPartie() {
        if (enCours) {
            throw new IllegalCallerException();
        }
        enCours = true;
        this.setNombreTour();
        // Pour chaque tour
        for (int i = 0; i < this.nbTours; i++) {
            // faire joeur chaque joueur
            for (Joueur joueur : joueurs) {
                // mettre a jour le joueur courant
                this.joueurCourant = joueur;
                
                // initialisé la fin du tour
                this.finDuTour = false;

                // attendre la fin du tour
                while (!finDuTour) {  }

            }
        }
        enCours = false;
    }
}
