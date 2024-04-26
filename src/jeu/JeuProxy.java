package jeu;

import jeu.exceptions.OperationInterditeException;

/**Le proxy du jeu pour éviter toute tentative de triche de la part des joueurs. */
public class JeuProxy implements Jeu {
    
    /**L'implématation du jeu */
    final private Jeu impl;

    public JeuProxy(Jeu jeu) {
        this.impl = jeu;
    }

    /**Envoie une exception car un joueur de peut pas en ajouter un autre.
     * @param joueur Le joueur que l'on veut ajouter.
     */
    public void ajouterJoueur(Joueur joueur) {
        throw new OperationInterditeException(
            "Un joueur n'a pas le droit d'ajouter un joueur à la partie");
    }

    /**Obtenir le monde.
     * @return Le monde.
     */
    public Monde getMonde() {
        return this.impl.getMonde();
    }

    /**Obtenir le joueur courant.
     * @return Le joueur courant.
     */
    public Joueur getJoueurCourant() {
        return this.impl.getJoueurCourant();
    }

}
