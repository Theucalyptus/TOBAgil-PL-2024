package jeu.pouvoirs;

/**Classe Armé. Les Armés est un pouvoir qui rend permet d'économiser des pions
 * d'attaques. */
public class Armes extends Pouvoir {

    /**Le nom de la classe. */
    private static final String NOM = "Armés";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Toute région peut être conquise avec "
            + "1 pion de "
            + "Peuple de moins que nécessaire, avec un minimum de 1 pion.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 4;

    /**Construire un Armé. */
    public Armes() {
        super(TypesPouvoirs.ARMES, NOM, DESCRIPTION, PIONSSUP);
        this.reductionAttaque = 1;
    }


}
