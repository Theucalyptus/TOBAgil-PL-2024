package jeu.peuples;

/**Classe d'implémantation de la Classe des Trolls. */
public class Trolls extends Peuple {

    /** Le nom des Trolls. */
    private static final String NOM = "Trolls";

    /** La Description des Trolls et de leur capacité. */
    private static final String DESCRIPTION = "Placez un Antre de Troll dans chaque "
            + "région occupée par vos Trolls. L'Antre de Troll "
            + "augmente la défense de la région d'un point "
            + "(comme si vous aviez un pion de Peuple "
            + "supplémentaire) et reste dans la région "
            + "même lorsque vos Trolls sont en déclin. Si vous quittez la région "
            + "ou qu'un adversaire vous en chasse, retirez l'Antre de Troll.";

    /** Le nombre de Trolls sans le nombre associé au pouvoir. */
    private static final int PIONSSUP = 6;

    // Constructeur

    /** Construire les Trolls. */
    public Trolls() {
        super(TypesPeuples.TROLLS, NOM, DESCRIPTION, PIONSSUP);
    }
}
