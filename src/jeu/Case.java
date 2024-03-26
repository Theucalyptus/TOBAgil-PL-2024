package jeu;

import jeu.batiments.Batiment;

/**Case du jeu. Une case possède une liste d'unité d'un peuple,
 * un état, un type de région et peut posséder un batiment.
 * Elle possède un nombre d'unité nécessaire pour l'attaquer.
 * Par défaut, une case est :
 *      - un Champ
 *      - sans unité
 *      - sans Batiment
 *      - etat Normal
 */
public class Case {

    // Attributs
    /** L'ensemble des unités posées sur une cases. */
    private EnsemblePions pions;
    
    /** Le batiment s'il éxiste. */
    private Batiment batiment;

    /** Le type de régions de la Case. */
    private TypesRegions typeRegion;

    // Constructeurs

    /**Constructeur de la Classe Case avec tous les attributs par défaut.
    */
    public Case() {
        this(null,
            null, 
            TypesRegions.CHAMP);
    }
    
    /**
     * Construire une Case à partir d'une unité, d'un état et d'une région.
     * @param pion Le pion sur la Case.
     * @param region La région de la case.
     */
    public Case(EnsemblePions pion, TypesRegions region) {
        this(pion, null, region);
    }
    

    /**
     * Constructeur d'une Case avec une Liste d'unité, un etat de base,
     * un batiment et un type de region.
     * @param pions La liste d'unité à l'initialisation.
     * @param etat L'état de la case à la création.
     * @param batiment Le batiment construit sur la case s'il éxiste.
     * @param typeTegion Le type de region de la Case
     */
    public Case(EnsemblePions pions, 
                   Batiment batiment, 
                   TypesRegions region) {
        this.pions = pions;
        this.batiment = batiment;
        this.typeRegion = region;
    }

    // getteurs

    /**
     * Donner le nombre d'unités placées sur la Case.
     * @return Le nombre d'unité placées sur la Case.
     */
    public int getNombrepions() {
        return this.pions.getNombre();
    }

    /**Donner le nombre d'unités nécessaire pour attaquer la Case.
     * @return Le nombre d'unités nécessaire pour attaquer la Case.
    */
    public int getNombreAttaquantNecessaire() {
        return 2 + getNombrepions() + (aUnBatiment() ? 1 : 0)
            + (this.typeRegion == TypesRegions.MONTAGNE ? 1 : 0);
    }

    /**
     * Donner le batiment qui se trouve sur la case.
     * Renvoie null s'il s'y a pas de batiment sur la case.
     * @return Le batiment qui est sur la case.
     */
    public Batiment getBatiment() {
        return this.batiment;
    }

    /**
     * Donner le type de la region de la case.
     * @return Le type de region de la case.
     */
    public TypesRegions getTypeRegion() {
        return this.typeRegion;
    }

    /**
     * Donner si la case possède un batiment.
     * @return Si la case possède un batiment.
     */
    public boolean aUnBatiment() {
        return this.batiment == null;
    }

    // commandes


}
