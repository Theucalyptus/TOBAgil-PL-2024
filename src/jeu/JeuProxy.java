package jeu;

import java.util.Observer;

import jeu.exceptions.OperationInterditeException;

/**Le proxy du jeu pour éviter toute tentative de triche de la part des joueurs. */
@SuppressWarnings("deprecation")
public class JeuProxy implements Jeu {

    @Override
    public void addJoueurCourantObserver(Observer obs) {
        // TODO Auto-generated method stub
    }

    @Override
    public void jouerPartie() {
        throw new OperationInterditeException(
            "Un joueur n'a pas le droit de lancer une partie");
    }

    @Override
    public void setFinDuTour(boolean finDuTour) {
        
    }

    @Override
    public void setMonde(Monde leNouveauMonde) {
        throw new OperationInterditeException(
            "Un joueur n'a pas le droit de changer le monde");    }

    @Override
    public void setNumeroTour(int numero) {
        throw new OperationInterditeException(
            "Un joueur n'a pas le droit de modifier le numéro du tour");
    }

    /**L'implématation du jeu */
    private Jeu impl;

    /**
     * Construire un proxy
     * @param jeu le jeu sur lequel on fait un proxy.
     */
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

    /**
     * Obtenir le numéro du tour en train d'être joué.
     * @return Le numéro du tour qui est en train d'être joué.
     */
    public int getNumeroTour() {
        return this.impl.getNumeroTour();
    }

    /**Obtenir le Nombre de tour totale de la partie.
     * @return Le nombre de tour totale que durera la partie.
     */
    public int getNombreTourTotal() {
        return this.impl.getNombreTourTotal();
    }


}
