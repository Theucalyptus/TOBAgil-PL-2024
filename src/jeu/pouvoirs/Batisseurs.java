package jeu.pouvoirs;

/**Classe Batisseur. Le Batisseur est un pouvoir qui permet de placer une forteresse 
 * qui augmente de 1 point la défense de la case et qui donne 1 point de victoire a chaque fin de tour.
 * La rémunération s'arrete une fois en déclin mais la défense reste. */
public class Batisseurs extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Batisseurs";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Une fois par tour, placez une Forteresse "
            + "dans une région que vous occupez. Elle vous rapporte 1 jetons de victoires "
            + "supplémentaire à la fin de chacun de vos tours, à moins que vous ne soyez "
            + "ou passez en déclin. Toute Forteresse augmente la défense de la région d'un "
            + "point (comme s'il vous aviez un Pion de Peuple supplémentaire), même si "
            + "vous êtes ou passez en déclin. Lorsqu'un ennemi s'empare de votre région, "
            + "retirer la Forteresse. Il ne peut y avoir qu'une seule Forteresse par "
            + "région, et un maximum de 6 Forteresses sur le plateau.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int UNITESUP = 3;

    /**Construire un Batisseur. */
    public Batisseurs() {
        super(TypesPouvoirs.BATISSEURS, NOM, DESCRIPTION, UNITESUP);
    }

}
