package jeu.pouvoirs;

/**Classe AuxDeuxHeros. Les deux héros est un pouvoir qui défend et rend 
 * imprenable 2 tuiles du peuple.*/
public class AuxDeuxHeros extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Aux Deux Héros";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "A la fin de chacun de vos tours, "
            + "choisissez deux régions que vous occupez et placez un Héros dans "
            + "chacune d'entre elles. Tant qu'ils y restent, ces régions sont "
            + "imprenables et immunisées aux capacités spécifique et Pouvoirs spéciaux des "
            + "Peuples adverses. Les Héros disparaissent lorsque vous passez en déclin.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 5;

    /**Construire une instance de Aux Deux Héros. */
    public AuxDeuxHeros() {
        super(TypesPouvoirs.AUX_DEUX_HEROS, NOM, DESCRIPTION, PIONSSUP);
    }

}
