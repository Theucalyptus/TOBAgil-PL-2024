package jeu;

/**Interface de modélisation du jeu SmallWorld. */
public interface Jeu {

    /**Nombre de Tour a jouer pour une partie de 2 joueurs. */
    int NOMBRETOUR2JOUEURS = 10;


    /**Nombre de Tour a jouer pour une partie de 3 joueurs. */
    int NOMBRETOUR3JOUEURS = 9;


    /**Nombre de Tour a jouer pour une partie de 4 ou 5 joueurs. */
    int NOMBRETOUR45JOUEURS = 8;

    /**Nombre de Joueurs possible dans une partie. */
    int PARTIE2JOUEURS = 2;

    /**Nombre de Joueurs possible dans une partie. */
    int PARTIE3JOUEURS = 3;

    /**Nombre de Joueurs possible dans une partie. */
    int PARTIE4JOUEURS = 4;

    /**Nombre de Joueurs possible dans une partie. */
    int PARTIE5JOUEURS = 5;

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
