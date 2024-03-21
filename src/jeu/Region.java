package jeu;

/**
 * Classe abstraite représentant une région.
 * Abstraite car non instantiable
 * mais mutualisation de code pour les différentes sous-classes
 */
abstract class Region {

    private final TypesRegions type; // sera défini par le constructeur appelé par une sous-classe

    public Region(TypesRegions type) {
        this.type = type;
    }

    public TypesRegions getTypeRegion() {
        return this.type;
    }
}