package jeu.pouvoirs;

/**Classe Alchimiste. L'Alchimiste est un pouvoir qui rend plus riche.*/
public class DurACuire extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Dur à Cuire";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Vous pouvez poursuivre votre expansion ET "
            + "passer en déclin immédiatement après avoir pris vos jetons de victoires, ce qui vous "
            + "évite de perdre un tour pour passer en déclin. Les règles du declin s'appliquent, "
            + "vous ne marquez pas une seconde fois les points de victoire en fin de tour.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 4;

    /**Construire un Alchimiste. */
    public DurACuire() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }

}
