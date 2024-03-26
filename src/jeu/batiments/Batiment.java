package jeu.batiments;

public interface Batiment {
    /**
     * Renvoie l'action que génére le batiment sur le revenue de la Tuile.
     * @return Le nombre de pièce a ajouter afin de réaliser 
     * l'action du batiment sur le revenue de la tuile.
     */
    int actionSurRevenu();
}
