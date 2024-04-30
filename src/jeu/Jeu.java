package jeu;

import java.util.Observer;

import jeu.exceptions.PartieEnCoursException;

/**Interface de modélisation du jeu SmallWorld. */
public interface Jeu {

    /**
     * Ajouter le joueur à la liste des joueurs.
     * @param joueur Le joueur qui rentre dans le jeu.
     */
    void ajouterJoueur(Joueur joueur);


    /**Obtenir le monde.
     * @return Le monde de la partie.
     */
    Monde getMonde();

    /** Permet d'obtenir le joueur qui est en train de jouer.
     * @return Le Joueur courant.
     */
    Joueur getJoueurCourant();

    /**
     * Obtenir le numéro du tour en train d'être joué.
     * @return Le numéro du tour qui est en train d'être joué.
     */
    int getNumeroTour();

    /**Obtenir le Nombre de tour totale de la partie.
     * @return Le nombre de tour totale que durera la partie.
     */
    int getNombreTourTotal();

    /**
     * Changer la valeur de finduTour pour la valeur donné en argument.
     * @param finDuTour si le tour est finie.
     */
    void setFinDuTour(boolean finDuTour);

    /**
     * Changer le numéro du tour par une nouvelle valeur.
     * @param numero La nouvelle valeur.
     */
    void setNumeroTour(int numero);

    /**
     * Ajoute un observateur à l'observable du joueur courant.
     */
    @SuppressWarnings("deprecation")
    void addJoueurCourantObserver(Observer obs);

    /**
     * Ajoute un observateur au nombre de tour.
     */
    @SuppressWarnings("deprecation")
    void addNbTourObserver(Observer obs);

    /**changer la valeur du monde par une nouvelle.
     * @param leNouveauMonde la nouvelle valeur.
     */
    void setMonde(Monde leNouveauMonde);

    /**Simuler une partie.
     * @throws PartieEnCoursException Quand on essaye de lancer une
     * partie alors qu'il y en a une déjà en cours.
     */
    public void jouerPartie();
    
}
