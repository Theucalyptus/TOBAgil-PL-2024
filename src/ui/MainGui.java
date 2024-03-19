package ui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class MainGui {

    private static final String NOM = "SmallWorld";

    public MainGui() {
        JFrame fenetre = new JFrame(NOM);
        Container contenu = fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());

        TexteIcon test = new TexteIcon(new File("../assets/icon.png"), "Texte demo");
        contenu.add(test, BorderLayout.NORTH);

        // MENU DU BAS
        JPanel bas = new JPanel(new FlowLayout());
        contenu.add(bas, BorderLayout.SOUTH);
        JButton btn1 = new JButton("Bouton 1");
        btn1.addActionListener(ev -> {
            actionBouton();
        });
        bas.add(btn1);
        JButton btn2 = new JButton("Bouton 2");
        bas.add(btn2);
        JButton btn3 = new JButton("Bouton 3");
        bas.add(btn3);




        // CENTRE
        try {
            BufferedImage myPicture = ImageIO.read(new File("../assets/board.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            contenu.add(picLabel, BorderLayout.CENTER);
        } catch (IOException e) {
            throw new RuntimeException("Unhandled IOException MainGUI");
        }
    
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionBouton() {
        System.out.println("Bouton 1 cliqué !");
    }

}