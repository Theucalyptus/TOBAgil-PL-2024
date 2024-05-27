package jeu.pouvoirs;

/**Classe Alchimistes. L'Alchimiste est un pouvoir qui rend plus
 * riche sur le long terme. */
public class Alchimistes extends Pouvoir {

    /**Le nom de la classe. */
    private static final String NOM = "Alchimistes";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Tant que votre Peuple "
            + "Alchimiste est actif, prenez 2 jetons de "
            + "victoire supplémentaires à la fin de chaque tour";

    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 4;

    /**Le nombre de point gagné à chaque fin de tour. */
    private static final int GAIN = 2;

    /**Construire un Alchimiste. */
    public Alchimistes() {
        super(TypesPouvoirs.ALCHIMISTES, NOM, DESCRIPTION, PIONSSUP);
    }

    @Override
    public void finTour(boolean enDeclin) {
        if (!enDeclin) {
            this.nbJetons = GAIN;
        } else {
            this.nbJetons = 0;
        }
    };
}
