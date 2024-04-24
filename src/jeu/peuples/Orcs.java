package jeu.peuples;

/**Classe d'implémantation du peuples des Orcs. */
public class Orcs extends Peuple {
    
    /** Le nom des Orcs. */
    private static final String NOM = "Orcs";

    /** La Description des Orcs et de leur capacité. */
    private static final String DESCRIPTION = "Toute région non-vide conquise par vos Orcs\n" +
            "durant ce tour rapporte 1 jeton de victoire\n" +
            "supplémentaire en fin de tour.";

    /** Le nombre d'Orcs sans le nombre associé au pouvoir */
    private static final int PIONSSUP = 5;

    // Constructeur

    /** Construire les Orcs */
    public Orcs() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }
}
