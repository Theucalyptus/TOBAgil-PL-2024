package jeu.peuples;

/**Classe d'implémantation du peuple des zombies. */
public class Zombies extends Peuple {
    
    /** Le nom des Zombies. */
    private static final String NOM = "Zombies";

    /** La Description des Zombies et de leur capacité. */
    private static final String DESCRIPTION = "Lorsque vos Zombies passent en déclin, "
                + "tous leurs pions restent sur le plateau ! De "
                + "plus, contrairement aux autres Peuples en "
                + "déclin, ils peuvent continuer à conquérir "
                + "de nouvelles régions à chaque tour et se "
                + "comportent exactement comme un Peuple actif (même "
                + "lorsqu'ils sont attaqués), mais leurs conquêtes doivent être "
                + "faites au début de votre tour, avant les conquêtes de votre "
                + "Peuple actif. Un joueur a le droit d'attaquer son Peuple actif "
                + "avec ses Zombies en déclin.";

    /** Le nombre de Zombies sans le nombre associé au pouvoir */
    private static final int PIONSSUP = 6;

    // Constructeur

    /** Construire les Zombies */
    public Zombies() {
        super(TypesPeuples.ZOMBIES, NOM, DESCRIPTION, PIONSSUP);
    }
}
