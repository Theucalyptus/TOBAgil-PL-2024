import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.swing.*;


public class MainGui {

    private static final String NOM = "SmallWorld";

    public MainGui() throws IOException {
        JFrame fenetre = new JFrame(NOM);
        
        JButton monButton = new JButton("Bouton 1");
        fenetre.getContentPane().add(monButton);
    

        BufferedImage myPicture = ImageIO.read(new File("../assets/board.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        fenetre.getContentPane().add(picLabel);
    
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}