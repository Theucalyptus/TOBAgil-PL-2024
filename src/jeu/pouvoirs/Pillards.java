package jeu.pouvoirs;

/**Classe Pillards. L'Pillards est un pouvoir qui rend plus riche.*/
public class Pillards extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Pillards";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Toute région non-vide conquise durant ce tour "
            + "rapporte 1 jeton de victoire supplémentaire "
            + "en fin de tour.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 5;

    /**Construire un Pillards. */
    public Pillards() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }

}
