package ui.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import jeu.TypesRegions;
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
        String path = "../assets/" + type.name().toLowerCase() + ".png";
        return readImage(path);
        
    }
    
    public static final Image peupleLogoImage(TypesPeuples type) {
        String path = "../assets/" + type.name().toLowerCase() + ".png"; 
        return readImage(path);
    }

    public static final Image peupleTroupeImage(TypesPeuples type) {
        String path = "../assets/" + type.name().toLowerCase() + "_troupe.png"; 
        return readImage(path);
    }

    public static final Image peupleTroupeDeclinImage(TypesPeuples type) {
        String path = "../assets/" + type.name().toLowerCase() + "_troupe_declin.png"; 
        return readImage(path);
    }
    
    public static final Image pouvoirLogoImage(TypesPouvoirs type) {
        String path = "../assets/" + type.name().toLowerCase() + ".png"; 
        return readImage(path);
    }
}

