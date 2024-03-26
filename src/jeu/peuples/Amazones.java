package jeu.peuples;

public class Amazones extends Peuple {
    
    private static final String NOM = "Amazones";
    private static final String DESCRIPTION = "Pour vos conquêtes, vous avez droit à 4 amazones supplémentaires";

    public Amazones() {
        super(TypesPeuples.AMAZONES, NOM, DESCRIPTION);
    }
    
}
