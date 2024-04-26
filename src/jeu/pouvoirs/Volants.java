package jeu.pouvoirs;

/**Classe Volants. L'Volants est un pouvoir qui rend plus riche.*/
public class Volants extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Volants";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Vous  pouvez  conquérir  n'importe  "
            + "quelle région de la carte, même si elle n'est pas "
            + "adjacente à une des vôtres. Les mers et le "
            + "lac  ne peuvent pas être conquis. ";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 5;

    /**Construire un Volants. */
    public Volants() {
        super(TypesPouvoirs.VOLANTS, NOM, DESCRIPTION, PIONSSUP);
    }

}
