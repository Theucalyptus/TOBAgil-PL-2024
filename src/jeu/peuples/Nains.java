package jeu.peuples;

import jeu.Case;
import jeu.TypesSymboles;

/**Classe d'implémantation du peuple des Nains. */
public class Nains extends Peuple {
    
    /** Le nom des Nains. */
    private static final String NOM = "Nains";

    /** La Description des nains et de leur capacité. */
    private static final String DESCRIPTION = "Toute région qui comporte\n" +
            "une Mine occupée par vos\n" +
            "Nains rapporte 1 jeton de\n" +
            "victoire supplémentaire en fin\n" +
            "de tour. Ce pouvoir continue\n" +
            "de s'appliquer même s'ils sont en déclin.";

    /** Le nombre de nains sans le nombre associé au pouvoir */
    private static final int PIONSSUP = 3;

    /** Le nombre de régions comportant une Mine contrôlé par ce peuple.*/
    private int nbMines = 0;
    
    // Constructeur

    /** Construire les nains */
    public Nains() {
        super(NOM, DESCRIPTION, PIONSSUP);
    }
    
    @Override
    public void apresConquete(Case regionConquise) {
    	if(regionConquise.getTypeRessource() == TypesSymboles.MINE) {
    		this.nbMines ++;
    	}
    }
    
    @Override
    public void apresConqueteAdverse(Case regionConquise) {
    	if(regionConquise.getTypeRessource() == TypesSymboles.MINE) {
    		this.nbMines --;
    	}
    }
    
    @Override
    public void finTour(boolean enDeclin) {
    	this.nbJetons = this.nbMines;
    }

}