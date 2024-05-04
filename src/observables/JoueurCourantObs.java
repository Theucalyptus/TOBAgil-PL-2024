package observables;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class JoueurCourantObs extends Observable {

    /**Construire un joueur courant observable. */
    public JoueurCourantObs() {
        super();
    }

    /**
     * Notifie les observateurs que le joueur courant à changer.
     */
    public void notifyJoueurCourant() {
        super.setChanged();
        super.notifyObservers();
        super.clearChanged();
    }
}
