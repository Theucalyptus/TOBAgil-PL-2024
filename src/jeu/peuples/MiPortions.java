package jeu.peuples;

/**Classe d'implémantation du peuples des Mi-Portions. */
public class MiPortions extends Peuple {
    
        
    /** Le nom des Mi-Portions. */
    private static final String NOM = "Mi-Portions";

    /** La Description des Mi-Portions et de leur capacité. */
    private static final String DESCRIPTION = "Vos Mi-portions peuvent entrer sur le\n" +
            "plateau par n'importe quelle région, pas\n" +
            "seulement par un bord de plateau. Placez\n" +
            "une Tanière dans les deux premières régions\n" +
            "que vous prenez. Ces régions sont à présent imprenables et\n" +
            "immunisées contre les capacités spécifiques et Pouvoirs\n" +
            "Spéciaux des autres Peuples. Si une de ces régions est\n" +
            "abandonnée par les Mi-portions, la Tanière qui s'y trouve est\n" + 
            "retirée du plateau. En déclin, les deux Tanières disparaissent.";

    /** Le nombre de Mi-Portions sans le nombre associé au pouvoir */
    private static final int PIONSSUP = 6;

    // Constructeur

    /** Construire les Mi-Portions */
    public MiPortions() {
        super(TypesPeuples.MIPORTIONS, NOM, DESCRIPTION, PIONSSUP);
    }

}
