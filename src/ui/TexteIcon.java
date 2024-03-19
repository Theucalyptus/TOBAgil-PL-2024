package ui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class TexteIcon extends JPanel {

    private final LayoutManager layout = new FlowLayout();
    private final JLabel textLabel;
    private JLabel imgLabel;

    public TexteIcon(File iconFile, String texte) {
        super();
        super.setLayout(this.layout);

        this.textLabel = new JLabel(texte);

        try {
                BufferedImage myPicture = ImageIO.read(iconFile);
                this.imgLabel = new JLabel(new ImageIcon(myPicture));
        } catch (IOException e) {
            System.out.println("TexteIcon erreur io fichier image icon");
            throw new RuntimeException();
        }

        super.add(this.imgLabel);
        super.add(this.textLabel);
        
    }

    public void setText(String texte) {
        this.textLabel.setText(texte);
    }

}