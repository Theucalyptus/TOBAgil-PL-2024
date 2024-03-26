package jeu;

import java.util.ArrayList;
import java.util.List;

public class Monde {

    private int dimX;                       // Le nombre de tuiles en largeurs
    private int dimY;                       // Le nombre de tuiles en hauteur
    private List<Case> grille;            // La grille avec l'ensemble des tuiles

    public Monde () {
        this.dimX = 4;
        this.dimY = 4;
        this.grille = new ArrayList<>();
    }
}