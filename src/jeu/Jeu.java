package jeu;

import java.util.Observer;

import jeu.exceptions.PartieEnCoursException;


/**Interface de modélisation du jeu SmallWorld. */
@SuppressWarnings("deprecation")
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
     * Changer le numéro du tour par une nouvelle valeur.
     * @param numero La nouvelle valeur.
     */
    void setNumeroTour(int numero);

    /**
     * Ajoute un observateur.
     * @param obs L'observer à ajouter.
     */
    void ajouterObservateur(Observer obs);

    /**changer la valeur du monde par une nouvelle.
     * @param leNouveauMonde la nouvelle valeur.
     */
    void setMonde(Monde leNouveauMonde);

    /** Lancer une partie.
     * @throws PartieEnCoursException Quand on essaye de lancer une
     * partie alors qu'il y en a une déjà en cours.
     */
    void lancerPartie();

    /**
     * Passe au tour suivant.
     */
    void passerTour();

    /**
     * Permet d'attaquer une case.
     * @param laCase la case à attaquer.
     */
    void attaquerCase(Case laCase);

    /**
     * Permet de placer des pions sur une case.
     * @param laCase la case à attaquer.
     * @param nbPions le nombre de pions à placer.
     */
    void placerPions(Case laCase, int nbPions);

    void redeployement();

    /**
     * Permet d'obtenier l'état de la partie.
     * @return l'état courant de la partie
     */
    JeuState getEtat();
}
