package jeu.pouvoirs;

import jeu.Case;

/**Classe Pillards. L'Pillards est un pouvoir qui rend plus riche.*/
public class Pillards extends Pouvoir {

    /**Le nom de la classe. */
    private static final String NOM = "Pillards";

    /**La description du pouvoir. */
    private static final String DESCRIPTION = "Toute région non-vide conquise durant "
            + "ce tour rapporte 1 jeton de victoire supplémentaire "
            + "en fin de tour.";


    /**Le nombre d'unité suplémentaire qu'offre le jeu. */
    private static final int PIONSSUP = 5;

    /** Le nombre de régions non-vides conquises par les pillards dans ce tour. */
    private int nbRegionsConquises = 0;

    /** Indicateur du caractère vide d'une région pendant sa conquête. */
    private boolean estNonVide;

    /**Construire un Pillards. */
    public Pillards() {
        super(TypesPouvoirs.PILLARDS, NOM, DESCRIPTION, PIONSSUP);
    }

    @Override
    public void debutTour() {
    	this.nbRegionsConquises = 0;
    }

    @Override
    public void avantConquete(Case regionAConquerir) {
        if (regionAConquerir == null)
            throw new IllegalArgumentException("regionAConquerir ne doit pas être null.");
    	if (regionAConquerir.getNombrepions() != 0) {
    		this.estNonVide = true;
    	} else {
    		this.estNonVide = false;
    	}
    }

    @Override
    public void apresConquete(Case regionConquise) {
    	if (estNonVide) {
    		this.nbRegionsConquises++;
    	}
    }

    @Override
    public void finTour(boolean enDeclin) {
    	if (!enDeclin) {
        	this.nbJetons = this.nbRegionsConquises;
    	} else {
            this.nbJetons = 0;
        }
    }
}
