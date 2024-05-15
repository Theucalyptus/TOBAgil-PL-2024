package jeu;

import java.util.Observer;

import jeu.exceptions.OperationInterditeException;

/**Le proxy du jeu pour éviter toute tentative de triche de la part des joueurs. */
@SuppressWarnings("deprecation")
public class JeuProxy implements Jeu {
    
    /**L'implématation du jeu. */
    private Jeu impl;

    /**
     * Construire un proxy.
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

    @Override
    public Monde getMonde() {
        return this.impl.getMonde();
    }

    @Override
    public Joueur getJoueurCourant() {
        return this.impl.getJoueurCourant();
    }

    @Override
    public int getNumeroTour() {
        return this.impl.getNumeroTour();
    }

    @Override
    public int getNombreTourTotal() {
        return this.impl.getNombreTourTotal();
    }

    
    /**Lancer une expeption si la méthode est appelée.
     * @param numero Le nouveau numéro du tour.
     * @throws OperationInterditeException Si la méthode est appelée.
     */
    @Override
    public void setNumeroTour(int numero) {
        throw new OperationInterditeException(
            "Un joueur n'a pas le droit de modifier le numéro du tour");
    }

    /**Lancer une execption si la méthode est appelée.
     * @param obs L'observer que l'on veut ajouter
     * @throws OperationInterditeException Si la méthode est appelé.
     */
    @Override
    public void ajouterObservateur(Observer obs) {
        throw new OperationInterditeException(
            "Le joueur n'a pas accès à cette méthode.");
    }

    // /**Lancer une execption si la méthode est appelée.
    //  * @param obs L'observer que l'on veut ajouter
    //  * @throws OperationInterditeException Si la méthode est appelé.
    //  */
    // @Override
    // public void addJoueurCourantObserver(Observer obs) {
    //     throw new OperationInterditeException(
    //         "Le joueur n'a pas accès à cette méthode.");
    // }

    
    // /**Lancer une exeption si le joueur appele cette méthode.
    //  * @param obs l'observer à ajouter.
    //  * @throws OperationInterditeException Si la méthode est appelée.
    //  */
    // @Override
    // public void addNbTourObserver(Observer obs) {
    //     throw new OperationInterditeException(
    //         "Le joueur n' a pas accès à cette méthode.");
    // }

    
    /**Lancer une exepction si le joueur appele la méthode.
     * @param leNouveauMonde le nouveau monde par lequel on remplace l'ancien.
     * @throws OperationInterditeException Si la méthode est appelée.
     */
    @Override
    public void setMonde(Monde leNouveauMonde) {
        throw new OperationInterditeException(
            "Un joueur n'a pas le droit de changer le monde");
    }

    /**Lancer une execption si la méthode est appeleé.
     * @throws OperationInterditeException Si la méthode est appelée.
     */
    @Override
    public void lancerPartie() {
        throw new OperationInterditeException(
            "Un joueur n'a pas le droit de lancer une partie");
    }

    /**Lancer une execption si le joueur essaye de passer au tour Suivant.
     * @throws OperationInterditeException Si un joueur appelle cette fonction.
     */
    @Override
    public void passerTour() {
        throw new OperationInterditeException(
            "Un joueur n'a pas accès a cette commande.");
    }

    @Override
    public void attaquerCase(Case laCase) {
        this.impl.attaquerCase(laCase);
    }

    /**Lancer une exception si cette fonction est appelé.
     * @throws OperationInterditeException si la méthode est appelée.
     */
    @Override
    public void placerPions(Case laCase, int nbPions) {
        throw new OperationInterditeException("Le joueur doit passer par le contrôleur !");
    }


    @Override
    public void redeployement() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redeployement'");
    }
    
    @Override
    public JeuState getEtat() {
        return this.impl.getEtat();
    }   
}
