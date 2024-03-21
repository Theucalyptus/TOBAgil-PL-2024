package ui.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jeu.TypesRegions;

public class ImageFactory {
    
    private static final void printErrMsg(String path) {
        System.out.println("IOException dans ImageFactory pour " + path);
    }

    public static final Image regionImage(TypesRegions type) {
        String path = "../assets/";
        
        switch (type) {
            case CHAMP:
                path = path + "champ.png";
                break;
            case FORET:
                path = path + "foret.png";
                break;
            case MONTAGNE:
                path = path + "montagne.png";
                break;
            case MARAIS:
                path = path + "marais.png";
                break;
            case MER_ET_LAC:
                path = path + "foret.png";
                break;
            case COLLINE:
                path = path + "coline.png";
                break;
            default:
                throw new RuntimeException("ImageFactory : type région non-implémenté");
        }

        Image img = null;
        try {
            img = ImageIO.read(new File(path));

        } catch (IOException e) {
            printErrMsg(path);
            System.exit(-1);
        }
        return img;
        
    }
}
