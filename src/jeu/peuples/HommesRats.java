package jeu.peuples;

/**Classe d'implémantation du peuple des Hommes-Rats. */
public class HommesRats extends Peuple {
    
    /** Le nom des HommesRats. */
    private static final String NOM = "Hommes-Rats";

    /** La Description des HommesRats et de leur capacité. */
    private static final String DESCRIPTION = "Pas de Capacité spécifique, ils sont déjà\n" +
            "bien assez nombreux !";

    /** Le nombre d'Homme-Rats sans le nombre associé au pouvoir */
    private static final int PIONSSUP = 8;

    // Constructeur

    /** Construire les Hommes-Rats */
    public HommesRats() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }
}
