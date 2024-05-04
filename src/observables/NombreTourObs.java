package observables;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class NombreTourObs extends Observable {

    /**Construire un observable nombre de tour. */
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
