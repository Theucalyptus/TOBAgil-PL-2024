package jeu;



public class SWMonde {

    private int dimX;                       // Le nombre de tuiles en largeurs
    private int dimY;                       // Le nombre de tuiles en hauteur
    private List<SWTuile> grille;            // La grille avec l'ensemble des tuiles

    public SWMonde () {
        this.dimX = 10;
        this.dimY = 10;
        this.grille = new ArrayList<> ();
    }
}