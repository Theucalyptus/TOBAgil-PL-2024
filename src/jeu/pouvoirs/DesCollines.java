package jeu.pouvoirs;

import jeu.Case;
import jeu.TypesRegions;

/**Classe Des Collines. Les Collines est un pouvoir qui rend plus riche.*/
public class DesCollines extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Des Collines";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Prenez 1 jeton de victoire "
            + "supplémentaire pour chaque Colline que vous occupez en fin de tour.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 4;

    /**Le nombre de collines conquises */
    private int nbCollines = 4;

    /**Construire un Des Collines. */
    public DesCollines() {
        super(TypesPouvoirs.DES_COLLINES, NOM, DESCRIPTION, PIONSSUP);
    }

    @Override
    public void apresConquete(Case regionConquise) {
        if (regionConquise.getTypeRegion() == TypesRegions.COLLINE) {
            this.nbCollines++;
        }
    }

    @Override
    public void apresConqueteAdverse(Case regionConquise) {
        if (regionConquise.getTypeRegion() == TypesRegions.COLLINE) {
            this.nbCollines--;
        }
    }

    @Override
    public void finTour(boolean enDeclin) {
        if (!enDeclin) {
            this.nbJetons = this.nbCollines;
        }
    }

}
