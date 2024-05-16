package jeu;

/**Les différents état du Joueur. */
public enum JoueurState {
    /**Le Joueur attaque. */
    ATTAQUE,
    /**Le joueur est en début de tour. */
    DEBUT_TOUR,
    /**Le joueur est en train de se redéployer. */
    REDEPLOYMENT,
    /**Le joeueur est en train de choisir une combinaison. */
    CHOIX_COMBINAISON,
}
