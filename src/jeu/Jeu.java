package jeu;

import java.util.Observer;

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
    public int getNumeroTour();

    /**Obtenir le Nombre de tour totale de la partie.
     * @return Le nombre de tour totale que durera la partie.
     */
    public int getNombreTourTotal();

    /**
     * Changer la valeur de finduTour pour la valeur donné en argument.
     * @param finDuTour si le tour est finie.
     */
    public void setFinDuTour(boolean finDuTour);

    /**
     * Ajoute un observateur à l'observable du joueur courant.
     */
    @SuppressWarnings("deprecation")
    public void addJoueurCourantObserver(Observer obs);
    
}
