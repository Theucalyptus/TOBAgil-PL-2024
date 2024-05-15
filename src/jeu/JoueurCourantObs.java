package jeu;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class JoueurCourantObs extends Observable implements Observer {

    /** Le jeu dont on suit le joueur courant. */
    private final Jeu jeu;

    /** Indique si l'observer est attaché à un joueur. */
    private boolean attache = false;

    public JoueurCourantObs(Jeu jeu) {
        this.jeu = jeu;
    }

    public void detacher() {
        if(this.attache)  {
            this.jeu.getJoueurCourant().deleteObserver(this);
        }
        this.attache = false;
    }   

    public void attacher() {
        this.jeu.getJoueurCourant().addObserver(this);
        this.attache = true;
    }
    
    public void notifierChangement() {
        super.setChanged();
        super.notifyObservers(jeu.getJoueurCourant());
        super.clearChanged();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.notifierChangement();    
    }
}
