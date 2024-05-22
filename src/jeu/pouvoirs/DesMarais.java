package jeu.pouvoirs;

import jeu.Case;
import jeu.TypesRegions;

/**Classe DesMarais. L'DesMarais est un pouvoir qui rend plus riche.*/
public class DesMarais extends Pouvoir {

    /**Le nom de la classe. */
    private static final String NOM = "DesMarais";


    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Prenez 1 jetons de victoire "
            + "supplémentaire pour chaque Marais que vous occupez en fin de tour.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 4;


    /**Le nombre de marais conquis. */
    private int nbMarais = 0;

    /**Construire un DesMarais. */
    public DesMarais() {
        super(TypesPouvoirs.DES_MARAIS, NOM, DESCRIPTION, PIONSSUP);
    }

    @Override
    public void apresConquete(Case regionConquise) {
        if (regionConquise.getTypeRegion() == TypesRegions.MARAIS) {
            System.out.println("Gain d'un marais");
            this.nbMarais++;
        }
    }

    @Override
    public void apresConqueteAdverse(Case regionConquise) {
        if (regionConquise.getTypeRegion() == TypesRegions.MARAIS) {
            System.out.println("Perte d'un marais");
            this.nbMarais--;
        }
    }

    @Override
    public void finTour(boolean enDeclin) {
        if (!enDeclin) {
            System.out.println(this.nbMarais + " marais possédés");
            this.nbJetons = this.nbMarais;
        } else {
            this.nbJetons = 0;
        }
    }
}
