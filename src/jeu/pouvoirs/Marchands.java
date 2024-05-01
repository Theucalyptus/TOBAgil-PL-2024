package jeu.pouvoirs;

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

    /**Construire un Marchands. */
    public Marchands() {
        super(TypesPouvoirs.MARCHANDS, NOM, DESCRIPTION, PIONSSUP);
    }

}
