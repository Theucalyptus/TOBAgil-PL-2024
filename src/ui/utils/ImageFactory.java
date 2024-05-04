package ui.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import jeu.TypesRegions;
import jeu.TypesSymboles;
import jeu.batiments.TypesBatiments;
import jeu.peuples.*;
import jeu.pouvoirs.*;

public class ImageFactory {

    private static final String ROOT_ASSETS_PATH = "./assets/";

    private static final Image readImage(String path) {
        Image img = null;
        try {
            img = ImageIO.read(new File(path));

        } catch (IOException e) {
            throw new RuntimeException("IOException dans ImageFactory pour " + path);
        }
        return img;
    }


    public static final Image regionImage(TypesRegions type) {
        String path = ROOT_ASSETS_PATH + "regions/" + type.name().toLowerCase() + ".png";
        return readImage(path);

    }

    public static final Image peupleLogoImage(TypesPeuples type) {
        String path = ROOT_ASSETS_PATH + "peuples/" + type.name().toLowerCase() +  ".png";
        return readImage(path);
    }

    public static final Image peupleTroupeImage(TypesPeuples type, Boolean enDeclin) {
        String path = ROOT_ASSETS_PATH + "troupes/" + type.name().toLowerCase()
            + (enDeclin ? "_declin" : "") + ".png";
        return readImage(path);
    }

    public static final Image pouvoirLogoImage(TypesPouvoirs type) {
        String path = ROOT_ASSETS_PATH + "pouvoirs/" + type.name().toLowerCase()
            + ".png";
        return readImage(path);
    }

    public static final Image batimentsImage(TypesBatiments type) {
        String path = ROOT_ASSETS_PATH + "batiments/" + type.name().toLowerCase()
            + ".png";
        return readImage(path);
    }

    public static final Image symboleImage(TypesSymboles type) {
        String path = ROOT_ASSETS_PATH + "symboles/" + type.name().toLowerCase()
            + ".png";
        return readImage(path);
    }

    public static final Image pieceImage(int nombre) {
        String path = ROOT_ASSETS_PATH + "jetons/" + Integer.toString(nombre)
            + ".png";
        return readImage(path);
    }
}

