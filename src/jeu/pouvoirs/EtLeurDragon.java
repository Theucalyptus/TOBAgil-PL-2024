package jeu.pouvoirs;

/**Classe EtLeurDragon. Le Dragon est un pouvoir qui rend plus riche.*/
public class EtLeurDragon extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Et Leur Dragon";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Une fois par tour, vous pouvez conquérir une "
            + "région adjacente en utilisant un seul pion "
            + "de Peuple, indépendamment du nombre de "
            + "pions  ennemis  qui  s'y  trouve.  Une  fois "
            + "conquise,  placez  votre  Dragon  dans  cette "
            + "région. Cette région est désormais imprenable et immunisée "
            + "aux capacités spécifiques et aux Pouvoirs Spéciaux des Peuples "
            + "adverses,  jusqu'à  ce  que  votre  Dragon  parte  capturer  une "
            + "nouvelle région. À chaque nouveau tour, vous pouvez déplacer "
            + "votre Dragon vers une nouvelle région pour vous en emparer. "
            + "Votre Dragon disparaît lorsque vous passez en déclin : retirez-le "
            + "alors du plateau.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 5;

    /**Construire un EtLeurDragon. */
    public EtLeurDragon() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }

}
