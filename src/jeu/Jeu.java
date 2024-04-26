package jeu;

/**Interface de modélisation du jeu SmallWorld. */
public interface Jeu {

    /**
     * Ajouter le joueur à la liste des joueurs.
     * @param joueur Le joueur qui rentre dans le jeu.
     */
    void ajouterJoueur(Joueur joueur);


    /**Retirer tous les Joueurs de la listes des joueurs. */
    void reinitialiserJoueurs();


    /**Obtenir le monde.
     * @return Le monde de la partie.
     */
    Monde getMonde();

    /** Permet d'obtenir le joueur qui est en train de jouer.
     * @return Le Joueur courant.
     */
    Joueur getJoueurCourant();
}
