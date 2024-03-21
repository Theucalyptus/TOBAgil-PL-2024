package jeu.peuples;

public class Elfes extends Peuple {
    
    private static final String NOM = "Elfes";
    private static final String DESCRIPTION = "Vous ne subissez pas de perte lorsque vous perdez une région et vous reprenez les pions en main.";

    public Elfes() {
        super(TypesPeuples.ELFES, NOM, DESCRIPTION);
    }
    
}
