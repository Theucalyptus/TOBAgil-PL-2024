package jeu.pouvoirs;

/**Classe Marins. Le Marin est un pouvoir qui permet de prendre les mers et lac.*/
public class Marins extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Marins";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Vous pouvez considérer les mers et le lac "
        + "comme trois régions vides et les conquérir. "
        + "Vous conservez ces régions même en déclin. "
        + "Elles vous rapportent des jetons de victoire "
        + "tant que vos pions y restent. Les mers et le "
        + "lac ne peuvent être occupés que par un Peuple qui dispose de "
        + "ce Pouvoir.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 5;

    /**Construire un Marins. */
    public Marins() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }

}
