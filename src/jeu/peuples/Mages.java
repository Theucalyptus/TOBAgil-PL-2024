package jeu.peuples;

import jeu.Case;
import jeu.TypesSymboles;

/**Classe d'implémantation du peuples des Mages. */
public class Mages extends Peuple {
    
    /** Le nom des Mages. */
    private static final String NOM = "Mages";

    /** La Description des Mages et de leur capacité. */
    private static final String DESCRIPTION = "oute région qui comporte une\n" + //
            "Source magique occupée par\n" +
            "vos Mages rapporte 1 jeton de\n" +
            "victoire supplémentaire en fin\n" +
            "de tour.";

    /** Le nombre de Mages sans le nombre associé au pouvoir */
    private static final int PIONSSUP = 5;
    
    /** Le nombre de régions comportant une Source Magique contrôlée par ce peuple.*/
    private int nbSources = 0;

    // Constructeur

    /** Construire les Mages */
    public Mages() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }
    
    @Override
    public void apresConquete(Case regionConquise) {
    	if(regionConquise.getTypeRessource() == TypesSymboles.SOURCE_MAGIQUE) {
    		this.nbSources ++;
    	}
    }
    
    @Override
    public void apresConqueteAdverse(Case regionConquise) {
    	if(regionConquise.getTypeRessource() == TypesSymboles.SOURCE_MAGIQUE) {
    		this.nbSources --;
    	}
    }
    
    @Override
    public void finTour(boolean enDeclin) {
    	if(!enDeclin) {
        	this.nbJetons = this.nbSources;
    	}
    }
    
}