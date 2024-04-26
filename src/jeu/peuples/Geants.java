package jeu.peuples;

/**
 * Classe d'implémantation du peuple des Géants. 
 */
public class Geants extends Peuple {
    
    /** Le nom des Geants. */
    private static final String NOM = "Geants";

    /** La Description des Geants et de leur capacité. */
    private static final String DESCRIPTION = "Vos Géants peuvent conquérir toute\n" +
            "région adjacente à une Montagne\n" +
            "qu'ils occupent avec 1 pion de moins que\n" +
            "nécessaire, avec un minimum de 1 pion.";

    /** Le nombre de Geants sans le nombre associé au pouvoir */
    private static final int UNITECLASSE = 6;

    // Constructeur

    /** Construire les Geants */
    public Geants() {
        super(TypesPeuples.GEANTS, NOM, DESCRIPTION, UNITECLASSE);
    }
}
