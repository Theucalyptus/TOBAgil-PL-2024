package jeu;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class JoueurCourantObs extends Observable {
 
    /** Le jeu dont on suit le joueur courant. */
    private final Jeu jeu;
    
    public JoueurCourantObs(Jeu jeu) {
        this.jeu = jeu;
    }

    public void notifierChangement() {
        super.setChanged();
        super.notifyObservers(jeu.getJoueurCourant());
        super.clearChanged();
    }
}
