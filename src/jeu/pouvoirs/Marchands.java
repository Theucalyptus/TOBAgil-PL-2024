package jeu.pouvoirs;

import jeu.Case;
import jeu.TypesRegions;

/**Classe Marchands. L'Marchands est un pouvoir qui rend plus riche.*/
public class Marchands extends Pouvoir {

    /**Le nom de la classe. */
    private static final String NOM = "Marchands";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Prenez 1 jeton de victoire "
        + "supplémentaire pour chaque région que vous occupez en fin "
        + "de tour.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 2;

    /**Le nombre de régions conquises. */
    private int nbRegions = 0;

    /**Construire un Marchands. */
    public Marchands() {
        super(TypesPouvoirs.MARCHANDS, NOM, DESCRIPTION, PIONSSUP);
    }

    @Override
public void apresConquete(Case regionConquise) {
        System.out.println("Gain d'une région");
        this.nbRegions++;
    }

    @Override
    public void apresConqueteAdverse(Case regionConquise) {
        System.out.println("Perte d'une région");
        this.nbRegions--;
    }

    @Override
    public void finTour(boolean enDeclin) {
        if (!enDeclin) {
            System.out.println(this.nbRegions + " régions possédées");
            this.nbJetons = this.nbRegions;
        } else {
            this.nbJetons = 0;
        }
    }
}
