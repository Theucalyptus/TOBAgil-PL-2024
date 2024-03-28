package jeu.peuples;

public class Zombies extends Peuple {
    
    /** Le nom des Zombies. */
    private static final String NOM = "Zombies";

    /** La Description des Zombies et de leur capacité. */
    private static final String DESCRIPTION = "Lorsque vos Zombies passent en déclin,\n" +
            "tous leurs pions restent sur le plateau ! De\n" +
            "plus, contrairement aux autres Peuples en\n" +
            "déclin, ils peuvent continuer à conquérir\n" +
            "de nouvelles régions à chaque tour et se\n" +
            "comportent exactement comme un Peuple actif (même\n" +
            "lorsqu'ils sont attaqués), mais leurs conquêtes doivent être\n" +
            "faites au début de votre tour, avant les conquêtes de votre\n" +
            "Peuple actif. Un joueur a le droit d'attaquer son Peuple actif\n" +
            "avec ses Zombies en déclin.";

    /** Le nombre de Zombies sans le nombre associé au pouvoir */
    private static final int UNITECLASSE = 6;

    // Constructeur

    /** Construire les Zombies */
    public Zombies() {
        super(TypesPeuples.ZOMBIES, NOM, DESCRIPTION, UNITECLASSE);
    }
}
