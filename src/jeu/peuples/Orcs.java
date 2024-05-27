package jeu.peuples;

import jeu.Case;

/**Classe d'implémantation du peuples des Orcs. */
public class Orcs extends Peuple {

    /** Le nom des Orcs. */
    private static final String NOM = "Orcs";

    /** La Description des Orcs et de leur capacité. */
    private static final String DESCRIPTION = "Toute région non-vide conquise par vos "
                + "Orcs "
                + "durant ce tour rapporte 1 jeton de victoire "
                + "supplémentaire en fin de tour.";

    /** Le nombre d'Orcs sans le nombre associé au pouvoir. */
    private static final int PIONSSUP = 5;

    /** Le nombre de régions non-vides conquises par les Orcs dans ce tour. */
    private int nbRegionsConquises = 0;

    /** Indicateur du caractère vide d'une région pendant sa conquête. */
    private boolean estNonVide;

    // Constructeur

    /** Construire les Orcs. */
    public Orcs() {
        super(TypesPeuples.ORCS, NOM, DESCRIPTION, PIONSSUP);
    }

    @Override
    public void debutTour() {
    	this.nbRegionsConquises = 0;
    }

    @Override
    public void avantConquete(Case regionAConquerir) {
        if (regionAConquerir == null) {
            throw new IllegalArgumentException("regionAConquerir ne doit pas être null.");
        }
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
