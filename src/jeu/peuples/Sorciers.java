package jeu.peuples;

public class Sorciers extends Peuple {
    
    /** Le nom des Sorciers. */
    private static final String NOM = "Sorciers";

    /** La Description des Sorciers et de leur capacité. */
    private static final String DESCRIPTION = "Une fois par tour et par adversaire, vos\n" +
            "Sorciers peuvent remplacer un pion adverse\n" +
            "actif par un des leurs (dans la limite de 18 unité en tout)\n" +
            "pour conquérir une région. Le pion en\n" +
            "question doit être le seul de son Peuple dans la région (un Troll\n" +
            "dans son Antre est considéré comme étant tout seul ; de même,\n" +
            "une Montagne ou une Forteresse ne protègent pas un pion\n" +
            "contre ce genre de conquête). Cette région doit être adjacente\n" +
            "à une région appartenant aux Sorciers. Le pion adverse\n" +
            "remplacé est remis dans le casier de rangement.";

    /** Le nombre de Sorciers sans le nombre associé au pouvoir */
    private static final int UNITECLASSE = 6;

    // Constructeur

    /** Construire les Sorciers */
    public Sorciers() {
        super(TypesPeuples.SORCIERS, NOM, DESCRIPTION, UNITECLASSE);
    }
}
