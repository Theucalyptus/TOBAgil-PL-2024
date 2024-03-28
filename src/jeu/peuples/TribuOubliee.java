package jeu.peuples;

public class TribuOubliee extends Peuple {
    
    /** Le nom des TribuOubliee. */
    private static final String NOM = "TribuOubliee";

    /** La Description des TribuOubliee et de leur capacité. */
    private static final String DESCRIPTION = "Les Tribus\n" +
            "oubliées sont d'anciennes civilisations tombées en\n" +
            "déclin mais dont les derniers survivants occupent\n" +
            "encore quelques régions... enfin, pour l'instant !";

    /** Le nombre de TribuOubliee sans le nombre associé au pouvoir */
    private static final int UNITECLASSE = 10;

    // Constructeur

    /** Construire les TribuOubliee */
    public TribuOubliee() {
        super(TypesPeuples.TRIBU_OUBLIEE, NOM, DESCRIPTION, UNITECLASSE);
    }
}
