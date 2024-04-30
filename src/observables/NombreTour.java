package observables;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class NombreTour extends Observable {
    
    public NombreTour() {
        super();
    }

    /**
     * Notifie les observateurs que le numéro de tour a changé.
     */
    public void notifyNombreTour() {
        super.setChanged();
        super.notifyObservers();
        super.clearChanged();
    }
}
