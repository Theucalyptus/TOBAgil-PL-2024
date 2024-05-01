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

    public Monde (int nbJoueurs) {
        this.grille = new ArrayList<>();

        int nb_max_region, nb_max_symboles;
        int nb_types_regions = TypesRegions.values().length - 1;
        switch (nbJoueurs) {   //on choisit les dimensions du monde et le nombre maximal par region selon le nombre de joueurs
            case 2:
                this.dimX = this.dimY = 5;
                nb_max_region = Math.round(((float)(dimX*dimY))/nb_types_regions);
                nb_max_symboles = 4;
                break;
            case 3:
                this.dimX = this.dimY = 6;
                nb_max_region = Math.round((float)(dimX*dimY)/nb_types_regions);
                nb_max_symboles = 5;
                break;
            case 4:
                this.dimX = this.dimY = 7;
                nb_max_region = Math.round((float)(dimX*dimY)/nb_types_regions);
                nb_max_symboles = 7;
                break;
            case 5:
                this.dimX = this.dimY = 8;
                nb_max_region = Math.round((float)(dimX*dimY)/(nb_types_regions));
                nb_max_symboles = 9;
                break;
            default:
                dimX = dimY = 6;
                nb_max_region = Math.round((float)(dimX*dimY)/nb_types_regions);
                nb_max_symboles = 5;
        }

        //on associe a chaque type de region, le nombre de cases de ce type qui sont déjà sur la grille
        HashMap<TypesRegions, Integer> nombreRegions = new HashMap<TypesRegions, Integer>();
        nombreRegions.put(TypesRegions.CHAMP, 0);
        nombreRegions.put(TypesRegions.FORET, 0);
        nombreRegions.put(TypesRegions.COLLINE, 0);
        nombreRegions.put(TypesRegions.MARAIS, 0);
        nombreRegions.put(TypesRegions.MONTAGNE, 0);
        //nombreRegions.put(TypesRegions.MER_ET_LAC, 0);

        //on associe a chaque type de symbole, le nombre de cases de ce type qui sont déjà sur la grille

        HashMap<TypesSymboles, Integer> nombreSymboles = new HashMap<TypesSymboles, Integer>();
        nombreSymboles.put(TypesSymboles.CAVERNES, 0);
        nombreSymboles.put(TypesSymboles.MINE, 0);
        nombreSymboles.put(TypesSymboles.SOURCE_MAGIQUE, 0);
        //nombreSymboles.put(TypesSymboles.AUCUN, 0);

        //on parcourt la grille pour associer a chaque case ses coordonnees, sa region et sa ressource
        for (int x = 0; x < this.getDimX(); x++) {
            for (int y = 0; y < this.getDimY(); y++) {
                TypesSymboles newsymbole;
                TypesRegions newregion;

                //on verifie si on veut une mer ou un lac
                boolean coins, centre;

                coins = ((x==0 && y==0) || (x==(dimX-1)) && y==(dimY-1));
                centre = (((x == (dimX/2)) && (y == (dimY/2))) || ((x == (dimX/2 + 1)) && (y == (dimY/2)))|| ((x == (dimX/2)) && (y == (dimY/2)))|| ((x == (dimX/2 + 1)) && (y == (dimY/2 + 1)))); //on verifie si on est sur les cases du centre

                if (coins || centre) { //on traite les cas où on veut la mer ou un lac
                    newregion = TypesRegions.MER_ET_LAC;
                    newsymbole = TypesSymboles.AUCUN;
                } else {
                    //choix d'une region aleatoire de la liste des regions possibles
                    Set<TypesRegions> regionsSet = nombreRegions.keySet();  //on recupere les cles du dictionnaire
                    TypesRegions[] regionsArray = regionsSet.toArray(new TypesRegions[0]);    //on transforme le set en array
                    Random random = new Random();
                    int randomIndexRegion = random.nextInt(nombreRegions.size());
                    newregion = regionsArray[randomIndexRegion];   //on accede à une cle (type de region ici) random
                    if (nombreRegions.get(newregion) >= nb_max_region) { //si on atteint le max de case pour cette region, on la retire des regions possible
                        nombreRegions.remove(newregion);
                    } else {
                        nombreRegions.put(newregion, nombreRegions.get(newregion) + 1);
                    }

                    //choix d'un symbole aleatoire
                    int nb_total_symboles = 3*nb_max_symboles;
                    double p = nb_total_symboles/(this.getDimX() * this.getDimY()); //probabilite de mettre un symbole sur la case
                    Set<TypesSymboles> symbolesSet = nombreSymboles.keySet();
                    TypesSymboles[] symbolesArray = symbolesSet.toArray(new TypesSymboles[0]);
                    random = new Random();
                    if (random.nextDouble() < p) { //on ajoute un symbole à la case avec une probabilité p
                        int randomIndexSymbole = random.nextInt(nombreSymboles.size());
                        newsymbole = symbolesArray[randomIndexSymbole];

                        if (nombreSymboles.get(newsymbole) >= nb_max_symboles) { //si on atteint le max de case pour ce symbole, on le retire des symboles possible
                            nombreSymboles.remove(newsymbole);
                        } else {
                            nombreSymboles.put(newsymbole, nombreSymboles.get(newsymbole) + 1);
                        }
                    }  else {
                        newsymbole = TypesSymboles.AUCUN;
                    }

                }

                Peuple monPeuple = new TribuOubliee();  //on pose une tribu oubliée sur la case
                EnsemblePions newEnsemblePions = new EnsemblePions(monPeuple, 1);
                Case newcase = new Case(x, y, newregion, newEnsemblePions, newsymbole);    //creation de la nouvelle case
                this.grille.add(newcase);  //ajout de la nouvelle case à la grille
            }
        }
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
