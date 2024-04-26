package jeu.pouvoirs;

/**Classe Diplomates. L'Diplomates est un pouvoir qui rend plus riche.*/
public class Diplomates extends Pouvoir {
    
    /**Le nom de la classe. */
    private static final String NOM = "Diplomates";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "A la fin de votre tour, vous pouvez "
            + "choisir un autre joueur qui devient aussitôt votre allié, à condition que "
            + "vous ne l'ayez pas attaqueé son Peuple actif pendant ce tour. Vous êtes à "
            + "présent en paix avec lui. Il ne pourra pas attaquer votre Peuple actif "
            + "avant votre prochain tour. Vous pouvez changer d'allié à chaque tour ou "
            + "rester en paix avec le même joueur. Les pions  en déclin ne sont pas "
            + "concernés par cet accord (par exemple, des Zombies en déclin n'ont que "
            + "faire de la paix et pourront vous attaquer) !";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int UNITESUP = 5;

    /**Construire un Diplomates. */
    public Diplomates() {
        super(TypesPouvoirs.DIPLOMATES, NOM, DESCRIPTION, UNITESUP);
    }

}
