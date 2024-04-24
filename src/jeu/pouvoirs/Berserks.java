package jeu.pouvoirs;

/**Classe Berserks. Le Berserk est un pouvoir qui permet d'utiliser le dé de renfort
 * pour chaque tuile que
 * l'on attaque.*/
public class Berserks extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Berserks";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Vous pouvez utiliser le dé de renforts "
            + "avant chaque conquète. pas seulement avant le ma dernière de votre tour ! "
            + "A la différence d'un jet de renfort normal, lancez le dé, puis choisissez "
            + "la région que vous voulez prendre et placez les pions de Peuple, il "
            + "s'agissait de votre dernière conquète ce tour-ci. Comme d'habitude, "
            + "un minimum de 1 pion de Peuple est requis pour chaque conquète.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 4;

    /**Construire un Berserks. */
    public Berserks() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }

}
