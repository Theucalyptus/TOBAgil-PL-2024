package jeu;

import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Observer;

import jeu.exceptions.JoueurDejaDansLaPartieException;
import jeu.exceptions.NombreJoueurIncorrectException;
import jeu.exceptions.PartieEnCoursException;
import jeu.exceptions.PartiePleineException;

import observables.JoueurCourantObs;
import observables.NombreTourObs;

/**
 * Classe représentant une partie de jeu.
 */

@SuppressWarnings("deprecation")
public class JeuReel implements Jeu {

    // atributs

    /** La liste de joueurs. */
    private List<Joueur> joueurs;

    /** Le joueur courant. */
    private Joueur joueurCourant;

    /** Iterateur sur les joueurs. */
    private ListIterator<Joueur> joueursIter;

    /** Le numéro du tour actuel dans la partie. */
    private int noTour;

    /** Le nombre de tour total qui devra être fait dans la partie. */
    private int nbToursTotals;

    /** Indicateur de fin de tour du joueur. */
    private boolean finDuTour;

    /** Le nombre de Joueur de la partie. */
    private int nombreJoueurs;

    /** Le plateau. */
    private Monde monde;              // Le plateau du monde

    /** Indique si la partie est encore (pas commencée ou pas finies). */
    private Boolean enCours = false;

    /** Permet de notifier lorsque le joueur courant change. */
    private JoueurCourantObs joueurCourantObs;

    /** Permet de notifier lorsque le numero du tour change. */
    private NombreTourObs nbTourObs;

    // Constructeur

    /**Construire un Jeu Réel.
     * @param nbJoueurs Le nombre de Joueur de la partie.
    */
    public JeuReel(int nbJoueurs) {
        this(nbJoueurs, new Monde(nbJoueurs));
    }

    /**Construire un Jeu Reel. */
    public JeuReel() {
        this(0, null);
    }


    private JeuReel(int nbJoueurs, Monde leMonde) {
        this.joueurs = new ArrayList<>();
        this.monde = leMonde;
        this.finDuTour = true;
        this.enCours = false;
        this.nbToursTotals = 0;
        this.noTour = 1;
        this.joueurCourant = null;
        this.joueursIter = null;
        this.joueurCourantObs = new JoueurCourantObs();
        this.nbTourObs = new NombreTourObs();
        this.nombreJoueurs = nbJoueurs;
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
        return this.nombreJoueurs;
    }

    /**
     * Obtenir la liste des Joueurs.
     * @return La liste des Joueurs.
     */
    /* public List<Joueur> getJoueurs() {
        return this.joueurs;
    } */

    /**
     * Ajoute un observateur à l'observable du joueur courant.
     */
    public void addJoueurCourantObserver(Observer obs) {
        this.joueurCourantObs.addObserver(obs);
    }

    /**
     * Ajoute un observateur au nombre de tour.
     */
    public void addNbTourObserver(Observer obs) {
        this.nbTourObs.addObserver(obs);
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
        this.nbTourObs.notifyObservers();
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
        this.joueurCourantObs.notifyJoueurCourant();
    }

    /**Changer la valeur de monde par une nouvelle.
     * @param leNouveauMonde Le nouveau Monde.
     */
    public void setMonde(Monde leNouveauMonde) {
        this.monde = leNouveauMonde;
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
    private void majNombreToursTotals() {
        switch (this.nombreJoueurs) {
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
                throw new NombreJoueurIncorrectException();
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
        this.nombreJoueurs++;
    }


    /**Simuler une partie.
     * @throws PartieEnCoursException Quand on essaye de lancer une
     * partie alors qu'il y en a une déjà en cours.
     */
    public void lancerPartie() {
        if (enCours) {
            throw new PartieEnCoursException();
        }
        enCours = true;
        this.majNombreToursTotals();
        this.joueursIter = this.joueurs.listIterator();
        this.setJoueurCourant(this.joueursIter.next()); // unsafe si appelé alors que pas de joueur ?
    }

    /**
     * Permet de passer au tour suivant
     */
    public void passerTour() {
        System.out.println("Tour " + this.getNumeroTour() + " sur " + this.getNombreTourTotal());
        if(this.joueursIter.hasNext()) {
            this.setJoueurCourant(this.joueursIter.next());
        } else {
            this.joueursIter = this.joueurs.listIterator();
            this.setNumeroTour(this.getNumeroTour() + 1);
            this.setJoueurCourant(this.joueursIter.next());
        }
        if(this.getNumeroTour() > this.getNombreTourTotal()) {
            this.enCours = false;
        }
    }
}
