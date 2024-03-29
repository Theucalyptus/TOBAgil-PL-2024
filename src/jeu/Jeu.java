package jeu;

/**Interface de modélisation du jeu SmallWorld */
public interface Jeu {
    
    /**
     * Ajouter le joueur à la liste des joueurs.
     * @param joueur Le joueur qui rentre dans le jeu.
     */
    void ajouterJoueur(Joueur joueur);

    /**
     * Renvoie le monde de la partie (la grille)
     * @return le monde de la partie
     */
    Monde getMonde();
}
