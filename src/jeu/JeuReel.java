package jeu;

import java.util.ArrayList;
import java.util.List;

import jeu.exceptions.JoueurDejaDansLaPartieException;
import jeu.exceptions.PartieEnCoursException;
import jeu.exceptions.PartiePleineException;

/**
 * Classe représentant une partie de jeu.
 */
public class JeuReel implements Jeu {

    // atributs

    /** La liste de joueurs. */
    private List<Joueur> joueurs;

    /** Le joueur courant. */
    private Joueur joueurCourant;

    /** Le numéro du tour actuel dans la partie. */
    private int noTour;

    /** Le nombre de tour total qui devra être fait dans la partie. */
    private int nbToursTotals;

    /** Indicateur de fin de tour du joueur. */
    private boolean finDuTour;

    /** Le plateau. */
    private Monde monde;              // Le plateau du monde

    /** Indique si la partie est encore (pas commencée ou pas finies). */
    private Boolean enCours = false;


    // Constructeur

    /**Construire un Jeu Réel.
     * @param nb_joueurs Le nombre de Joueur de la partie.
    */
    public JeuReel(int nb_joueurs) {
        this.joueurs = new ArrayList<>();
        Monde monde_vide = new Monde().CreerMonde(nb_joueurs);
        this.finDuTour = true;
        this.enCours = false;
        this.nbToursTotals = 0;
        this.noTour = 1;
        this.joueurCourant = null;
    }

    /**Construire un Jeu Reel. */
    public JeuReel() {
        this.joueurs = new ArrayList<>();
        this.monde = new Monde();
        this.finDuTour = true;
        this.enCours = false;
        this.nbToursTotals = 0;
        this.noTour = 1;
        this.joueurCourant = null;
    }


    // requetes

    
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
    public int getNumeroTour() {
        return this.noTour;
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

    /**
     * Détermine si le joueur Courant à fini de jouer.
     * @return Si  le joueur Courant à fini de jouer.
     */
    public boolean estFinDeTour() {
        return this.finDuTour;
    }


    /**Obtenir le Nombre de tour totale de la partie.
     * @return Le nombre de tour totale que durera la partie.
     */
    public int getNombreTourTotal() {
        return this.nbToursTotals;
    }

    public boolean estEnCoursDePartie() {
        return this.enCours;
    }

    // commandes

    /**
     * Donner le numéro du tour.
     * @param noTour le nouveau numéro du tour.
     */
    public void setNumeroTour(int noTour) {
        this.noTour = noTour;
    }

    /**Signaler la fin du tour à l'application. */
    public void setFinDuTour() {
        this.finDuTour = true;
    }

    /**
     * Changer la valeur de finduTour pour la valeur donné en argument.
     * @param finDuTour si le tour est finie.
     */
    public void setFinDuTour(boolean finDuTour) {
        this.finDuTour = finDuTour;
    }

    /**
     * Permet de mettre à jour le joueur Courant.
     * @param joueurCourant le joueur qui sera le nouveau joueur courant.
     * @throws IllegalArgumentException Quand le joueur Courant est un pointeur null.
     * @throws JoeurExterieurException Quand le joueur n'est pas dans la liste des 
     * joueurs de la partie.
     */
    public void setJoueurCourant(Joueur joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    /**Retirer tous les Joueurs de la listes des joueurs. */
    public void reinitialiserJoueurs() {
        this.joueurs = new ArrayList<>();
    }

    /**
     * Changer la valeur du champs enCours par la valeur en argument.
     * @param enCours La nouvelle valeur de enCours.
     */
    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }

    /**Actualiser le nombre de tour de la partie en fonction du
     * nombre de joueur dans la partie.
     */
    public void majNombreToursTotals() {
        switch (this.getNombreJoueur()) {
            case 2:
                this.nbToursTotals = 10;
                break;
            case 3:
                this.nbToursTotals = 9;
                break;
            case 4 | 5:
                this.nbToursTotals = 8;
                break;
            default:
                this.nbToursTotals = 8;
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
        if (joueur == null) {
            throw new IllegalArgumentException("Le joueur ne doit pas être nul.");
        } else if (this.joueurs.contains(joueur)) {
            throw new JoueurDejaDansLaPartieException();
        } else if (this.getNombreJoueur() == 5) {
            throw new PartiePleineException();
        }
        this.joueurs.add(joueur);
    }


    // move to controller
    /**Simuler une partie.
     * @throws PartieEnCoursException Quand on essaye de lancer une
     * partie alors qu'il y en a une déjà en cours.
     */
    public void jouerPartie() {
        if (this.enCours) {
            throw new PartieEnCoursException();
        }
        this.enCours = true;
        this.majNombreToursTotals();
        // Pour chaque tour
        for (int i = 0; i < this.noTour; i++) {
            // faire joeur chaque joueur
            for (Joueur joueur : joueurs) {
                // mettre a jour le joueur courant
                this.joueurCourant = joueur;

                // initialisé la fin du tour
                this.finDuTour = false;

                // attendre la fin du tour
                //while (!finDuTour) {
                while (finDuTour) {

                    int a = 0; a = - a;
                }
            }
        }
        this.enCours = false;
    }
}
