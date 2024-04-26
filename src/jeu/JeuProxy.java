package jeu;

import jeu.exceptions.OperationInterditeException;

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

    public Monde getMonde() {
        return this.impl.getMonde();
    }

    public Joueur getJoueurCourant() {
        return this.impl.getJoueurCourant();
    }

    public void setNombreTour() {
        throw new OperationInterditeException(
            "Un joueur n'a pas le droit d'actualiser le nombre de tour");
    }

    public void reinitialiserJoueurs() {
        throw new OperationInterditeException("Un joueur ne peut pas demander a vider "
            + "la liste de Joueur.");
    }
}
