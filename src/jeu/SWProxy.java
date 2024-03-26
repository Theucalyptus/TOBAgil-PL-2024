package jeu;

import SWexception.OperationInterditeException;

/**Le proxy du jeu pour éviter toute tentative de triche de la part des joueurs */
public class SWProxy implements SWJeuInterface {
    
    /**L'implématation du jeu */
    final private SWGame impl = new SWGame();

    public void ajouterJoueur(SWJoueur joueur) {
        throw new OperationInterditeException(
            "Un joueur n'a pas le droit d'ajouter un joueur à la partie");
    }
}
