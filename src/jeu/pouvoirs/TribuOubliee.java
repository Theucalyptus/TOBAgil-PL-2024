package jeu.pouvoirs;

/**Classe TribuOubliee. Pouvoir factive pour créer une combinaison. */
public class TribuOubliee extends Pouvoir {

    /**Le nom de la classe. */
    private static final String NOM = "Tribu Oubliée";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Pouvoir factice de la tribu oubliée";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = -1;

    /**Construire un Armé. */
    public TribuOubliee() {
        super(TypesPouvoirs.TRIBU_OUBLIEE, NOM, DESCRIPTION, PIONSSUP);
    }

}
