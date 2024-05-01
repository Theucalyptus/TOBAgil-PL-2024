package jeu.peuples;

import jeu.Case;
import jeu.TypesRegions;

/**Classe d'implémantation du peuple des Humains. */
public class Humains extends Peuple {

    /** Le nom des Humains. */
    private static final String NOM = "Humains";

    /** La Description des Humains et de leur capacité. */
    private static final String DESCRIPTION = "Tout Champ occupé par vos "
            + "Humains rapporte 1 jeton "
            + "de victoire supplémentaire "
            + "en fin de tour.";

    /** Le nombre d'Humains sans le nombre associé au pouvoir. */
    private static final int PIONSSUP = 5;

    /** Le nombre de régions comportant un Champ contrôlé par ce peuple. */
    private int nbChamps = 0;

    // Constructeur

    /** Construire les Humains. */
    public Humains() {
        super(TypesPeuples.HUMAINS, NOM, DESCRIPTION, PIONSSUP);
    }

    @Override
    public void apresConquete(Case regionConquise) {
    	if (regionConquise.getTypeRegion() == TypesRegions.CHAMP) {
    		this.nbChamps++;
    	}
    }

    @Override
    public void apresConqueteAdverse(Case regionConquise) {
    	if (regionConquise.getTypeRegion() == TypesRegions.CHAMP) {
    		this.nbChamps--;
    	}
    }

    @Override
    public void finTour(boolean enDeclin) {
    	if (!enDeclin) {
        	this.nbJetons = this.nbChamps;
    	}
    }
}
