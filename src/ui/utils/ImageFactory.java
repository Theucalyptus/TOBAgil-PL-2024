package ui.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import jeu.TypesRegions;
import jeu.batiments.TypesBatiments;
import jeu.peuples.*;
import jeu.pouvoirs.*;

public class ImageFactory {

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
        String path = "../assets/regions/" + type.name().toLowerCase() + ".png";
        return readImage(path);
        
    }
    
    public static final Image peupleLogoImage(TypesPeuples type) {
        String path = "../assets/peuples/" + type.name().toLowerCase() +  ".png"; 
        return readImage(path);
    }

    public static final Image peupleTroupeImage(TypesPeuples type, Boolean enDeclin) {
        String path = "../assets/troupes/" + type.name().toLowerCase() + (enDeclin ? "_declin" : "") + ".png"; 
        return readImage(path);
    }
    
    public static final Image pouvoirLogoImage(TypesPouvoirs type) {
        String path = "../assets/pouvoirs/" + type.name().toLowerCase() + ".png"; 
        return readImage(path);
    }

    public static final Image batimentsImage(TypesBatiments type) {
        String path = "../assets/batiments/" + type.name().toLowerCase() + ".png"; 
        return readImage(path);
    }
}

