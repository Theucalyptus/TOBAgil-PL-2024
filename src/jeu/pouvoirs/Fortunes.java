package jeu.pouvoirs;

/**Classe Fortunes. L'Fortunes est un pouvoir qui rend plus riche.*/
public class Fortunes extends Pouvoir {

    /**Le nom de la classe. */
    private static final String NOM = "Fortunes";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Prenez 7 jetons de victoire "
            + "supplémentaires à la fin de votre premier tour d'expansion "
            + "(donc une seule fois).";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 4;

    /**Booléen informant si le pouvoir à bien donné les points. */
    private boolean noPoints = true;

    /**Le nombre de point gagné à la première expension. */
    private int nombreGagne = 7;

    /**Construire un Fortunes. */
    public Fortunes() {
        super(TypesPouvoirs.FORTUNES, NOM, DESCRIPTION, PIONSSUP);
    }

    @Override
    public void finTour(boolean enDeclin) {
        if (!enDeclin && this.noPoints) {
            this.nbJetons = this.nombreGagne;
            this.noPoints = false;
        } else {
            this.nbJetons = 0;
        }
    }
}
