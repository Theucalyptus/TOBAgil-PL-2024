package jeu.pouvoirs;

import jeu.Case;
import jeu.TypesRegions;

/**Classe DesForets. L'DesForets est un pouvoir qui rend plus riche.*/
public class DesForets extends Pouvoir {

    /**Le nom de la classe. */
    private static final String NOM = "DesForets";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Prenez 1 jetons de victoire "
            + "supplémentaire pour chaque Forêt que vous occupez en fin de tour.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 4;

    /**Le nombre de forêts conquises. */
    private int nbForets = 0;

    /**Construire un DesForets. */
    public DesForets() {
        super(TypesPouvoirs.DES_FORETS, NOM, DESCRIPTION, PIONSSUP);
    }

    @Override
    public void apresConquete(Case regionConquise) {
        if (regionConquise.getTypeRegion() == TypesRegions.FORET) {
            System.out.println("Gain d'une forêt");
            this.nbForets++;
        }
    }

    @Override
    public void apresConqueteAdverse(Case regionConquise) {
        if (regionConquise.getTypeRegion() == TypesRegions.FORET) {
            System.out.println("Perte d'une forêt");
            this.nbForets--;
        }
    }

    @Override
    public void finTour(boolean enDeclin) {
        if (!enDeclin) {
            System.out.println(this.nbForets + " forêts possédées");
            this.nbJetons = this.nbForets;
        } else {
            this.nbJetons = 0;
        }
    }

}
