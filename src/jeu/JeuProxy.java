package jeu;

import exceptions.OperationInterditeException;

/**Le proxy du jeu pour éviter toute tentative de triche de la part des joueurs */
public class JeuProxy implements Jeu {
    
    /**L'implématation du jeu */
    final private Jeu impl;

    public JeuProxy(Jeu jeu) {
        this.impl = jeu;
    }

    public void ajouterJoueur(Joueur joueur) {
        throw new OperationInterditeException(
            "Un joueur n'a pas le droit d'ajouter un joueur à la partie");
    }
}
