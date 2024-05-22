package jeu.peuples;

import jeu.Case;
import jeu.TypesSymboles;

/**Classe d'implémantation du peuples des Mages. */
public class Mages extends Peuple {

    /** Le nom des Mages. */
    private static final String NOM = "Mages";

    /** La Description des Mages et de leur capacité. */
    private static final String DESCRIPTION = "Toute région qui comporte une Source "
                + "magique occupée par vos Mages rapporte 1 jeton de victoire "
                + "supplémentaire en fin de tour.";

    /** Le nombre de Mages sans le nombre associé au pouvoir. */
    private static final int PIONSSUP = 5;

    /** Le nombre de régions comportant une Source Magique contrôlée par ce peuple.*/
    private int nbSources = 0;

    // Constructeur

    /** Construire les Mages. */
    public Mages() {
        super(TypesPeuples.MAGES, NOM, DESCRIPTION, PIONSSUP);
    }

    @Override
    public void apresConquete(Case regionConquise) {
        if (regionConquise == null)
            throw new IllegalArgumentException("regionConquise ne doit pas être null.");
    	if (regionConquise.getTypeRessource() == TypesSymboles.SOURCE_MAGIQUE) {
    		this.nbSources++;
    	}
    }

    @Override
    public void apresConqueteAdverse(Case regionConquise) {
        if (regionConquise == null)
            throw new IllegalArgumentException("regionConquise ne doit pas être null.");
    	if (regionConquise.getTypeRessource() == TypesSymboles.SOURCE_MAGIQUE) {
    		this.nbSources--;
    	}
    }

    @Override
    public void finTour(boolean enDeclin) {
    	if (!enDeclin) {
        	this.nbJetons = this.nbSources;
    	} else {
            this.nbJetons = 0;
        }
    }

}
