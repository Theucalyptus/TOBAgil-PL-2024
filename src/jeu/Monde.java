package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.management.RuntimeErrorException;

import java.util.HashMap;

import java.util.Random;

public class Monde {

    /** Le nombre de tuiles en largeurs. */
    private int dimX;
    /** Le nombre de tuiles en hauteur. */
    private int dimY;
    /** La grille avec l'ensemble des tuiles. */
    private List<Case> grille;
    /** La probabilité de faire apparaître une tribu oubliées sur une case. */
    private final double probaTribuOubliee = 0.25;

    /**
     * Construire un Monde.
     * @param nbJoueurs Le nombre de joueur dans la partie.
     */
    public Monde(int nbJoueurs) {
        this.grille = new ArrayList<>();

        int nombreMaxRegion;
        int nombreMaxSymbols;
        int nombreTypesRegion = TypesRegions.values().length - 1;
        // on choisit les dimensions du monde et le nombre maximal par region selon
        // le nombre de joueurs
        switch (nbJoueurs) {
            case 2:
                this.dimX = 5;
                this.dimY = 5;
                nombreMaxRegion =
                    Math.round(((float) (this.dimX * this.dimY)) / nombreTypesRegion);
                nombreMaxSymbols = 4;
                break;
            case 3:
                this.dimX = 6;
                this.dimY = 6;
                nombreMaxRegion =
                    Math.round((float) (this.dimX * this.dimY) / nombreTypesRegion);
                nombreMaxSymbols = 5;
                break;
            case 4:
                this.dimX = 7;
                this.dimY = 7;
                nombreMaxRegion =
                    Math.round((float) (this.dimX * this.dimY) / nombreTypesRegion);
                nombreMaxSymbols = 7;
                break;
            case 5:
                this.dimX = 8;
                this.dimY = 8;
                nombreMaxRegion =
                    Math.round((float) (this.dimX * this.dimY) / (nombreTypesRegion));
                nombreMaxSymbols = 9;
                break;
            default:
                throw new IllegalArgumentException("nbJoueurs doit être entre 2 et 5.");
        }

        // on associe a chaque type de region, le nombre de cases de ce type
        // qui sont déjà sur la grille
        HashMap<TypesRegions, Integer> nombreRegions =
            new HashMap<TypesRegions, Integer>();
        nombreRegions.put(TypesRegions.CHAMP, 0);
        nombreRegions.put(TypesRegions.FORET, 0);
        nombreRegions.put(TypesRegions.COLLINE, 0);
        nombreRegions.put(TypesRegions.MARAIS, 0);
        nombreRegions.put(TypesRegions.MONTAGNE, 0);
        //nombreRegions.put(TypesRegions.MER_ET_LAC, 0);

        // on associe a chaque type de symbole, le nombre de cases de ce type qui sont
        // déjà sur la grille

        HashMap<TypesSymboles, Integer> nombreSymboles =
            new HashMap<TypesSymboles, Integer>();
        nombreSymboles.put(TypesSymboles.CAVERNES, 0);
        nombreSymboles.put(TypesSymboles.MINE, 0);
        nombreSymboles.put(TypesSymboles.SOURCE_MAGIQUE, 0);
        //nombreSymboles.put(TypesSymboles.AUCUN, 0);

        // on parcourt la grille pour associer a chaque case ses coordonnees,
        // sa region et sa ressource
        for (int x = 0; x < this.getDimX(); x++) {
            for (int y = 0; y < this.getDimY(); y++) {
                TypesSymboles newsymbole;
                TypesRegions newregion;

                //on verifie si on veut une mer ou un lac
                boolean coins = ((x == 0 && y == 0)
                || (x == (this.dimX - 1)) && y == (this.dimY - 1));
                //on verifie si on est sur les cases du centre
                boolean centre = (((x == (this.dimX / 2 - 1))
                        && (y == (this.dimY / 2 - 1)))
                    || ((x == (this.dimX / 2)) && (y == (this.dimY / 2 - 1)))
                    || ((x == (this.dimX / 2)) && (y == (this.dimY / 2)))
                    || ((x == (this.dimX / 2 - 1)) && (y == (this.dimY / 2))));
                boolean bordure = x == 0 || x == this.dimX - 1
                    || y == 0 || y == this.dimY - 1;

                // nombre de pions a placer sur la nouvelle case

                int nbPions;
                if (Math.random() < probaTribuOubliee) {
                    nbPions = 1;
                } else {
                    nbPions = 0;
                }


                if (coins || centre) { //on traite les cas où on veut la mer ou un lac
                    newregion = TypesRegions.MER_ET_LAC;
                    newsymbole = TypesSymboles.AUCUN;
                    nbPions = 0;
                } else {
                    // choix d'une region aleatoire de la liste des regions possibles
                    // on recupere les cles du dictionnaire
                    Set<TypesRegions> regionsSet = nombreRegions.keySet();
                    // on transforme le set en array
                    TypesRegions[] regionsArray =
                        regionsSet.toArray(new TypesRegions[0]);
                    Random random = new Random();
                    int randomIndexRegion = random.nextInt(nombreRegions.size());
                    // on accede à une cle (type de region ici) random
                    newregion = regionsArray[randomIndexRegion];
                    // si on atteint le max de case pour cette region, on la retire des
                    // regions possible
                    if (nombreRegions.get(newregion) >= nombreMaxRegion) {
                        nombreRegions.remove(newregion);
                    } else {
                        nombreRegions.put(newregion, nombreRegions.get(newregion) + 1);
                    }

                    // choix d'un symbole aleatoire
                    int nombreTotalSymboles = 3 * nombreMaxSymbols;
                    // probabilite de mettre un symbole sur la case
                    double p = (double) nombreTotalSymboles
                        / (double) (this.getDimX() * this.getDimY());
                    Set<TypesSymboles> symbolesSet = nombreSymboles.keySet();
                    TypesSymboles[] symbolesArray =
                        symbolesSet.toArray(new TypesSymboles[0]);
                    random = new Random();
                    // on ajoute un symbole à la case avec une probabilité p
                    if (random.nextDouble() < p) {
                        int randomIndexSymbole = random.nextInt(nombreSymboles.size());
                        newsymbole = symbolesArray[randomIndexSymbole];

                        // si on atteint le max de case pour ce symbole, on le retire
                        // des symboles possible
                        if (nombreSymboles.get(newsymbole) >= nombreMaxSymbols) {
                            nombreSymboles.remove(newsymbole);
                        } else {
                            nombreSymboles.put(newsymbole,
                                nombreSymboles.get(newsymbole) + 1);
                        }
                    }  else {
                        newsymbole = TypesSymboles.AUCUN;
                    }
                }

                // on pose une tribu oubliée sur la case
                Combinaison tribuOublieeComb = new Combinaison(
                    new jeu.peuples.TribuOubliee(), new jeu.pouvoirs.TribuOubliee());

                GroupePions newEnsemblePions = new GroupePions(tribuOublieeComb, nbPions);
                // création de la nouvelle case
                Case newcase = new Case(x, y, newregion, newEnsemblePions,
                    newsymbole, bordure);
                // ajout de la nouvelle case à la grille
                this.grille.add(newcase);
            }
        }

        // ajout des cases voisines
        int x;
        int y;
        int[] xOffsets = {1, -1, 0, 0};
        int[] yOffsets = {0, 0, -1, 1};
        for (Case maCase : this.grille) {
            x = maCase.getCoordonnees().get(0);
            y = maCase.getCoordonnees().get(1);


            for (int i = 0; i < 4; i++) {
                int xVois = x + xOffsets[i];
                int yVois = y + yOffsets[i];
                boolean coordValide = xVois >= 0 && xVois < this.dimX
                    && yVois >= 0 && yVois < this.dimY;
                if (coordValide) {
                    maCase.ajoutVoisins(this.getCase(xVois, yVois));
                }
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
        if (x < 0) {
            throw new IllegalArgumentException("x doit être positif.");
        } else if (x >= this.dimX) {
            throw new IllegalArgumentException("x doit être inférieur à la dimension "
            + "du plateau.");
        } else if (y < 0) {
            throw new IllegalArgumentException("y doit être positif.");
        } else if (y > this.dimY) {
            throw new IllegalArgumentException("y doit être inférieur à la dimension "
                + "du plateau");
        }
        for (Case maCase : this.grille) {
            List<Integer> coordonnees = maCase.getCoordonnees();
            if ((coordonnees.get(0) == x) && (coordonnees.get(1) == y)) {
                return maCase;
            }
        }
        // Si tout est bien développé, ne devrait jamais arriver !
        throw new RuntimeErrorException(null);
    }
}
