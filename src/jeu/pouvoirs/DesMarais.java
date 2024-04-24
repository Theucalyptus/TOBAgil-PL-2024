package jeu.pouvoirs;

/**Classe DesMarais. L'DesMarais est un pouvoir qui rend plus riche.*/
public class DesMarais extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "DesMarais";


    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Prenez 1 jetons de victoire "
            + "supplémentaire pour chaque Marais que vous occupez en fin de tour.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 4;

    /**Construire un DesMarais. */
    public DesMarais() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }

}
