package jeu.peuples;

/**Classe d'implémantation du peuples des Mages. */
public class Mages extends Peuple {
    
    /** Le nom des Mages. */
    private static final String NOM = "Mages";

    /** La Description des Mages et de leur capacité. */
    private static final String DESCRIPTION = "oute région qui comporte une\n" + //
            "Source magique occupée par\n" +
            "vos Mages rapporte 1 jeton de\n" +
            "victoire supplémentaire en fin\n" +
            "de tour.";

    /** Le nombre de Mages sans le nombre associé au pouvoir */
    private static final int PIONSSUP = 5;

    // Constructeur

    /** Construire les Mages */
    public Mages() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }
}
