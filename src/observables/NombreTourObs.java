package observables;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class NombreTourObs extends Observable {
    
    public NombreTourObs() {
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
