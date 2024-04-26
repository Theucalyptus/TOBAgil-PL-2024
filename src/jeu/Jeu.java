package jeu;

/**Interface de modélisation du jeu SmallWorld. */
public interface Jeu {

    /**
     * Ajouter le joueur à la liste des joueurs.
     * @param joueur Le joueur qui rentre dans le jeu.
     */
    void ajouterJoueur(Joueur joueur);

    /**
     * Renvoie le monde de la partie (la grille).
     * @return le monde de la partie
     */
    Monde getMonde();

    /**
     * Renvoie la poigné vers le joueur courant.
     * @return Le joueur courant.
     */
    Joueur getJoueurCourant();

    /**
     * Détermine le nombre de tour en fonction du nombre de
     * joueur dans le jeu.
     */
    void setNombreTour();
}
