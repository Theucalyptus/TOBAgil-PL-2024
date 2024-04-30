package observables;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class JoueurCourant extends Observable {
    
    public JoueurCourant() {
        super();
    }

    /**
     * Notifie les observateurs que le joueur courant à changer.
     */
    public void updateJoueurCourant() {
        super.setChanged();
        super.notifyObservers();
        super.clearChanged();
    }
}
