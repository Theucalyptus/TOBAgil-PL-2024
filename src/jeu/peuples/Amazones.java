package jeu.peuples;

/**
 * Classe d'implémantation du peuple des Amazones.
 */
public class Amazones extends Peuple {

    /** Le nom des Amazones. */
    private static final String NOM = "Amazones";

    /** La Description des Amazones et de leur capacité. */
    private static final String DESCRIPTION = "La valeur +4 indiquée sur la tuile Amazones\n" +
            "signifie que vous prenez 4 pions supplémen-\n" +
            "taires (donc 10 en tout, auxquels il faut\n" +
            "encore ajouter ceux du Pouvoir Spécial),\n" +
            "mais ces 4 pions sont réservés à l'attaque\n" +
            "uniquement et ne servent pas en défense. Après avoir\n" +
            "redéployé vos troupes, retirez donc\n" +
            "quatre pions Amazones du plateau et mettez-les de côté, en\n" +
            "prenant soin de laisser tout de même 1 pion Amazone dans\n" +
            "chaque région occupée, dans la mesure du possible. Reprenez\n" +
            "vos 4 pions en main au début du prochain tour, au moment de\n" +
            "préparer ses troupes.";

    /** Le nombre d'Amazone sans le nombre associé au pouvoir */
    private static final int UNITECLASSE = 6;

    // Constructeur

    /** Construire les Amazones */
    public Amazones() {
        super(TypesPeuples.AMAZONES, NOM, DESCRIPTION, UNITECLASSE);
    }
}
