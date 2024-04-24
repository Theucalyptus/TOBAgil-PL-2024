package jeu.peuples;

/**Classe d'implémantation du peuple des Humains */
public class Humains extends Peuple {
    
    /** Le nom des Humains. */
    private static final String NOM = "Humains";

    /** La Description des Humains et de leur capacité. */
    private static final String DESCRIPTION = "Tout Champ occupé par vos\n" +
            "Humains rapporte 1 jeton\n" +
            "de victoire supplémentaire\n" +
            "en fin de tour.";

    /** Le nombre d'Humains sans le nombre associé au pouvoir */
    private static final int PIONSSUP = 5;

    // Constructeur

    /** Construire les Humains */
    public Humains() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }
}
