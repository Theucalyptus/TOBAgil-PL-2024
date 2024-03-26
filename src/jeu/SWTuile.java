package jeu;

import java.util.ArrayList;
import java.util.List;

import jeu.SWBatiment.SWBatiment;

/**Tuile du jeu. Une tuile possède une liste d'unité d'un peuple,
 * un état, un type de région et peut posséder un batiment.
 * Elle possède un nombre d'unité nécessaire pour l'attaquer.
 * Par défaut, une tuile est :
 *      - un Champ
 *      - sans unité
 *      - sans Batiment
 *      - etat Normal
 */
public class SWTuile {

    // Attributs
    /** L'ensemble des unités posées sur une cases. */
    private List<SWUnite> unites;
    
    /** L'état de la tuile, type énumérée. */
    private TypeEtatTuile etat;
    
    /** Le batiment s'il éxiste. */
    private SWBatiment batiment;

    /** Le type de régions de la Tuile. */
    private TypesRegions typeRegion;

    // Constructeurs

    /**Constructeur de la Classe Tuile avec tous les attributs par défaut.
    */
    public SWTuile() {
        this(new ArrayList<> (),
            TypeEtatTuile.NORMAL,
            null, 
            TypesRegions.CHAMP);
    }
    
    /**
     * Construire une Tuile à partir d'une unité, d'un état et d'une région.
     * @param unite L'unité sur la Tuile.
     * @param etat L'état de la tuile.
     * @param region La région de la tuile.
     */
    public SWTuile(SWUnite unite, TypeEtatTuile etat,
                    TypesRegions region) {
        this(new ArrayList<SWUnite>(), etat, null, region);
        this.unites.add(unite);
    }
    
    /**
     * Construire une Tuile à partir de sa list d'unitée disposé, de son état
     * et de son type de région.
     * @param unite L'ensemble d'unité disposé sur la Tuile.
     * @param etat L'état de la Tuile.
     * @param typeRegion Le type de région de la Tuile.
     */
    public SWTuile(List<SWUnite> unites, TypeEtatTuile etat,
            TypesRegions typeRegion) {
        this(unites, etat, null, typeRegion);
    }

    /**
     * Constructeur d'une Tuile avec une Liste d'unité, un etat de base,
     * un batiment et un type de region.
     * @param unites La liste d'unité à l'initialisation.
     * @param etat L'état de la case à la création.
     * @param batiment Le batiment construit sur la case s'il éxiste.
     * @param typeTegion Le type de region de la Tuile
     */
    public SWTuile(List<SWUnite> unites, TypeEtatTuile etat, 
                    SWBatiment batiment, TypesRegions region) {
        this.unites = unites;
        this.etat = etat;
        this.batiment = batiment;
        this.typeRegion = region;
    }

    // getteurs

    /**
     * Donner le nombre d'unités placées sur la Tuile.
     * @return Le nombre d'unité placées sur la Tuile.
     */
    public int getNombreUnites() {
        return this.unites.size();
    }

    /**Donner le nombre d'unités nécessaire pour attaquer la Tuile.
     * @return Le nombre d'unités nécessaire pour attaquer la Tuile.
    */
    public int getNombreAttaquantNecessaire() {
        return 2 + getNombreUnites() + (aUnBatiment() ? 1 : 0)
            + (this.typeRegion == TypesRegions.MONTAGNE ? 1 : 0);
    }

    /**
     * Donner l'état de la tuile.
     * @return L'état de la tuile.
     */
    public TypeEtatTuile getEtatTuile() {
        return this.etat;
    }

    /**
     * Donner le batiment qui se trouve sur la tuile.
     * Renvoie null s'il s'y a pas de batiment sur la tuile.
     * @return Le batiment qui est sur la tuile.
     */
    public SWBatiment getBatiment() {
        return this.batiment;
    }

    /**
     * Donner le type de la region de la tuile.
     * @return Le type de region de la tuile.
     */
    public TypesRegions getTypeRegion() {
        return this.typeRegion;
    }

    /**
     * Donner si la tuile possède un batiment.
     * @return Si la tuile possède un batiment.
     */
    public boolean aUnBatiment() {
        return this.batiment == null;
    }

    // commandes

    /**
     * Immuniser une case contre toute attaque extérieure.
     */
    public void immuniser() {
        this.etat = TypeEtatTuile.IMPRENABLE;
    }



}
