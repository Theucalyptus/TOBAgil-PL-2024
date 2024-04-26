package jeu.pouvoirs;

/**Classe DesCavernes. Les Cavernes est un pouvoir qui permet de prendre plus facilement
 * les territoires
 * avec des cavernes. Et les territoires avec des Cavernes sont adjacente au votre.*/
public class DesCavernes extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Des Cavernes";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Toute région qui comporte une Caverne "
            + "peut être conquise avec 1 pion de Peuple de moins que nécessaire, avec un "
            + "minimum de 1 pion. De plus, pour vos conquètes, toutes les régions qui "
            + "comportent une caverne sont considérées comme adjacentes entre-elles.";

    private static final int UNITESUP = 5;

    /**Construire un DesCavernes. */
    public DesCavernes() {
        super(TypesPouvoirs.DES_CAVERNES, NOM, DESCRIPTION, UNITESUP);
    }

}
