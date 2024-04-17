package jeu.pouvoirs;

/**Classe Scouts. L'Scouts est un pouvoir qui rend plus riche.*/
public class Scouts extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Scouts";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Placez les 5 jetons de Campement dans la ou "
            + "les  régions  que  vous  occupez,  pendant la "
            + "phase de Redéploiement. Tout Campement "
            + "compte comme un pion de Peuple supplémentaire "
            + "et donc augmente la défense de la "
            + "région d'un point (cela le protège également contre la capacité "
            + "spécifique du Sorcier). Il est possible de placer "
            + "plusieurs Campements dans la même région "
            + "pour augmenter sa défense. Les Campements "
            + "phase de Redéploiement. Tout Campement "
            + "compte comme un pion de Peuple supplémentaire "
            + "et donc augmente la défense de la "
            + "région d'un point (cela le protège également contre la capacité "
            + "spécifique du Sorcier). Il est possible de placer "
            + "plusieurs Campements dans la même région "
            + "pour augmenter sa défense. Les Campements "
            + "peuvent être répartis à votre convenance dans "
            + "les régions que vous occupez à chaque tour. Ils "
            + "disparaissent lors du déclin.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int UNITESUP = 5;

    /**Construire un Scouts. */
    public Scouts() {
        super(TypesPouvoirs.SCOUTS, NOM, DESCRIPTION, UNITESUP);
    }

}
