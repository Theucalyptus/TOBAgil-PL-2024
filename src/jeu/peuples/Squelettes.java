package jeu.peuples;

/**Classe d'implémantation du peuple des Squelettes. */
public class Squelettes extends Peuple {
    
    /** Le nom des Squelettes. */
    private static final String NOM = "Squelettes";

    /** La Description des Squelettes et de leur capacité. */
    private static final String DESCRIPTION = "Lors du Redéploiement de vos troupes, "
            + "prenez 1 nouveau pion "
            + "Squelette (dans la limite de 20 unité) "
            + "pour toute série de 2 "
            + "régions non-vides conquises par vos "
            + "Squelettes lors de ce tour, et ajoutez ce pion à ceux que vous "
            + "redéployez à la fin de votre tour.";

    /** Le nombre de Squelettes sans le nombre associé au pouvoir */
    private static final int PIONSSUP = 6;

    // Constructeur

    /** Construire les Squelettes */
    public Squelettes() {
        super(TypesPeuples.SQUELETTES, NOM, DESCRIPTION, PIONSSUP);
    }
}
