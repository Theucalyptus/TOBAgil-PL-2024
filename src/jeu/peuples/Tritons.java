package jeu.peuples;

import jeu.Case;
import jeu.TypesRegions;

/**Classe d'implémantation du peuple des Tritons. */
public class Tritons extends Peuple {

    /** Le nom des Tritons. */
    private static final String NOM = "Tritons";

    /** La Description des Tritons et de leur capacité. */
    private static final String DESCRIPTION = "Vos Tritons peuvent conquérir toute "
        + "région côtière (adjacente aux mers ou au lac) avec "
        + "1 pion de moins que nécessaire, avec un "
        + "minimum de 1 pion.";

    /** Le nombre de Tritons sans le nombre associé au pouvoir. */
    private static final int PIONSSUP = 6;

    // Constructeur

    /** Construire les Tritons. */
    public Tritons() {
        super(TypesPeuples.TRITONS, NOM, DESCRIPTION, PIONSSUP);
    }

    public void avantConquete(Case regionAConquerir) {
        boolean estCotiere = false;
        for (Case voisin : regionAConquerir.getVoisins()) {
            if (voisin.getTypeRegion() == TypesRegions.MER_ET_LAC) {
                estCotiere = true;
            }
        }

        if (estCotiere) {
            reductionAttaque = 1;
        } else {
            reductionAttaque = 0;
        }
    }
}
