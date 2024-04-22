package jeu;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

import jeu.batiments.Batiment;
import jeu.batiments.TypesBatiments;

/**Case du jeu. Une case possède :
 * type de région
 * batiment
 * ensemble de pions
 * ressource (mine,...)
 * status (prenable ou non)
 * 
 * Par défaut, une case est :
 *      - un Champ
 *      - sans Batiment
 *      - sans unité
 *      - sans ressource
 *      - etat prenable
 */
public class Case {

    // Attributs
    /**Liste des voisins */
    private List<Case> voisins;

    /**Coordonnes de la case */
    private List<Integer> coordonnees;

    /** Le type de région de la Case. */
    private TypesRegion typeRegion;

    /** Le batiment s'il éxiste. */
    private Map<TypesBatiments,Integer> batiments; //dictionnaire qui associe un type de batiment au nombre de batiment associée à ce type

    /** L'ensemble des unités posées sur une case. */
    private EnsemblePions pions;

    /**Ressource de la case */
    private TypesSymboles ressource;
    
    /** Status de la case (prenable ou non). */
    private Boolean prenable;


    // Constructeurs

    /**Constructeur de la Classe Case avec tous les attributs par défaut.
    */
    public Case() {
        this.voisins = new ArrayList<>();
        this.coordonnees = new ArrayList<>();
        (this.coordonnees).add(0);
        (this.coordonnees).add(0);
        this.region = TypesRegions.CHAMP;
        this.batiment = new HashMap<>();
        this.pions = 0;
        this.ressource = TypesSymboles.AUCUN;
        this.prenable = true;
    }
    
    /**
     * Construire une Case à partir d'un type de région, d'un batiment, d'un ensemble de pions, d'une ressource, d'un status.
     * Pas de parametre batiment car à l'initialisation d'une case il n'y a jamais de batiment
     * @param i Coordonnee i de la Case
     * @param j Coordonnee j de la Case
     * @param region Le type de région de la Case.
     * @param pions La liste d'unité à l'initialisation. //tribus oubliées
     * @param ressource type de ressource sur la Case.
     * @param status Le status de la case à la creation.
     */
    public Case(int i, int j, TypesRegions region, EnsemblePions pions,TypesSymboles ressource) {
        this.voisins = new ArrayList<>();
        this.coordonnees = new ArrayList<>();
        (this.coordonnees).add(i);
        (this.coordonnees).add(j);
        this.region = region;
        this.batiment = new HashMap<>();
        this.pions = pions;
        this.ressource = ressource;
        if (region == TypesRegions.MER_ET_LAC) {
            this.prenable = false;
        } else {
            this.prenable = true;
        }
    }

    // getteurs

    /**
     * Donner le nombre d'unités placées sur la Case.
     * @return Le nombre d'unité placées sur la Case.
     */
    public int getNombrepions() {
        return this.pions.getNombre();
    }

    /**
     * Donner le type des batiments qui se trouvent sur la case et le nombre associé.
     * @return Le type de batiment qui est sur la case.
     */
    public Map<TypesBatiments,Integer> getBatiment() {
        return this.batiments;
    }

    /**
     * Donner le type de la region de la case.
     * @return Le type de region de la case.
     */
    public TypesRegions getTypeRegion() {
        return this.region;
    }

    /**
     * Donner le type de ressource de la case.
     * @return Le type de ressource de la case.
     */
    public TypesSymboles getTypeRessource() {
        return this.ressource;
    }

    /**
     * Indique si la case est prenable
     * @return Status de la case
     */
    public Boolean getPrenable() {
        return this.prenable;
    }

    /**Pour s'emparer d'une région, un joueur doit déployer 2 pions de Peuple + 1 pion de Peuple supplémentaire par Campement,
    Forteresse, Montagne ou Antre de Troll + 1 pion de Peuple supplémentaire par Tribu oubliée ou par pion de Peuple ennemi
    présent dans cette région. Les mers et le lac ne peuvent pas être
    conquis.
    /**Donner le nombre d'unités nécessaire pour attaquer la Case, sans pouvoir spécifique du peuple attaquant et du peuple defenseur.
     * @return Le nombre d'unités nécessaires pour attaquer la Case.
    */
    public int getNombreAttaquantNecessaire() {
        int nb_attaquants = 2 + getNombrepions() + (this.typeRegion == TypesRegions.MONTAGNE ? 1 : 0);
        if (!this.abscenceBatiment()) {
            // Récupération des valeurs du dictionnaire
            Collection<Integer> valeurs = (this.batiments).values();
            // Calcul de la somme des valeurs en utilisant Stream API
            nb_attaquants += (valeurs.stream().mapToInt(Integer::intValue)).sum();
        }
        return nb_attaquants;
    }


    /**
     * Obtenir le peuple qui occupe la case
     * @return peuple qui occupe la Case.
     */
    public Peuple getPeuple() {
        return this.pions.getPeuple();
    }

    /**Donner les voisins de la case
     * @return liste des cases voisines
    */
    public List<Case> getVoisins() {
        return this.voisins;
    }


    // Set

    /**
     * Modifie l'ensemble de pions placées sur la Case.
     * @param new_pions ensemble de pions placées sur la Case.
     */
    public setNewpions(EnsemblePions new_pions) {
        this.pions = new_pions;
    }

    //1 forteresse par region max
    //plusieur campement par region possible
    // 1 antre de troll possible
    //1 taniere par region

    /**
     * Modifie le batiment placé sur la Case.
     * 2 types de batiments max possible par case
     * @param new_batiment nouveau batiment à placé sur la Case.
     */
    public setTypeBatiment(TypesBatiments new_batiment,Integer nb_batiments_sup ) {
        //On regarde si le type de batiment est déjà présent sur la case
        if ((this.batiments).containsKey(new_batiment)) {
            int ancienne_val = (this.batiments).get(new_batiment);
            (this.batiments).put(new_batiment, ancienne_val + nb_batiments_sup);
        } else {
            (this.batiments).put(new_batiment, nb_batiments_sup);
        }
        //Si une tanière est posé sur la Case elle devient imprenable
        if (new_batiment == TypesBatiments.TANIERE) {
            this.prenable = false;
        }
    }

    //Pas de setRegion car on ne peut modifier une region

    //Pas de setRessource car on ne peut modifier le type de ressource sur une case

    /**
     * Modifie le status de la Case.
     * @param new_prenable nouveau status de la Case.
     */
    public setPrenable(Boolean new_prenable) {
        this.prenable = new_prenable;
    }

    // commandes

    /**
     * Donne si la case possède des batiment.s ou non.
     * @return Vrai si la case ne possède pas de batiment.s.
     */
    public boolean abscenceBatiment() {
        return (this.batiments).isEmpty();
    }

    /**
     * Retirer un batiment placé sur la Case.
     * @param batiment batiment à retiré de la Case.
     */
    public removeBatiment(TypesBatiments batiment) {
        (this.batiments).remove(batiment);
    }

    /**Ajoute un voisin de la Case dans sa liste voisins
     * @param case_voisine case voisine
    */
    public ajoutVoisins(Case case_voisine) {
        this.voisins.add(case_voisine);
    }

}
