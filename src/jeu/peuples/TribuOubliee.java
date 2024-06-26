package jeu.peuples;

/**Classe d'implémantation du peuple de la tribu oubliée, la tribu
 * présente sur la carte au début de la partie.
 */
public class TribuOubliee extends Peuple {

    /** Le nom des TribuOubliee. */
    private static final String NOM = "TribuOubliee";

    /** La Description des TribuOubliee et de leur capacité. */
    private static final String DESCRIPTION = "Les Tribus "
                + "oubliées sont d'anciennes civilisations tombées en "
                + "déclin mais dont les derniers survivants occupent "
                + "encore quelques régions... enfin, pour l'instant !";

    /** Le nombre de TribuOubliee sans le nombre associé au pouvoir. */
    private static final int PIONSSUP = 0;

    // Constructeur

    /** Construire les TribuOubliee. */
    public TribuOubliee() {
        super(TypesPeuples.TRIBU_OUBLIEE, NOM, DESCRIPTION, PIONSSUP);
    }
}
