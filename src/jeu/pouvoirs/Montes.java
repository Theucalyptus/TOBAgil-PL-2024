package jeu.pouvoirs;

/**Classe Montes. L'Montes est un pouvoir qui rend plus riche.*/
public class Montes extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Montes";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Toutes Collines et tout Champ "
    + "peuvent être conquis avec un "
    + "pion de Peuple de moins que "
    + "nécessaire, avec un minimum "
    + "de 1 pion.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 5;

    /**Construire un Montes. */
    public Montes() {
        super(TypesPouvoirs.MONTES, NOM, DESCRIPTION, PIONSSUP);
    }

}
