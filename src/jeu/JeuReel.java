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

    /** Indicateur de fin de tour du joueur. */
    private boolean finDuTour;

    /** Le plateau. */
    private Monde monde;              // Le plateau du monde

    /** Indique si la partie est encore (pas commencée ou pas finies). */
    private Boolean enCours = false;

    /**Construire un Jeu Réel. */
    public JeuReel() {
        this.joueurs = new ArrayList<>();
        this.monde = new Monde();
        this.finDuTour = true;
    }

    /**Actualiser le nombre de tour de la partie en fonction du
     * nombre de joueur dans la partie.
     */
    public void setNombreTour() {
        switch (this.getNombreJoueur()) {
            case PARTIE2JOUEURS:
                this.nbTours = NOMBRETOUR2JOUEURS;
                break;
            case PARTIE3JOUEURS:
                this.nbTours = NOMBRETOUR3JOUEURS;
                break;
            case PARTIE4JOUEURS | PARTIE5JOUEURS:
                this.nbTours = NOMBRETOUR45JOUEURS;
                break;
            default:
                this.nbTours = NOMBRETOUR45JOUEURS;
        }
    }

    /**Ajouter un joueur dans la liste de joueurs s'il y a de la place
     * Sinon throw PartiePleineException.
     * @param joueur Le joueur qu l'on souhaite ajouté à la liste.
     * @throws PartiePleineException Quand on tente d'ajouter un joueur
     * dans une partie pleine (5 Joueurs).
     * @throws PartieEnCoursException Quand on tente d'ajouter un joueur
     * en pleine partie.
     * @throws IllegalArgumentException Quand le Joueur est une poignée null.
     */
    public void ajouterJoueur(Joueur joueur) {
        this.joueurs.add(joueur);
    }

    /**Obtenir le monde.
     * @return Le monde de la partie.
     */
    public Monde getMonde() {
        return this.monde;
    }

    /** Permet d'obtenir le joueur qui est en train de jouer.
     * @return Le Joueur courant.
     */
    public Joueur getJoueurCourant() {
        return this.joueurCourant;
    }

    /**
     * Obtenir le numéro du tour en train d'être joué.
     * @return Le numéro du tour qui est en train d'être joué.
     */
    public int getNombreTour() {
        return this.nbTours;
    }

    /**
     * Obtenir le nombre de joueurs dans la partie.
     * @return Le nombre de Joueur.
     */
    public int getNombreJoueur() {
        return this.joueurs.size();
    }

    /**
     * Obtenir la liste des Joueurs.
     * @return La liste des Joueurs.
     */
    public List<Joueur> getJoueurs() {
        return this.joueurs;
    }

    /**Signaler la fin du tour à l'application. */
    public void setFinDuTour() {
        this.finDuTour = true;
    }

    /**
     * Détermine si le joueur Courant à fini de jouer.
     * @return Si  le joueur Courant à fini de jouer.
     */
    public boolean estFinDeTour() {
        return this.finDuTour;
    }

    // move to controller
    /**Simuler une partie.
     * @throws PartieEnCoursException Quand on essaye de lancer une
     * partie alors qu'il y en a une déjà en cours.
     */
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
                while (!finDuTour) {
                    int a = 0; a = - a;
                }

            }
        }
        enCours = false;
    }
}
