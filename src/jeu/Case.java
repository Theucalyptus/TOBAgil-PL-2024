package jeu;

import java.util.Map;
import java.util.Observable;
// import java.util.Set;

import jeu.batiments.TypesBatiments;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

//import jeu.batiments.Batiment;
//import jeu.batiments.TypesBatiments;
//import jeu.TypesRegions;
//import jeu.peuples.Peuple;

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
@SuppressWarnings("deprecation")
public class Case extends Observable {

    // Attributs
    /**Liste des voisins. */
    private List<Case> voisins;

    /**Coordonnes de la case. */
    private List<Integer> coordonnees;

    /** Le type de région de la Case. */
    private TypesRegions typeRegion;

    /** Le batiment s'il éxiste. */
    // dictionnaire qui associe un type de batiment au nombre de batiment associée à ce
    // type
    private Map<TypesBatiments, Integer> batiments;

    /** L'ensemble des unités posées sur une case. */
    private GroupePions pions;

    /**Ressource de la case. */
    private TypesSymboles ressource;

    /** Status de la case (prenable ou non). */
    private Boolean prenable;

    /** Définie si une Case est sur la bordure du terrain ou non. */
    private boolean estBordure;

    // Constructeurs

    /**
     * Construire une Case à partir d'un type de région, d'un batiment, d'un ensemble de
     * pions, d'une ressource, d'un status. Pas de parametre batiment car à
     * l'initialisation d'une case il n'y a jamais de batiment.
     * @param i Coordonnee i de la Case
     * @param j Coordonnee j de la Case
     * @param region Le type de région de la Case.
     * @param pions La liste d'unité à l'initialisation. //tribus oubliées
     * @param ressource type de ressource sur la Case.
     */
    public Case(int i, int j, TypesRegions region,
                GroupePions pions, TypesSymboles ressource, Boolean bordure) {
        this.voisins = new ArrayList<>();
        this.coordonnees = new ArrayList<>();
        this.coordonnees.add(i);
        this.coordonnees.add(j);
        this.typeRegion = region;
        this.batiments = new HashMap<TypesBatiments, Integer>();
        this.pions = pions;
        this.ressource = ressource;
        if (region == TypesRegions.MER_ET_LAC) {
            this.prenable = false;
        } else {
            this.prenable = true;
        }
        this.estBordure = bordure;
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
    public Map<TypesBatiments, Integer> getBatiment() {
        return this.batiments;
    }

    /**
     * Donner le type de la region de la case.
     * @return Le type de region de la case.
     */
    public TypesRegions getTypeRegion() {
        return this.typeRegion;
    }

    /**
     * Donner le type de ressource de la case.
     * @return Le type de ressource de la case.
     */
    public TypesSymboles getTypeRessource() {
        return this.ressource;
    }

    /**
     * Donner les coordonnées de la case.
     * @return coordonnées de la case.
     */
    public List<Integer> getCoordonnees() {
        return this.coordonnees;
    }

    /**
     * Indique si la case est prenable.
     * @return Status de la case.
     */
    public Boolean getPrenable() {
        return this.prenable;
    }

    /* Pour s'emparer d'une région, un joueur doit déployer 2 pions de Peuple + 1 pion de
     * Peuple supplémentaire par Campement, Forteresse, Montagne ou Antre de Troll + 1
     * pion de Peuple supplémentaire par Tribu oubliée ou par pion de Peuple ennemi
     * présent dans cette région. Les mers et le lac ne peuvent pas être conquis.
     */
    /**Donner le nombre d'unités nécessaire pour attaquer la Case, sans pouvoir
     * spécifique du peuple attaquant et du peuple defenseur.
     * @return Le nombre d'unités nécessaires pour attaquer la Case.
    */
    public int getNombreAttaquantNecessaire() {
        int nombreAttaquants = 2 + getNombrepions()
                + (this.typeRegion == TypesRegions.MONTAGNE ? 1 : 0);

        if (!this.abscenceBatiment()) {
            // Récupération des valeurs du dictionnaire
            Collection<Integer> valeurs = (this.batiments).values();
            // Calcul de la somme des valeurs
            for (int valeur : valeurs) {
                nombreAttaquants += valeur;
            }
        }
        return nombreAttaquants;
    }

    /**
     * Obtenir le peuple qui occupe la case.
     * @return peuple qui occupe la Case.
     */
    public GroupePions getGroupePions() {
        return this.pions;
    }

    /**Donner les voisins de la case.
     * @return La liste des cases voisines.
    */
    public List<Case> getVoisins() {
        return this.voisins;
    }


    // Set

    /**
     * Modifie l'ensemble de pions placées sur la Case.
     * @param newPions ensemble de pions placées sur la Case.
     */
    public void setNewpions(GroupePions newPions) {
        this.pions = newPions;
        newPions.getCombinaison().addGroupe(newPions);
        newPions.setCase(this);
        this.notification();
    }    
    
    public void setNewNombrePions(int newNombre) {
        this.pions.setNombre(newNombre);
        this.notification();
    }

    //1 forteresse par region max
    //plusieur campement par region possible
    // 1 antre de troll possible
    //1 taniere par region

    /**
     * Modifie le batiment placé sur la Case.
     * 2 types de batiments max possible par case
     * @param newBatiment nouveau batiment à placé sur la Case.
     * @param nombreBatimentSup Le nombre de batiment supplémentaire.
     */
    public void setTypeBatiment(TypesBatiments newBatiment, Integer nombreBatimentSup) {
        //On regarde si le type de batiment est déjà présent sur la case
        if ((this.batiments).containsKey(newBatiment)) {
            int ancienneVal = (this.batiments).get(newBatiment);
            (this.batiments).put(newBatiment, ancienneVal + nombreBatimentSup);
        } else {
            (this.batiments).put(newBatiment, nombreBatimentSup);
        }
        //Si une tanière est posé sur la Case elle devient imprenable
        if (newBatiment == TypesBatiments.TANIERE) {
            this.prenable = false;
        }

        this.notification();
    }

    //Pas de setRegion car on ne peut modifier une region

    //Pas de setRessource car on ne peut modifier le type de ressource sur une case

    /**
     * Modifie le status de la Case.
     * @param newPrenable nouveau status de la Case.
     */
    public void setPrenable(Boolean newPrenable) {
        this.prenable = newPrenable;
    }

    // commandes

    /**
     * Donne si la case possède des batiment.s ou non.
     * @return Vrai si la case ne possède pas de batiment.s.
     */
    public boolean abscenceBatiment() {
        return this.batiments.isEmpty();
    }

    /**
     * Retirer un batiment placé sur la Case.
     * @param batiment batiment à retiré de la Case.
     */
    public void removeBatiment(TypesBatiments batiment) {
        this.batiments.remove(batiment);
        this.notification();
    }

    /**Ajoute un voisin de la Case dans sa liste voisins.
     * @param caseVoisine case voisine
    */
    public void ajoutVoisins(Case caseVoisine) {
        this.voisins.add(caseVoisine);
    }

    /**
     * Obtenir si le Joueur peut atteindre la case.
     * @param joueur le joueur dont on veut savoir s'il peut atteindre la case.
     * @return Si le Joueur peut l'atteindre.
     */
    public boolean estAtteignable(Joueur joueur) {

        if (this.estBordure && (joueur.getCombinaisonActive().getPions().size() == 0)) {
            return true;
        }

        //checker si la case est atteignable par un joueur déjà déployé ?
        for (Case voisine : this.getVoisins()) {
            System.out.println("Case voisine : " + voisine.getCoordonnees().toString());
            if (voisine.getGroupePions().getCombinaison()
                    == joueur.getCombinaisonActive()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Notifie les observateurs que l'objet à changé.
     */
    private void notification() {
        this.setChanged();
        this.notifyObservers();
        this.clearChanged();
    }

}
