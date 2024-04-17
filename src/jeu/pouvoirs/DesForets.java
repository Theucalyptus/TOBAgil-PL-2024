package jeu.pouvoirs;

/**Classe DesForets. L'DesForets est un pouvoir qui rend plus riche.*/
public class DesForets extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "DesForets";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Prenez 1 jetons de victoire "
            + "supplémentaire pour chaque Forêt que vous occupez en fin de tour.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int UNITESUP = 4;

    /**Construire un DesForets. */
    public DesForets() {
        super(TypesPouvoirs.DES_FORETS, NOM, DESCRIPTION, UNITESUP);
    }

}
