package ui.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import jeu.TypesRegions;
import jeu.TypesSymboles;
import jeu.batiments.TypesBatiments;
import jeu.peuples.TypesPeuples;
import jeu.pouvoirs.TypesPouvoirs;

/** Classe qui permet de charger des images pour le jeu. */
public final class ImageFactory {

    /**Constructeur privé pour les classes utilitaires. */
    private ImageFactory() {
        // ne rien faire
    }

    /** Chemin d'accès aux répertoires des assets. */
    private static final String ROOT_ASSETS_PATH = "./assets/";

    /** Lit une image depuis son chemin d'accès.
     * @param path le chemin de l'image à charger
     * @return l'image
     */
    private static Image readImage(String path) {
        Image img = null;
        try {
            img = ImageIO.read(new File(path));

        } catch (IOException e) {
            throw new RuntimeException("IOException dans ImageFactory pour " + path);
        }
        return img;
    }

    /**
     * Renvoie l'image de fond d'une région du monde.
     * @param type le type de la région
     * @return l'image
     */
    public static Image regionImage(TypesRegions type) {
        String path = ROOT_ASSETS_PATH + "regions/" + type.name().toLowerCase() + ".png";
        return readImage(path);

    }

    /**
     * Renvoie l'image du logo d'un peuple.
     * @param type Le type du peuple.
     * @param enDeclin Si le peuple est en déclin.
     * @return l'image.
     */
    public static Image peupleLogoImage(TypesPeuples type, Boolean enDeclin) {
        String path = ROOT_ASSETS_PATH + "peuples/" + type.name().toLowerCase()
            + (enDeclin ? "_declin" : "") +  ".png";
        return readImage(path);
    }

    /**
     * Renvoie l'image des troupes d'un peuple.
     * @param type Le type du peuple.
     * @param enDeclin Si le peuple est en déclin.
     * @return l'image.
     */
    public static Image peupleTroupeImage(TypesPeuples type, Boolean enDeclin) {
        String path = ROOT_ASSETS_PATH + "troupes/" + type.name().toLowerCase()
            + (enDeclin ? "_declin" : "") + ".png";
        return readImage(path);
    }

    /**
     * Renvoie l'image d'un pouvoir.
     * @param type Le type du pouvoir.
     * @param enDeclin Si le peuple est en déclin.
     * @return L'image.
     */
    public static Image pouvoirLogoImage(TypesPouvoirs type, Boolean enDeclin) {
        String path = ROOT_ASSETS_PATH + "pouvoirs/" + type.name().toLowerCase()
            + (enDeclin ? "_declin" : "") +  ".png";
        return readImage(path);
    }

    /**
     * Renvoie l'image d'un batiment.
     * @param type le type du batiment
     * @return l'image
     */
    public static Image batimentsImage(TypesBatiments type) {
        String path = ROOT_ASSETS_PATH + "batiments/" + type.name().toLowerCase()
            + ".png";
        return readImage(path);
    }

    /**
     * Renvoie l'image d'un symbole.
     * @param type le type du symbole
     * @return l'image
     */
    public static Image symboleImage(TypesSymboles type) {
        String path = ROOT_ASSETS_PATH + "symboles/" + type.name().toLowerCase()
            + ".png";
        return readImage(path);
    }

    /**
     * Renvoie l'image d'une pièce.
     * @param nombre le nombre sur la pièce
     * @return l'image
     */
    public static Image pieceImage(int nombre) {
        String path = ROOT_ASSETS_PATH + "jetons/" + Integer.toString(nombre)
            + ".png";
        return readImage(path);
    }

    /**
     * Renvoie le logo Smallworld.
     * @return l'image
     */
    public static Image logoSmallworld() {
    	return readImage(ROOT_ASSETS_PATH + "logoSW.png");
    }
}

