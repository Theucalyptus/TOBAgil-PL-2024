package jeu.peuples;

/**
 * Classe d'implémantation du peuple des Elfes.
 */
public class Elfes extends Peuple {

    /** Le nom des Elfes. */
    private static final String NOM = "Elfes";

    /** La description des elfes avec sa capacité. */
    private static final String DESCRIPTION = "Lorsque l'ennemi s'empare d'une de vos "
                + "régions, vous reprenez en main tous les "
                + "pions Elfes qui l'occupaient, sans devoir en "
                + "défausser un . Redéployez ces pions comme d'habitude "
                + "lorsque l'adversaire a fini son tour.";

    /** Le nombre d'unité que le joueur obtient pour le peuple des Elfes. Il faut y
     * ajouter le nombre donné par le pouvoir pour savoir le nombre d'unité de ce
     * peuple possède. */
    private static final int PIONSSUP = 6;


    // Constructeur

    /** Construire le peuple des elfes. */
    public Elfes() {
        super(TypesPeuples.ELFES, NOM, DESCRIPTION, PIONSSUP);
    }

}
