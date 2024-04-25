package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.util.Map;
import java.util.HashMap;

import java.util.Random;
import jeu.peuples.Peuple;
import jeu.peuples.TribuOubliee;

public class Monde {

    private int dimX;                       // Le nombre de tuiles en largeurs
    private int dimY;                       // Le nombre de tuiles en hauteur
    private List<Case> grille;            // La grille avec l'ensemble des tuiles

    public Monde (int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.grille = new ArrayList<>();
    }

    /** Creer un nouveau monde.
     * @param nb_joueurs le nombre de joueurs dans le jeu 
     * @return le monde créé
     */
    public Monde CreerMonde(int nb_joueurs) {
        int dimX, dimY, nb_max_region, nb_max_symboles;
        switch (nb_joueurs) {   //on choisit les dimensions du monde et le nombre maximal par region selon le nombre de joueurs
            case 2: 
                dimX = dimY = 5;
                nb_max_region = 4;
                nb_max_symboles = 4;
                break;
            case 3:
                dimX = dimY = 6;
                nb_max_region = 5;
                nb_max_symboles = 5;
                break;
            case 4:
                dimX = dimY = 7;
                nb_max_region = 8;
                nb_max_symboles = 7;
                break;
            case 5: 
                dimX = dimY = 8;
                nb_max_region = 10;
                nb_max_symboles = 9;
                break;
            default:
                dimX = dimY = 6;
                nb_max_region = 5;
                nb_max_symboles = 5;
        } 

        Monde newMonde = new Monde(dimX, dimY); //creation du monde vide
        //on associe a chaque type de region, le nombre de cases de ce type qui sont déjà sur la grille
        HashMap<TypesRegions, Integer> nombreRegions = new HashMap<TypesRegions, Integer>();
        nombreRegions.put(TypesRegions.CHAMP, 0);
        nombreRegions.put(TypesRegions.FORET, 0);
        nombreRegions.put(TypesRegions.COLLINE, 0);
        nombreRegions.put(TypesRegions.MARAIS, 0);
        nombreRegions.put(TypesRegions.MONTAGNE, 0);
        nombreRegions.put(TypesRegions.MER_ET_LAC, 0);

        //on associe a chaque type de symbole, le nombre de cases de ce type qui sont déjà sur la grille

        HashMap<TypesSymboles, Integer> nombreSymboles = new HashMap<TypesSymboles, Integer>();
        nombreSymboles.put(TypesSymboles.CAVERNES, 0);
        nombreSymboles.put(TypesSymboles.MINE, 0);
        nombreSymboles.put(TypesSymboles.SOURCE_MAGIQUE, 0);

        //on parcourt la grille pour associer a chaque case ses coordonnees, sa region et sa ressource
        for (int x = 0; x < newMonde.getDimX(); x++) {
            for (int y = 0; y < newMonde.getDimY(); y++) {
                //choix d'une region aleatoire de la liste des regions possibles
                Set<TypesRegions> regionsSet = nombreRegions.keySet();
                TypesRegions[] regionsArray = regionsSet.toArray(new TypesRegions[0]);                
                Random random = new Random();
                int randomIndexRegion = random.nextInt(nombreRegions.size());
                TypesRegions newregion = regionsArray[randomIndexRegion]; 
                if (nombreRegions.get(newregion) >= nb_max_region) { //si on atteint le max de case pour cette region, on la retire des regions possible
                    nombreRegions.remove(newregion);
                } else {
                    nombreRegions.put(newregion, nombreRegions.get(newregion) + 1);
                } 

                //choix d'un symbole aleatoire
                int nb_total_symboles = 3*nb_max_symboles;
                double p = nb_total_symboles/(newMonde.getDimX() * newMonde.getDimY()); //probabilite de mettre un symbole sur la case
                Set<TypesSymboles> symbolesSet = nombreSymboles.keySet();
                TypesSymboles[] symbolesArray = symbolesSet.toArray(new TypesSymboles[0]);                
                random = new Random();
                TypesSymboles newsymbole;
                if (random.nextDouble() < p) { //on ajoute un symbole à la case avec une probabilité p
                    int randomIndexSymbole = random.nextInt(nombreSymboles.size());
                    newsymbole = symbolesArray[randomIndexSymbole]; 
                } else {
                    newsymbole = TypesSymboles.AUCUN;
                } 

                if (nombreSymboles.get(newsymbole) >= nb_max_symboles) { //si on atteint le max de case pour ce symbole, on le retire des symboles possible
                    nombreSymboles.remove(newsymbole);
                } else {
                    nombreSymboles.put(newsymbole, nombreSymboles.get(newsymbole) + 1);
                } 
                Peuple monPeuple = new TribuOubliee();  //on pose une tribu oubliée sur la case
                EnsemblePions newEnsemblePions = new EnsemblePionsImpl(monPeuple, 1);  
                Case newcase = new Case(x, y, newregion, newEnsemblePions, newsymbole);    //creation de la nouvelle case
                newMonde.grille.add(newcase);  //ajout de la nouvelle case à la grille
            } 
        } 
        return newMonde;
    } 

    /** Obtenir le nombre de tuiles en largeur.
     * @return le nombre de tuiles en largeur  
     */
    public int getDimX() {
        return this.dimX;
    } 

    /** Obtenir le nombre de tuiles en hauteur.
     * @return le nombre de tuiles en hauteur 
     */
    public int getDimY() {
        return this.dimY;
    } 

    /** Obtenir la case de coordonnees x, y.
     * @param x abscisse de la case 
     * @param y ordonnee de la case
     * @return la case correspondante  
     */
    public Case getCase(int x, int y) {
        for (Case maCase : this.grille) {
            List<Integer> coordonnees = maCase.getCoordonnees();
            if ((coordonnees.get(0) == x) && (coordonnees.get(1) == y)){
                return maCase;
            }  
        } 
        return new Case(); //on ne devrait jamais arriver à ce return 
    } 

    /** Afficher le monde dans le terminal.
     * @param monMonde le monde à afficher 
    */
    public void afficherMonde(Monde monMonde) {
        Case case_courante;
        for (int x = 0; x < monMonde.getDimX(); x++) {
            for (int y = 0; y < monMonde.getDimY(); y++) {
                case_courante = monMonde.getCase(x, y);
                System.out.println("--------");
                System.out.println(case_courante.getTypeRegion());
                System.out.println(case_courante.getTypeRessource());
                System.out.println("--------");
            }
        } 
    } 
}